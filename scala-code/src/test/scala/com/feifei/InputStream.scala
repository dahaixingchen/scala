package com.feifei

;

/**
  * @Description:
  * @ClassName: InputStream
  * @Author chengfei
  * @DateTime 2021/4/9 11:07
  **/
abstract class InputStream(a:Int,b:Long) {
  def fun1(int: Int):Int ={
    return int
  }
  def fun(l:Long):Long
}

private class DefaultInputStream(a:Int,b:Long)
  extends InputStream(a,b) {
  val maxRate = b

  def maxRatePerPartition(): Long = maxRate

  override def fun(l: Long): Long = {
    l
  }
}