import org.scalatest.{FunSuite, Matchers}

/**
  * Created by juliet on 2016. 8. 6..
  */
class PatternMatchingSpec extends FunSuite with Matchers{
  test("1"){
    object MatchTest1 extends App {
      def matchTest(x:Int): String = x match {
        case 1 =>"one"
        case 2 => "two"
        case _ => "many"
      }
      matchTest(2) shouldBe "two"
//      matchTest(3)
    }
  }

  test("2"){

    val stuff = "blue"
    val myStuff = stuff match{
      case "red" =>
        println("RED");1
      case "blue" =>
        println("BLUE");2
      case "green" =>
        println("GREEN");3
      case _ => println(stuff);0
    }

    myStuff shouldBe 2
  }

  test("3"){
    val stuff = "blue"

    val myStuff = stuff match {
      case "red" ⇒ (255, 0, 0)
      case "green" ⇒ (0, 255, 0)
      case "blue" ⇒ (0, 0, 255)
      case _ ⇒ println(stuff); 0
    }

    myStuff should be( 0 , 0 , 255 )
  }

  test("4"){
    def goldilocks(expr: Any) = expr match {
      case ("porridge", "Papa") ⇒ "Papa eating porridge"
      case ("porridge", "Mama") ⇒ "Mama eating porridge"
      case ("porridge", "Baby") ⇒ "Baby eating porridge"
      case _ ⇒ "what?"
    }

    goldilocks(("porridge", "Mama")) should be( "Mama eating porridge" )

  }

  test("5"){
    def goldilocks(expr: Any) = expr match {
      case ("porridge", _) ⇒ "eating"
      case ("chair", "Mama") ⇒ "sitting"
      case ("bed", "Baby") ⇒ "sleeping"
      case _ ⇒ "what?"
    }

    goldilocks(("porridge", "Papa")) should be( "eating" )
    goldilocks(("chair", "Mama")) should be( "sitting" )
  }
  test("6"){
    def goldilocks(expr: Any) = expr match {
      case ("porridge", bear) ⇒ bear + " said someone's been eating my porridge"
      case ("chair", bear) ⇒ bear + " said someone's been sitting in my chair"
      case ("bed", bear) ⇒ bear + " said someone's been sleeping in my bed"
      case _ ⇒ "what?"
    }

    goldilocks(("porridge", "Papa")) should be( "Papa said someone's been eating my porridge" )
    goldilocks(("chair", "Mama")) should be( "Mama said someone's been sitting in my chair" )
  }
  test("7"){
    val foodItem = "porridge"

    def goldilocks(expr: Any) = expr match {
      case (`foodItem`, _) ⇒ "eating"
      case ("chair", "Mama") ⇒ "sitting"
      case ("bed", "Baby") ⇒ "sleeping"
      case _ ⇒ "what?"
    }

    goldilocks(("porridge", "Papa")) should be( "eating" )
    goldilocks(("chair", "Mama")) should be( "sitting" )
    goldilocks(("porridge", "Cousin")) should be( "eating" )
    goldilocks(("beer", "Cousin")) should be( "what?" )
  }
  test("8"){
    def patternEquals(i:Int, j:Int) = j match {
      case `i` => true
      case _ => false
    }

    patternEquals(3,3) shouldBe true
    patternEquals(7,9) shouldBe false
    patternEquals(9,9) shouldBe true

  }

  test("9"){
    val secondElement = List(1,2,3) match {
      case x :: xs => xs.head
      case _ => 0
    }
     val list = List(1,2,3)
    list.head shouldBe 1
    list.tail.equals(List(2,3)) shouldBe true
    secondElement shouldBe 2
  }

  test("10"){
    val ele = List(1,2,3) match{
      case x :: y :: xs  => y
      case _ => 0
    }
    ele shouldBe 2

    val ele2 = List(1) match{
      case x :: y :: xs  => y
      case _ => 0
    }
    ele2 shouldBe 0

    val r = List(1, 2, 3) match {
      case x :: y :: Nil ⇒ y
      case _ ⇒ 0
    }

    r should be( 0 )
  }
}
