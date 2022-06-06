package com.feifei.base.collection

;

/**
  * @Description:
  * @ClassName: OptionCollection
  * @Author chengfei
  * @DateTime 2022/6/6 20:52
  **/
object OptionCollection {
  def main(args: Array[String]): Unit = {
    /**
      * Scala中的List，Array，Set都是一样的操作方式都是类似的
      *
      */
    //todo ++ ++: 元素都是没有添加到集合里，只有=号了才加进去
    //todo += +=: 元素都会加到集合中，其中: 号的作用是把当前的元素放在最前面
    //todo ++= : 有两个 + 号的是直接加集合的拼接的
    val list = List(1, 55, 22, 3, 9, 6)
    val list1 = List(11, 55, 22, 33, 99, 66)

    println("******list++list1：两个集合的差集******")
    val intList: List[Int] = list.intersect(list1)
    intList.foreach(println)

    println("******list++list1：把两个集合的集合合并成一个新的集合******")
    val towList: List[Int] = list ++ list1
    towList.foreach(println)
    println("*****55::list：往list集合的头部插入一个数据，形成一个新的集合*****")
    val ist: List[Int] = 55 :: list
    ist.foreach(println)
    println("******list:::list1：把两个集合的集合合并成一个新的集合*****")
    val towList2: List[Int] = list ::: list1
    towList2.foreach(println)

    println("******list:+88：在集合末尾添加元素成为新的集合*****")
    val addListLast: List[Int] = list :+ 88
    list :+ list1
    addListLast.foreach(println)

    println("******88 +: list：在集合开头添加元素成为新的集合*****")
    val addListFirst: List[Int] = 88 +: list
    val list111: List[Any] = list +: list1
    addListFirst.foreach(println)

    println("******var ints:List[int]，ints ++= ints2操作，左边的ints变长了，右边的不变*****")
    var ints = List(55, 66, 88)
    var ints2 = List(555, 666, 888)
    ints ++= ints2
    ints.foreach(println)
    ints2.foreach(println)

    println("******var ints3:List[int]，ints3 ++:= ints4操作，左边的ints变长了，右边的不变*****")
    var ints3 = List(1, 2, 3)
    var ints4 = List(11, 22, 33)
    ints3 ++:= ints4
    ints3.foreach(println)
    ints4.foreach(println)
  }
}
