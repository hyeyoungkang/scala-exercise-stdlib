import org.scalatest.{FunSuite, Matchers}

/**
  * Created by juliet on 2016. 7. 27..
  */

class OptionSpec extends FunSuite with Matchers{

  test("1") {
    val someValue: Option[String] = Some("I am wrapped in something")
    someValue should be( Some("I am wrapped in something") )

    val emptyValue: Option[String] = None
    emptyValue should be( None )

  }

  test("de v"){
//    Some(123) => getOrElse(0) = 123
//    None => getOrElse(0) = 0


  }

  test("pattern matching"){

    val someValue:Option[Double] = Some(20.0)
    val value = someValue match{

      case Some(v) => v
      case None => 0.0
    }
//    value shouldBe 20.0
    value should be (20.0)
  }

  test("pattern matching 2 "){

    val someValue:Option[String] = Some("you are hansome")
    val value = someValue match {

      case Some(v) => v
      case None =>"empty"
    }

    value shouldBe "you are hansome"

  }

  test("map test"){
    val number: Option[Int] = Some(3)
    val noNumber: Option[Int] = None
    val result1 = number.map(_ * 1.5)
    val result2 = noNumber.map(_ * 1.5)

    result1 should be( Some(4.5) )
    result2 should be( None )
  }
  test("map test2"){
    val number: Option[Int] = Some(3)
    val noNumber: Option[Int] = None
    val result1 = number.fold(0)(_ * 3)
    val result2 = noNumber.fold(0)(_ * 3)


    result1 should be( 9 )
    result2 should be( 0 )
  }
}
