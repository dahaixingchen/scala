package com.feifei.base
import java.util.Date

/**
  * @todo: 半生类可以使用类中的private成员属性，但是不能使用构造函数中的参数变量
  * @return
  * @date: 2021/3/20 14:33
  */
object ObjectAndFunctions {
  def main(args: Array[String]): Unit = {
    val a = new ObjectAndFunctions(155585903)
    a.name
    val unit: Unit = fun01()
    val unit1: Unit = fun02()
    println()
  }
  println("*****1、不带等号的函数，就相当于带等号返回值为Unit的无返回值类型*****")
  println("*****写一般函数的时候，建议带上等号，可以不明确写返回值，让系统根据方法的最后一条语句推断*****")
  def fun01() {
    "我是一个普通函数"
    List(1, 2, 3, 4)
  }
  def fun02(): (Unit) = {
    "我是一个普通函数"
    List(1, 2, 3, 4)
  }
  def fun021(a:Int,b:String): (Array[Int]) ={
    List(1, 2, 3, 4)
    new Array[Int](8)
  }
  println(fun021(1,"dfs"))
  def fun03(a:Int): (Array[Int]) ={
    //创建一个8个元素的array数组
    new Array[Int](8)
  }

  println("*****2、递归函数*****")
  println("*****递归函数：要先写出终止条件*****")
  def fun04(num:Int): Int ={
    if (num == 1){
      num
    }else{
      num * fun04(num - 1)
    }
  }

  println("****3、默认值函数*****")
  def fun05(a:Int = 5,b:String = "xuxu",c:Double)={
    println(s"$a\t$b\t$c")
  }
//  fun05(1,"",2.5)

  println("****4、匿名函数：以=为分割左边是签名，（右边是实现，右边又以=>分割，左边为参数列表，右边为实现体）*****")
  println("*****匿名函数：以=为分割左边是签名，（签名这边可以直接一个签名，也可以通过=>在它的左边写上参数的类型，有点写上返回值的类型）*****")
  println("*****匿名函数是不能把一个函数作为返回值的*****")
  val fun06 = (a:Int,b:Int)=>{
    a*b-a
    (a*b-a,a)
  }
  val fun07 :(Int,Int) => (Int) = (a:Int,b:Int) =>{
    (a*b-a)
  }
  //函数作为返回值
  val fun077 :((Int,Int) => ((Int,Int)=>Int)) = (a:Int,b:Int) =>{
    (a*b-a)
    (x: Int, y: Int) => {
      x + y
    }
  }

  fun07(5,8)
  println(fun06(5,8))
  println(fun07(5,8))

  println("*****5、嵌套函数*****")
  def fun08(a:String):()=>Unit ={
    def fun05(): Unit = {
      println(a)
    }
    return fun05
  }
  println("*****6、偏应用函数：它可以用来创建多功能的其他的函数*****")
  def fun09(date:Date,tp:String,msg:String)={
    println(s"$date\t$tp\t$msg")
  }
  val info = fun09(_:Date,"info",_:String)
  val error = fun09(_:Date,"error",_:String)
  info(new Date(),"ok")
  error(new Date(),"error")

  println("*****7、偏函数：返回类型必须是PartialFunction[In,Out]类型，第一个泛型表示输入的类型，第二个泛型表示最终输出的类型*****")
  def fun091:PartialFunction[Any,String] = {
    case "hello" => "val is hello"
    case x:Int => s"$x...is int"
    case f: ObjectAndFunctions => "这是一个class类型"
    case _ => "none"
  }
  println(fun091(44))
  println(fun091("hello"))
  println(fun091("hi"))
  println(fun091(new ObjectAndFunctions(6)))


  println("*****8、可变参函数*****")
  def fun11(a:Int*)={
    for (e <- a){
      println(e)
    }
  }
  fun11(1)
  fun11(1,2,5,6,8,9,10)

  println("*****9、高阶函数：函数作为参数，函数作为返回值*****")
  def computer(a: Int, b: Int, f: (Int, Int) => Int): Unit = {
    val res: Int = f(a, b)
    println(res)
  }

  def computer9(a:Int,b:Int):Int={
    a*b
  }
  computer(3,9,(x:Int,y:Int)=>{
    (x+y)
  })
  computer(3,9,_/_)

  //函数作为返回值，返回值是一个函数
  def factory(i:String): (Int,Int)=>Int ={
    def plus(x:Int,y:Int): Int ={
      x+y
    }
    if (i.equals("+")){
      return plus
    }else{
      return (x:Int,y:Int) =>{
        x*y
      }
    }
  }
  computer(6,9,factory("+"))
  computer(6,9,factory("/"))

  println("*****10、柯里化：可以同时写若干个参数*****")
  def fun12(a:Int)(b:Int)(c:String): Unit ={
    println(s"$a\t$b\t$c")
  }
  fun12(3)(8)("sdfsdf")

  //柯里化和可变参函数的区别
  def fun10(a: Int*)(b: String*): Unit = {
    a.foreach(println)
    b.foreach(println)
  }
  fun10(1, 2, 3)("sdfs", "sss")

}


class ObjectAndFunctions(age: Int) {
  private val name = "zhansan"

  def this(iphone: String) {
    //必须要调用默认的构造函数
    this(iphone.toInt)
  }

}

object ObjectAbout{

}
