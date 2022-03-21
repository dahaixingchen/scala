package com.feifei

;

/**
  * @Description:
  * @ClassName: Test
  * @Author chengfei
  * @DateTime 2021/4/8 18:35
  **/
object Test {

  def main(args: Array[String]): Unit = {

    val kafka:InputStream  = new DirctKafka(1,5)

    //子类可以转为父类
    kafka.asInstanceOf[InputStream]
    kafka.asInstanceOf[CanCommit]

    val stream: DefaultInputStream = new DefaultInputStream(1,5)
  }




}

class Test{

  private val stream: DefaultInputStream = new DefaultInputStream(1,5)

  def fun(): Unit ={
    stream.maxRate
  }
}
