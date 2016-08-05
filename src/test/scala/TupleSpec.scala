import java.util.Date
import org.scalatest.{FunSuite, Matchers}
/**
  * Created by juliet on 2016. 8. 5..
  */
class TupleSpec extends FunSuite with Matchers{
  test("1") {
    val t = (1, "hello", Console)
    val t2 = new Tuple3(1, "hello", Console)

    assert(t == t2)
  }
  test("tuple 2 test"){
    val tuple = ("apple", "dog")
    val fruit = tuple._1
    val animal = tuple._2

    fruit shouldBe "apple"
    animal shouldBe "dog"
  }

  test("tuple 3 test"){
    val tuple5 = ("a", 1, 2.2, new Date(), "five")

    tuple5._2 shouldBe (1)
    tuple5._5 shouldBe("five")
  }

  test("tuple 4 test"){
    val tuple = ("apple", 3).swap
    tuple._1 shouldBe (3)
    tuple._2.shouldBe("apple")
  }
}
