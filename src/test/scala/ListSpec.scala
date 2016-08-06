import org.scalatest.{FunSuite, Matchers}

/**
  * Created by juliet on 2016. 8. 5..
  */
class ListSpec extends FunSuite with Matchers{
  test("list test"){
    // 1. List is immutable
    // 2. List is flat
    val a = List(1,2,3)
    val b = List(1,2,3)
    (a eq b) shouldBe false // same Object
    a == b shouldBe true // same Content
    a === b shouldBe true
    a.equals(b) shouldBe true // ==

  }

  test("nil test"){
    val a:List[String] = Nil
    val b:List[Int] = Nil

    (a == Nil) shouldBe true
    a.eq(Nil) shouldBe true
    (b == Nil) shouldBe true
    b.eq(Nil) shouldBe true

    a==b shouldBe true
    a.eq(b) shouldBe true // Nil lists are idential, event of different types
  }

  test("list create test"){
    val a = List(1,2,3)
    a.headOption should equal(Option(1))
    a.tail should equal(List(2,3))
  }

  test("accessed by option test"){
    val a = List(1,3,5,7,9)
    a(0) should equal(1)
    a(2) should equal(5)
    a(4) should equal(9)

    intercept[IndexOutOfBoundsException]{
      println("===")
      println(a(5))
      println("===")
    }
  }

  test("immutable test"){
    val a = List(1,3,5,7,9)
    val b = a.filterNot(v => v==5) //reomve where value is 5

    a should equal(List(1,3,5,7,9))
    b should equal(List(1,3,7,9))
  }

  test("many methods test"){
    val a = List(1,3,5,7,9)

    // length
    a.length  should equal(5)

    // reverse
    a.reverse should equal(List(9,7,5,3,1))

    // map
    a.map {v => v*2} should equal(List(2,6,10,14,18))

    //filter
    a.filter { v => v % 3 == 0} should equal(List(3,9))

  }

  test("_ test"){
    val a = List(1,2,3)
    a.map{
      _*2
    } should equal(List(2,4,6))

    a.filter{
      _%2 == 0
    } should equal(List(2))
  }

  test("() instead of {} test"){
    val a = List(1,2,3)
    a.map(_*2) should equal(List(2,4,6))
    a.filter(_*2 !=0) should equal(List(1,3))
  }

  test("math op test"){
    val a = List(1,3,5,7)
    a.reduceLeft(_+_) should equal(16)
    a.reduceLeft(_*_) should equal(105)
  }

  test("foldleft test"){

    val a = List(1,3,5,7)
    a.foldLeft(0)(_+_) should equal(16)
    a.foldLeft(10)(_+_) should equal(26)
    a.foldLeft(1)(_*_) should equal(105)
    a.foldLeft(0)(_*_) should equal(0)
  }

  test("range test"){
    val a = (1 to 5).toList
    a shouldBe List(1,2,3,4,5)
  }

  test("tail test"){
    val d = Nil
    val c = 3 :: d
    val b = 2 :: c
    val a = 1 :: b

    a should be ( List(1,2,3) )
    a.tail shouldBe List(2,3)
    b.tail shouldBe List(3)
    c.tail shouldBe Nil
  }
}
