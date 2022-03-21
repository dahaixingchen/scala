package com.feifei

/**
  * @Description:
  * @ClassName: CanCommit
  * @Author chengfei
  * @DateTime 2021/4/9 11:10
  **/
trait CanCommit {
  def commitAsync(offsetRanges: Long): Unit
}
