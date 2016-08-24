import org.scalatest.{Matchers, WordSpec}

/**
  * Created by juliet on 2016. 8. 24..
  */
class ClassPatternMatchingSpec extends WordSpec with Matchers{
  "Pattern Matching" should {

    "basic" in {

      // fall -through 문제가 사라짐
      // pattern matching : break문이 필요 없다
      def func1(num: Int): String = num match {
        case 1 => "one"
        case _ => "other"
      }

      func1(1) shouldBe "one"
      func1(2) shouldBe "other" // 1외의 아무 숫자나 넣었을 때

      def func2(num : Int) : Any = num match {
        case 1 => "one"
        case _ => num
      }

      func2(1) shouldBe "one"
      func2(2) shouldBe 2 // 1외의 아무 숫자나 넣었을 때
    }

    "type" in {

      def func(obj: Any): String = obj match {
        case a:Int => "number"
        case a:String => "string"
      }

      func("str") shouldBe "string" // 문자열을 넣으면
      func(1) shouldBe "number" // 숫자를 넣으면
    }

    "type2" in {
      trait Link
      class Facebook extends Link {
        def getID() = "아이디"
      }
      class Kakao extends Link {
        def getName() = "본명"
      }
      class KakaoStory extends Link {
        def getNickName() = "닉네임"
      }

      def getName(link: Link): Option[String] = link match {
        case a:Facebook => Some(a.getID())
        case a:Kakao => Some(a.getName())
        case a:KakaoStory => Some(a.getNickName())
        case _ => None
      }

      getName(new Facebook) shouldBe "아이디"
    }
  }
}
