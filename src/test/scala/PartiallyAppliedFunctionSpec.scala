package std_lib.partially_applied_functions

import com.sun.tools.classfile.Annotation.Annotation_element_value
import org.scalatest.{Matchers, WordSpec}

/**
  * Created by karellen on 2016. 9. 21..
  */
class PartiallyAppliedFunctionSpec extends WordSpec with Matchers {

  "partially applied function" should {

    "basic" in {
      def sum(a: Int, b: Int) = a + b

      val add1: (Int) => Int = sum(1, _ : Int)
      // def add1(b: Int) = 1 + b
      add1(5) shouldBe 6

      // 곱하기
      def multiply(a: Int, b: Int) : Int =a * b

      val doubled : Int => Int = multiply( 2 ,  _:Int )
      doubled(5) shouldBe 10
    }

    "curried" in {
      // _ 대신에...
      def multiply2(a: Int)(b: Int) : Int = a * b

      val doubled2 : Int => Int = multiply2(2)
      doubled2(5) shouldBe 10
    }

    "curried 2" in {
      // _ 대신에...
      def multiply3(a: Int) = (b: Int) => a*b

      val doubled3 : Int => Int = multiply3(2)
      doubled3(5) shouldBe 10
    }
//
//    "curried 33" in {
//      def sum1(a: Int, b: Int) = a + b
//      def sum2(a: Int)(b: Int) = a + b
//      def sum3(a: Int) = (b : Int) => a + b
//
//      val n1 = sum1(1, _)
//      val n2 = sum2(1)
//      val n3 = sum3(1)
//    }

    "applyList" in {
      // 응용 : 함수를 파라미터로
      // list = 1,2,3,4,5
      // func = _*2
      def applyList(func: (Int) => (Int))(list: List[Int]) : List[Int] = {
        list.map(func)
      }

      // applyList를 활용해서 리스트의 모든 값을 2배로 늘리는 함수
      // List(1,2,3)를 받으면 List(2,4,6)를 리턴
      val doubledList : (List[Int] => List[Int]) = applyList(_*2)

      doubledList(List(1,2,3)) shouldBe List(2,4,6)
    }
  }
}