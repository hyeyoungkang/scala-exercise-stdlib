package std_lib.case_class

import org.scalatest.{Matchers, WordSpec}

/**
  * Created by karellen on 2016. 8. 29..
  */
class CaseClassFuncSpec extends WordSpec with Matchers {

  "case class" should {

    "class vs case class" in {

      class Person1(val id: Int, name: String, tel: String)
      case class Person2(id: Int, name: String, tel: String)


      // 생성
      val person1: Person1 = new Person1(1, "name", "0110")
      val person2: Person2 = Person2(11, "name", "010")

      // 변수 접근 , new, val도 자동으로 넣어줌
      //person1.id
      //person2.id

      val personSame1: Person1 = new Person1(1, "name", "0110")
      val personSame2: Person2 = Person2(11, "name", "010")

      // equals
      //그냥 class == : 값이 아닌 비교 Object ID 비교
      // case class ==  : 값비교  : 자동 구현
      person1 == personSame1 shouldBe false
      person2 == personSame2 shouldBe true

      // copy
      val copyPerson1: Person1 = new Person1(1, "name", "212")
      val copyPerson2: Person2 = person2.copy(tel = "212")
    }

    "pattern match" in {
      case class Person(id: Int, name: String)

      val person = Person(1, "박보검")

      val name = person match {
        case Person(id, name) => name
      }

      name shouldBe "박보검"
    }

    "class's pattern match" in {

      class Person(val id: Int, val name: String, val lastAccess: Option[LastAccess])
      class LastAccess(val day: Int, val favorTab: Option[FavorTab])
      class FavorTab(val tab: Int)

      val person1 = new Person(1, "박보검", Some(new LastAccess(1, Some(new FavorTab(2)))))
      val person2 = new Person(2, "김수현", Some(new LastAccess(3, None)))

      showTab(person1) shouldBe 2
      showTab(person2) shouldBe 0

      // lastAccess 가 없으면 tab은 0
      // lastAccess 가 있지만, favorTab이 없으면 tab은 0
      def showTab(person: Person): Int = person.lastAccess match {
        case Some(last) => {
          last.favorTab match {
            case Some(favor) => favor.tab
            case None => 0
          }
        }
        case None => 0
      }
    }

    "case class's pattern match" in {
//
//      case class Person(id: Int, name: String, lastAccess: Option[LastAccess])
//      case class LastAccess(day: Int, favorTab: Option[FavorTab])
//      case class FavorTab(tab: Int)
//
//      val person1 = Person(1, "박보검", Some(LastAccess(1, Some(FavorTab(2)))))
//      val person2 = Person(2, "김수현", Some(LastAccess(3, None)))
//
//      showTab(person1) shouldBe 2
//      showTab(person2) shouldBe 0
//
//      // lastAccess 가 없으면 tab은 0
//      // lastAccess 가 있지만, favorTab이 없으면 tab은 0
//      def showTab(person: Person): Int = person match {
//        case Person(id, name, Some(LastAccess(day, Some(FavorTab(tab))))) => tab
//        case _ => 0
//      }

      def fib(n: Int): Int = {
        @annotation.tailrec
        def loop(n: Int, prev: Int, cur: Int): Int =
          if (n <= prev ) prev
          else loop(n - cur , cur, prev + cur)
        loop(n, 0, 1)
      }
      fib(5) shouldBe(5)

    }
  }
}