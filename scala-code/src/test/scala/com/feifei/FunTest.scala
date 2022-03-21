package com.feifei

import java.sql.Time

import scala.reflect.runtime.universe.TypeTag


;

/**
  * @Description:
  * @ClassName: FunTest
  * @Author chengfei
  * @DateTime 2021/4/13 10:38
  **/
object FunTest {


  def batchRun(rawRdd: (String, String), batchTime:Time): Unit = {
    println("sdaf")
    println("sdaf")
    println("sdaf")
    println("sdaf")
  }

  def defaultStreamingProcess[T: TypeTag](arrangeOffsetChecker: String, process: T): Unit = {
    println("defaultStreamingProcess")

  }

  def main(args: Array[String]): Unit = {
    defaultStreamingProcess[((String, String), Time) => Unit]("sadf", batchRun)




println(System.currentTimeMillis())

//    computer[(Int,Int)=>Int](3,9,fun)

    computer(3,9,fun)
  }

  def computer(a: Int, b: Int, f: (Int, Int) => Int): Unit = {
//    val res: Int = f(a, b)
    println("comsd*********")
  }

//  def computer[T:TypeTag](a: Int, b: Int, f: T): Unit = {
//    val res: Int = f(a, b)
//    println(res)
//  }

  def fun(a:Int,b:Int):Int={
    println("woshi fun")
    a*b
  }
}
