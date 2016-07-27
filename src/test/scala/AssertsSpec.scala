/**
  * Created by juliet on 2016. 7. 27..
  */
import org.scalatest.{FunSuite, Matchers}

class AssertsSpec extends FunSuite with Matchers{

  test("1") {
    val left = 2
    val right = 1
    assert( left == right)

  }

  test("2") {
    true should be( true )
  }


  test("3"){
    val v1 = 4
    v1 shouldEqual 4
  }


  test("4"){
    assert( 2 == 1 + 1)
  }

}
