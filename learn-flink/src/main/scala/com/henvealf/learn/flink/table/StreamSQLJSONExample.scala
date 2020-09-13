package com.henvealf.learn.flink.table

import com.alibaba.fastjson.JSONObject
import org.apache.flink.api.java.utils.ParameterTool
import org.apache.flink.api.scala._
import org.apache.flink.streaming.api.scala.{DataStream, StreamExecutionEnvironment}
import org.apache.flink.table.api._
import org.apache.flink.table.api.bridge.scala._

import collection.JavaConverters._

/**
  * Simple example for demonstrating the use of SQL on a Stream Table in Scala.
  *
  * <p>Usage: <code>StreamSQLExample --planner &lt;blink|flink&gt;</code><br>
  *
  * <p>This example shows how to:
  *  - Convert DataStreams to Tables
  *  - Register a Table under a name
  *  - Run a StreamSQL query on the registered Table
  *
  */
object StreamSQLJSONExample {

  // *************************************************************************
  //     PROGRAM
  // *************************************************************************

  def main(args: Array[String]): Unit = {

    val params = ParameterTool.fromArgs(args)
    var planner = if (params.has("planner")) params.get("planner") else "blink"

    planner = "blink"
    // set up execution environment
    val env = StreamExecutionEnvironment.getExecutionEnvironment
    val tEnv = if (planner == "blink") {  // use blink planner in streaming mode
      val settings = EnvironmentSettings.newInstance()
        .useBlinkPlanner()
        .inStreamingMode()
        .build()
      StreamTableEnvironment.create(env, settings)
    } else if (planner == "flink") {  // use flink planner in streaming mode
      val settings = EnvironmentSettings.newInstance()
        .useOldPlanner()
        .inStreamingMode()
        .build()
      StreamTableEnvironment.create(env, settings)
    } else {
      System.err.println("The planner is incorrect. Please run 'StreamSQLExample --planner <planner>', " +
        "where planner (it is either flink or blink, and the default is blink) indicates whether the " +
        "example uses flink planner or blink planner.")
      return
    }

    val json1 = new JSONObject();
    json1.putAll(Map( "id" -> 1, "name" -> "beer", "age" -> 12 ).asJava)

    val json2 = new JSONObject();
    json2.putAll(Map( "id" -> 2, "name" -> "diaper", "age" -> 0 ).asJava)

    val json3 = new JSONObject();
    json3.putAll(Map( "id" -> 3, "name" -> "rubber", "age" -> 1 ).asJava)

    val json4 = new JSONObject();
    json4.putAll(Map( "id" -> 4, "name" -> "pen", "age" -> 43 ).asJava)

    val json5 = new JSONObject();
    json5.putAll(Map( "id" -> 5, "name" -> "rubber", "age" -> 12 ).asJava)

    val json6 = new JSONObject();
    json6.putAll(Map( "id" -> 6, "name" -> "beer", "age" -> 32 ).asJava)

    val orderA: DataStream[Order] = env.fromCollection(Seq(
      json1,
      json2,
      json3))
      .map((json) => Order(json.getLongValue("id"), json.getString("name"), json.getIntValue("age")))

    val orderB: DataStream[Order] = env.fromCollection(Seq(
      json4,
      json5,
      json6))
      .map((json) => Order(json.getLongValue("id"), json.getString("name"), json.getIntValue("age")))


    // convert DataStream to Table
    val tableA = tEnv.fromDataStream(orderA, $"id", $"name", $"age")
    // register DataStream as Table
    tEnv.createTemporaryView("OrderB", orderB, $"id", $"name", $"age")

    // union the two tables
    val result: Table = tEnv.sqlQuery(
      s"""
         |SELECT * FROM $tableA WHERE age > 2
         |UNION ALL
         |SELECT * FROM OrderB WHERE age < 2
        """.stripMargin)

    result.toAppendStream[Order].print()

    env.execute()
  }

  // *************************************************************************
  //     USER DATA TYPES
  // *************************************************************************

  case class Order(user: Long, product: String, amount: Int)

}
