println("hello")
import shapeless._

// 1번 퀴즈
// HList 를 만드는데 string, int, boolean

val hList = HList("hello", 20, true)
val hListA: ::[String, ::[Int, ::[Boolean, HNil]]] =  "hello" :: 20 :: true :: HNil

hListA.tail.head

hListA(0)





val tupleA: (String, Int, Boolean) = ("hello", 20, true)
val a: Int = tupleA._2



val listA: List[Any] = List("hello", 20, true)
val b: Any = listA.tail.head

 // type기반
// list는 타입을 잃어 버린다
// hlist는 타입을 유지 하고 있다.

case class Employee(name: String, number: Int, manager: Boolean)
case class IceCream(name: String, numCherries: Int, inCone: Boolean)

def employeeCsv(e: Employee): List[String] =
  List(e.name, e.number.toString, if (e.manager) "y" else "n")

def iceCreamCsv(e: IceCream): List[String] =
  List(e.name, e.numCherries.toString, if (e.inCone) "y" else "n")

val e = Employee("edina", 1, true)
val i = IceCream("vera", 0, false)

//val genericEmployee = Generic[Employee].to(Employee("juliet", 100, false))
//val genericIceCream = Generic[IceCream].to(IceCream("cherry", 10, false))

e.toString
employeeCsv(e)

i.toString
iceCreamCsv(i)

// 각각의 도메인
val e1 = Generic[Employee].to(e)
val i1  = Generic[IceCream].to(i)

def toCsv(s:String :: Int :: Boolean :: HNil): List[String]={
  List(s.head, s.tail.head.toString, if(s.tail.tail.head == true) "yes" else "no")
}

//toCsv(e1)
//toCsv(i1)

// 관심사의 분리
// 각각의 도메인 있고 공통된 도메인(core)


