/**
  * Created by juliet on 2016. 7. 27..
  */
import org.scalatest.{FunSuite, Matchers}

class ObjectSpec extends FunSuite with Matchers{

  object Juliet {
    def name = "hyeyoung"
    def familyname="kang"
  }

  test("object"){
    Juliet.name should be ("hyeyoung")
  }

  test("object is singleton"){

    val x = Juliet
    val y = x

    // == 스칼라는 값을 비교 자바는 레퍼런스 비교
    // equals 자바에서 사용하는 값비교
    // eq 레퍼런스 비교

    x eq y shouldBe true

    class Foo
    val a = new Foo
    val b = new Foo
    a eq b should be (false)

    a==b should be ( false)

  }


  test("companion "){
    class Movie(val name:String, val year:Short)

    object Movie{
      def apply(year:Short, name:String):Movie = new Movie(name, year)

    }

    Movie(1992, "쥴리엣") // == new Movie("쥴리엣", 1994)
    // compainion object를 통하여 private 변수등으 접근 할수 있음
  }

}
