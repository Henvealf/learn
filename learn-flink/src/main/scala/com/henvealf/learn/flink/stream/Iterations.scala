package com.henvealf.learn.flink.stream

import org.apache.flink.api.scala._
import org.apache.flink.streaming.api.scala.StreamExecutionEnvironment

/**
  * 不清楚是啥意思
  * iteration 的使用
  * @author hongliang.yin/Henvealf  
  * @date 2019-09-19
  */
object Iterations {
  def main(args: Array[String]): Unit = {
    val env = StreamExecutionEnvironment.getExecutionEnvironment
    val executionConfig = env.getConfig

    val someIntegers = env.generateSequence(0, 10)
    val iteratedIntegers = someIntegers.iterate(
      iteration => {
      val minusOne = iteration.map( v => v - 1)
      val stillGreaterThanZero = minusOne.filter (_ > 0)
      val lessThanZero = minusOne.filter(_ >= 5)
      (stillGreaterThanZero, lessThanZero)
      }
    )
    iteratedIntegers.print()
    env.execute()

  }
}
