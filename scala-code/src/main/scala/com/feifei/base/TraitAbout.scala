package com.feifei.base

object TraitAbout{
  def main(args: Array[String]): Unit = {
    val xuxu = new TraitAbout("xuxu")
    xuxu.hello()
    xuxu.say()
    xuxu.ku()

  }
}

// Scala中的类可是实现多个train，相当于接口，并且要实现train中没有实现的函数
class TraitAbout(name:String)  extends   God1 with Mg1 with H1  {

  def hello(): Unit ={
    println(s"$name say hello")
  }

  override def haiRen(): Unit = {
    println("ziji shixian ....")
  }

  override def haha(l: Long): (Int, Int) => Long = {
    return (a:Int,b:Int)=>{
      a.toLong
    }
  }
}


trait  God1{
  def say(): Unit ={
    println("god...say")
  }
}

trait Mg1{
  def ku(): Unit ={
    println("mg...say")
  }
  def haiRen():Unit
  def haha(l: Long):(Int,Int)=>(Long)
}

trait H1{
  def haha(l: Long):(Int,Int)=>(Long)
}