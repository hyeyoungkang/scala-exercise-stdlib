import org.scalatest.{FunSuite, Matchers}

/**
  * Created by juliet on 2016. 8. 6..
  */
class FormattingSpec extends FunSuite with Matchers{
  test("1"){
    val s = "Hello World"
    "Applications %s".format(s) shouldBe "Applications Hello World"
    var a = 'a'
    var b = 'B'

    //format(a) is a string format
    "%c".format(a) shouldBe "a"
    "%c".format(b) shouldBe "B"
  }
  test("2"){
    val c = '\u0061' //unicode for a
    val d = '\141' //octal for a
    val e = '\"'
    val f = '\\'

    "%c".format(c) should be( "a" )
    "%c".format(d) should be( "a" )
    "%c".format(e) should be( "\"" )
    "%c".format(f) should be( "\\" )

    val j = 190
    "%d bottles of beer on the wall" format j - 100 shouldBe "90 bottles of beer on the wall"
    val k = "vodka"
    "%d bottles of %s on the wall".format(j-100, k) shouldBe "90 bottles of vodka on the wall"
  }

}
