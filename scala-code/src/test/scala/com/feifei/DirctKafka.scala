package com.feifei

/**
  * @Description:
  * @ClassName: DirctKafka
  * @Author chengfei
  * @DateTime 2021/4/9 11:09
  **/
private class DirctKafka(aa:Int,bb:Long) extends InputStream(aa,bb) with CanCommit {
  override def fun(l: Long): Long = {
    return l
  }

  override def commitAsync(offsetRanges: Long): Unit = {
    println("sfdfa")
  }
}
