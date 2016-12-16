package std_lib.partial_functions

import org.scalatest.{Matchers, WordSpec}

/**
  * Created by karellen on 2016. 10. 10..
  */
class PartialFuncSpec extends WordSpec with Matchers {

  "partial function" should {

    "basic" in {
      val bigger = new PartialFunction[Int, String] {
        def isDefinedAt(num: Int) = num > 10
        def apply(num: Int) = "많다"
      }

      val smaller = new PartialFunction[Int, String] {
        def isDefinedAt(num: Int) = num <= 10
        def apply(num: Int) = "적다"
      }

      val myFunc: PartialFunction[Int, String] = smaller.orElse(bigger)

      myFunc(5) shouldBe "적다"
    }

    "PartialFunction" in {
      val one = new PartialFunction[Int, String] {
        def isDefinedAt(num: Int) = num == 1
        def apply(num: Int) = "one"
      }

      val two = new PartialFunction[Int, String] {
        def isDefinedAt(num: Int) = num == 2
        def apply(num: Int) = "two"
      }

      val wildcard = new PartialFunction[Int, String] {
        def isDefinedAt(num: Int) = true
        def apply(num: Int) = "something else"
      }

      val partial: PartialFunction[Int, String] = one orElse two orElse wildcard
      partial(1) shouldBe "one"
    }

    "case" in {
      // 케이스 문을 사용해서 PartialFunction 생성
      val one: PartialFunction[Int, String] = { case 1 => "one"}
      val two: PartialFunction[Int, String] = { case 2 => "two"}
      val wildcard: PartialFunction[Int, String] = { case _ => "something else"}

      val partial : PartialFunction[Int, String] = one orElse two orElse wildcard
      partial(1) shouldBe "one"
    }

    "match case" in {
      // match - case를 사용해서 위의 partial 함수를 구현
      def partial(num : Int) : String = num match{
        case 1 => "one"
        case 2 => "two"
        case _ => "other"
      }

      partial(1) shouldBe "one"
    }

    "and" in {
      val positive: PartialFunction[Int, Int] = { case n if n > 0 => n + 1 }
      val double: PartialFunction[Int, Int] = { case n if n > 10 => n * 2 }

      val partial : PartialFunction[Int, Int] = positive.andThen(double)
      partial(2) shouldBe 3
    }
  }
}