package com.henvealf.learn.flink.stream

// 不 import _ 会抛出类型异常。
import org.apache.flink.streaming.api.scala._
import org.apache.flink.streaming.api.windowing.time.Time

/**
  * 窗口的 word count 数据源是 socket，sink 是标准输出
  *
  * nc -lk 4567
  *
  * @author hongliang.yin/Henvealf  
  * @date 2019-09-19
  */
object WindowWordCount {
  def main(args: Array[String]): Unit = {
    val env = StreamExecutionEnvironment.getExecutionEnvironment
    val text = env.socketTextStream("localhost", 4567)
    val count = text.flatMap(text => text.split("\\W+")).filter(_.nonEmpty)
      .map((_, 1))
      .keyBy(0)
      .timeWindow(Time.seconds(3))
      .sum(1)

    count.print()
    env.execute("First streaming word count job")
  }
}
