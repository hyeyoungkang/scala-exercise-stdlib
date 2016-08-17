import org.scalatest.{FunSuite, Matchers}

/**
  * Created by juliet on 2016. 8. 5..
  */
class HigherOrderFunctionsSpec extends FunSuite with Matchers{
  test("function vs method"){
    // method
    def foo(a:String) : String ={
      a+a
    }

    // function
//    val convertStr:String = { (x: Int) => { x.toString } }

    def MyFirst(f : Int => String) :String ={
      f(10)
    }

    def mH(value:Int)(x:Int => String):String ={
      x(value)
    }

    // 고차 함수 API를 잘 활용해 보자
    // map, fold, reduce, flatMap
    val list = List(1,2,3)
    list.map(_+10) shouldBe List(11,12,13)
    list.map(_*10) shouldBe List(10,20,30)
    list.reduce(_ + _) shouldBe 6
    list.reduce( (x, y) => x+y)

    list.sum

    list.reduce(_*_) shouldBe 6

    // fold는 초기값을 줄수 있음
    // reduce 첫번째 값이 초기값이 됨
    list.foldLeft(1)(_*_) shouldBe 6

//    list.fold shouldBe 6
    list.reduce( (x, y) => x*y) shouldBe 6
    // flatMap => map + flatten
    list.flatMap{ i => List(i *11, i*11+1) } shouldBe List(11,12,22,23,33,34)
  }

 test("lamda test"){
   def lambda = {x:Int => x+1}
   def lambda2 = (x:Int) => x+1
   val lambda3 = (x:Int) => x+1

   // method
   //def
   // function :
   //val

   val lambda4 = new Function1[Int, Int]{
     def apply(v1:Int) :Int = v1+1
   }

   def lambda5(x:Int) = x+1

   val result = lambda(3)
   val `result1andhalf` = lambda.apply(3)

   val result2 = lambda2(3)
   val result3 = lambda3(3)
   val result4 = lambda4(3)
   val result5 = lambda5(3)

   result shouldBe (4)
   result1andhalf shouldBe 4
   result2 shouldBe 4
   result3 shouldBe 4
   result4 shouldBe 4
   result5 shouldBe 4

 }
  test("lambda 2") {
    def lambda = (x:Int) => x+1
    def result = lambda(5)
    result shouldBe (6)
  }

  test("closure test"){
    var incrementer = 1

    def closure = {
      x : Int => x + incrementer
    }
    val result1 = closure(10)
    result1 shouldBe 11
    incrementer = 2
    val result2 = closure(10)
    result2 shouldBe (12)

  }

  test("closure2 test"){
    // we can tate that closure and throw into a method
    // and it will still hold the environment
    def summation(x:Int, y:Int => Int) = y(x)

    var incrementer = 3
    def closure = (x:Int) => x + incrementer

    val result = summation(10, closure)
    result shouldBe 13

    incrementer = 4
    val result2 = summation(10, closure)
    result2 shouldBe 14
  }

  test("function return another function test"){
    def addWithoutSyntaxSugar(x:Int) = {
      new Function1[Int, Int](){
        def apply(y:Int) : Int = x+y
      }
    }
    addWithoutSyntaxSugar(1).isInstanceOf[Function1[Int, Int]] shouldBe true
    addWithoutSyntaxSugar(2)(3) shouldBe 5
    def fiveAdder = addWithoutSyntaxSugar(5)
    fiveAdder(5) shouldBe 10
  }

  test("anonymous function test") {
    def addWithSyntaxSugar(x: Int) = (y: Int) => x + y

    addWithSyntaxSugar(1).isInstanceOf[Function1[Int, Int]] shouldBe true

    addWithSyntaxSugar(2)(3) shouldBe 5
    def fiveAddr = addWithSyntaxSugar(5)
    fiveAddr(5) shouldBe 10
  }

  test("single underline test"){
    def addWithSyntaxSugar(x:Int) = (y:Int) => x+y
    addWithSyntaxSugar(1).isInstanceOf[Function1[_,_]] shouldBe true
  }

  test("test"){
    def makeUpper(xs : List[String]) = xs.map{
      _.toUpperCase
    }

    def makeWhatEverYouLike( xs : List[String], sideEffect:String=>String): List[String]={
      xs.map(sideEffect)
    }

    makeUpper(List("abc", "xyz", "123")) shouldBe List("ABC", "XYZ", "123")

    makeWhatEverYouLike(List("ABC", "XYZ", "123"), {x=>x.toLowerCase}) shouldBe List("abc", "xyz", "123")
    List("scala", "Erlang", "Clojure") map {
      _.length
    } shouldBe (List(5,6,7))
  }
}

