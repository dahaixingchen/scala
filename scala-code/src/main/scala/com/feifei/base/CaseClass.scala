package com.feifei.base

object CaseClass {
  def main(args: Array[String]): Unit = {
    val xiaohei = new Dog("xiaohei",2)
    val xiaohuang = new Dog("xiaohuang",2)
    val xiaohei1 = Dog("xiaohei",2)
    println(xiaohei.age)
    println(xiaohei.equals(xiaohuang))
    println(xiaohei.equals(xiaohei1))
  }
}

//样例类，本身具有，1、不用new就可以创建
//2、有类似的get方法，equals()比较的是内容，不是对象
case class Dog(name:String,age:Int)
