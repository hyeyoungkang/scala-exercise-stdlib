import org.scalatest.{FunSuite, Matchers}

/**
  * Created by juliet on 2016. 8. 7..
  */
class CaseClassSpec extends FunSuite with Matchers{
  test("1"){
    abstract class Term
    case class Var(name: String) extends Term
    case class Fun(arg: String, body: Term) extends Term
    case class App(f: Term, v: Term) extends Term

    val x = Var("x")
    Console.println( x.name )
    println( x.name )

    val x1 = Var("x")
    var x2 = Var("x")
    var y1 = Var("y")

    println("" + x1 + " == " + x2 + " => " + (x1 == x2))
    println("" + x1 + " == " + y1 + " => " + (x1 == y1))

  }

  test("eq"){
    case class Person(first: String, last: String)

    val p1 = new Person("Fred", "Jones")
    val p2 = new Person("Shaggy", "Rogers")
    val p3 = new Person("Fred", "Jones")

    (p1 == p2) should be( false )
    (p1 == p3) should be( true )

    (p1 eq p2) should be( false )
    (p1 eq p3) should be( false )

    (p1.hashCode == p2.hashCode) should be( false )
    (p1.hashCode == p3.hashCode) should be( true )
  }
  test("create way"){
    case class Dog(name: String, breed: String)

    val d1 = Dog("Scooby", "Doberman")
    val d2 = Dog("Rex", "Custom")
    val d3 = new Dog("Scooby", "Doberman") // the old way of creating using new

    (d1 == d3) should be( true )
    (d1 == d2) should be( false )
    (d2 == d3) should be( false )

  }
  test("toStringMethodCaseclass"){
    case class Dog(name: String, breed: String)
    val d1 = Dog("Scooby", "Doberman")
    d1.toString should be ( "Dog(Scooby,Doberman)" )
  }

  test("serializable test"){
    case class PersonCC(firstName: String, lastName: String)
    val indy = PersonCC("Indiana", "Jones")

    indy.isInstanceOf[Serializable] should be( true )

    class Person(firstName: String, lastName: String)
    val junior = new Person("Indiana", "Jones")

    junior.isInstanceOf[Serializable] should be( false )
  }
}
