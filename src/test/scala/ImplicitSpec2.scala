import org.scalatest.{FunSuite, Matchers}

/**
  * Created by juliet on 2016. 11. 2..
  */
class ImplicitSpec2  extends FunSuite with Matchers {
  test("dd") {
    def foo(a: Int): String = {
      a + " " + a
    }

    var bar: Int = 10
    // 명시적
    println(foo(10))
    // 암묵적으로 함ㅅ의 파라미터를 바인딩 하고 싶다

    // 찾는 조건
    // 1. 같은 타입이어야 한다
    // 2. 현재 스코프 implicit로 선언된 변수를 찾는다
    // 3. import 된 스코프 implicit
    // 4. companion object implicit
    def foo2(implicit a: Int): String = {
      a + " " + a
    }
    implicit val bar2: Int = 200
    println(foo2)
  }

//  object juliet {
//    implicit val j = " yuyu "
//  }

  test("example"){

    // 1. 함수의 인자를 implicit 으로 받는 함수를 만든다
    // 2. implicit 변수도 만든다
    // 3. 실해 ㅇ해보기
    // 4. 다양한 scope 에 넣어서 실행해 보자
    // 5. 현재 찾을수 잇는 scope에 같은 타입의 implict dl 2개 이상이면 어떻게 되나 -- complie time오류가 난다 
    def julie(implicit a: String ): String ={
      a + " is " + " a good man "
    }

    implicit val p : String = " BoGUM "
//    implicit val p3 : String = " BoGUM "
    implicit val p2 : Int = 2

    println(julie)

  }


  test("함수의 implicit "){
    // 형변환

    //int -> string
    def foo(a : Int ): String = a.toString + " " + a.toString

    println(foo(10))

    val foo1: String = foo(10)

    case class Alcol(name:String)
    case class Edina(want : String)

    implicit def to(edina: Edina): Alcol = Alcol(edina.want)

    def edina= Edina("와인")
    println(to(edina))

    // 현재의 타입에서 ㅂ뀔 타입으로 ㄱ성된 implicit 함수를 찾습니다
    val alcol: Alcol = edina
    val alcol2: Alcol = to(edina)

  }

}
