package com.feifei.base

import scala.collection.immutable.ListMap
import scala.collection.mutable
import scala.util.control.Breaks._

object CollectionsAndFor {
  def main(args: Array[String]): Unit = {

    //************************************************************************
    println("******for循环中的 后面跟着if的操作,这种操作等于把if语句写在for里面也是一样的*****")
    for (elem <- 1 to 10 if elem % 2 == 0) {
      println(elem)
    }

    println("******for循环中的 brake 操作*****")
    //在Scala中实现break的操作
    breakable {
      for (elem <- 1 to 10) {
        if (elem == 8) {
          println(elem)
          break()
        }
        println(elem)
      }
    }

    println("******for循环中的 continue 操作：可以使用if条件的方式把数据过滤掉*****")
    for (elem <- 1 to 10) {
      if (elem != 2 && elem != 6) {
        println(elem)
      }
    }
    println("*****mutable.ListBuffer：可以添加元素的集合*****")
    val listBuffer = new mutable.ListBuffer[Int]()
    listBuffer.+=(22)
    //    listBuffer.++ list
    listBuffer.foreach(println)

    println("*****集合中的遍历方式：利用函数式编程的方式*****")
    val listStr = List(
      "hello world",
      "hello msb",
      "good idea"
    )
    listStr.flatMap(_.split(" ")).map((_, 1)).foreach(println)

    println("*****集合中的遍历方式：利用迭代器的方式，这样没有数据的复制*****")
    listStr.iterator.flatMap(_.split(" ")).map((_, 1)).foreach(println)

    println("*****Map的数据结构中，如果key相同，value一般都会被覆盖*****")
    println("*****Map的遍历，利用keySet的方式*****")
    val map: Map[String, String] = ListMap(
      "sdfa" -> "val"
      , "sdfa" -> "val2"
      , "sdfa" -> "val2fgdhghfgh"
      , "sdfa" -> "vajtjrtyjtgujl2"
      , "sdfa2" -> "val"
      , "sdfa4" -> "val"
      , "sdfa3" -> "val")
    for (k <- map.keySet) {
      println(k)
      map.get(k).foreach(e => println(e))
    }

    println("*****Map的遍历，把map变成元组的方式*****")
    map.foreach(kv => {
      println(kv._1)
      println(kv._2.size)
    })

    println("*****Map的遍历，直接使用元组的方式遍历*****")
    for ((k, v) <- map) {
      println(k)
      println(v)
    }

    println("*****元组的遍历*****")
    val tuple: ((String, String), (String, String), (String, String), (String, String), (String, String)) =
      (("sdfa", "val"), ("sdfa", "val2"), ("sdfa2", "val2"), ("sdfa3", "val2"), ("sdfa4", "val2"))

  }

  /**
    * @Todo: 迭代器在的应用
    * @return:{@link null}
    * @DateTime: 2022/1/2 12:23
    */
  println("--------------艺术-------------")
  val list = List(2.36, 4, 5, 6, 3.99, 4.654)
  val list10 = List(1, 5, 6, 2, 7, 5)
  val doublesList: List[Double] = list.map((x) => {
    x + 10
  })
  val doubles: List[Double] = doublesList.map(_ * 10)

  println("--------------艺术-升华-------------")
  val listStr = List(
    "hello world",
    "hello msb",
    "good idea"
  )
  listStr.foreach(println)
  val flatMapList: List[String] = listStr.flatMap(_.split(" "))
  flatMapList.foreach(println)
  val tuplesWord: List[(String, Int)] = flatMapList.map((_, 1))
  //这里得到的是一个新的数据集，操作不是指针，是数据本身，数据会以对象的形式存放在内存中，所有你打印的时候，每次打印都是有真实的数据给到你
  tuplesWord.foreach(println)
  tuplesWord.foreach(println)

  println("--------------艺术-再升华-------------")

  //利用迭代器模式去拿数据，它操作的是指针，迭代器本身不存数据，所以它能节省很多的存储，适合用在大数据的场景下
  val iter: Iterator[String] = listStr.iterator
  val tuples: Iterator[(String, Int)] = iter.flatMap(_.split(" ")).map((_, 1))
  tuples.foreach(println)
  tuples.foreach(println)
  //上面操作已经把迭代器的指针指向了最后，所有在此打印的话，就只能打印就不行了
  val tuplesIter: Iterator[(String, Int)] = tuples
  while (tuplesIter.hasNext) {
    val tuple: (String, Int) = tuplesIter.next()
    println(tuple)
  }


}
