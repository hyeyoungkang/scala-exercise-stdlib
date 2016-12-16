

class Person1(val id : Int, name : String, tel : String)
case class Person2(id : Int, name : String, tel : String)

val person1 : Person1 = new Person1(1, "n줌 ame", "0110")
val person2 : Person2 = Person2(11, "name", "010")

person1.toString()

person2.toString()
val copyPerson1 : Person1 = new Person1(1, "name", "212")
val copyPerson2 : Person2 = person2.copy(tel="212")

val set = Set(1,2,3)

val add: Set[Int] = set ++ Set(4,5)
val sub: Set[Int] = set -- Set(2)

val set1 = Set(1,2,3)
val set2 = Set(2,3,4,5)

val both: Set[Int] = set1.intersect(set2)
val sum: Set[Int] = set1.union(set2)

val sub1: Boolean = set1.subsetOf(Set(1,2,3,4))
val sub3 = set1.subsets(2).toList

val list = Range(0,10)
val from1To9: Range = 1 to 10
val from1To10: Range = 1 until 10

val i1: Int = 12
i1 to 14
i1.toHexString



//  fib(5) shouldbe(5)