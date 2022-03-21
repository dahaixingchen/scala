package com.feifei.base

import java.util

/**
 * @todo: 隐式转换相关问题
 * @return
 * @date: 2021/3/27 11:02
 */
object ImplicitAbout {
  def main(args: Array[String]): Unit = {
    val javaListLinked = new util.LinkedList[Int]()
    javaListLinked.add(1)
    javaListLinked.add(2)
    javaListLinked.add(3)
    val javaListArray = new util.ArrayList[Int]()
    javaListArray.add(11)
    javaListArray.add(22)
    javaListArray.add(33)

    val scalaList = List(111,222,333)
    scalaList.foreach(println)
    //java 中的list是没有foreach的方法
//    listArray.forEach(println)

    //1、既然没有那我就写一个foreach这样的方法
    def foreach[T](list:util.LinkedList[T],f:(T)=>Unit):Unit={
      val iter: util.Iterator[T] = list.iterator()
      while (iter.hasNext){
        f(iter.next())
      }
    }
    //这样能实现javaLinkList可以使用这样方法，有两个问题，
    //第一ArrayList不能用，
    // 第二，不能直接成为ArrayList和LinkList里的一个方法
    foreach(javaListLinked,println)
//    foreach(javaListArray,println)//报错
    //第一个问题

    //2、第二版foreach
    def foreach2[T](list: util.List[T],f:(T)=>Unit): Unit ={
      val iter: util.Iterator[T] = list.iterator()
      while (iter.hasNext) f(iter.next())
    }
    foreach2(javaListArray,println)
    foreach2(javaListLinked,println)

    //第二个问题可以利用类里写foreach的方法，把它点出来
    val classArrayList = new XXX1(javaListArray)
    classArrayList.foreach(println)

    val classLinkList = new XXX1(javaListLinked)
    classLinkList.foreach(println)

    //3、如果能把 classArrayList变成javaListArray，然后隐藏掉这个类，就完美了
    //这样就能实现：给源码中已经封装好的类新增方法，而不动源码内容
    //通过隐式转换方法来实现
//    implicit def sdfas[T](list:util.List[T])={
//      val iter: util.Iterator[T] = list.iterator()
//      new XXX(iter)
//    }
    //隐式转换的方法名无所谓，关键是入参和返回值
    implicit def sdfasss[T](list:util.List[T])={
      new XXX1(list)
    }
    println("*****到此为止就已经实现了隐式转换方法就完成了*****")
    javaListArray.foreach(println)
    javaListLinked.foreach(println)

    println("*****隐式转化变量*****")
    implicit val dsdf:String = "xuxu"
//    implicit val dsdfsdfa:String = "zhangsan" //报错，整个文件一种类型只能有一个隐式值
    implicit val sfa:Double = 95.6

    def fun(age :Int)(implicit name:String): Unit ={
      println(s"$name\t$age")
    }
//    def fun1(age :Int,implicit name:String): Unit ={
//      println(s"$name\t$age")
//    }// 这种写法是报错的，隐式转化变量一定要利用柯里化的方式写成另外一个参数

    fun(25)
    fun(28)("chengfei")



  }
}
class XXX1[T](list:util.List[T]){
  //跟上面的方式是一样的，类里已经定义了T这个泛型，下main的foreach方法中就不要定义了
  def foreach(f:(T)=>Unit): Unit ={
    val iter: util.Iterator[T] = list.iterator()
    val t: T = iter.next()
    while (iter.hasNext) f(iter.next())
  }
}
class XXX[T](list:util.Iterator[T]){

  def foreach( f:(T)=>Unit): Unit ={

    while(list.hasNext) f(list.next())
  }

}
