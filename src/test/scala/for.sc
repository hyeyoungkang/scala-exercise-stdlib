import scala.collection.immutable.Seq
import scala.collection.mutable

//val list1 = List(1,2,3)
//
//val list2 = List(2,3)
//val result = List(2,4,6,3,6,9)
//
////list.map(m => m*m)
//list1.map( m => list2.map(n => n * m)).flatten
//

//for{
// n <- list1
//} yield n * n


val myList = mutable.ArrayBuffer(1)
//val myList2 = mutable.Buffer[Int]


def findFirst[A](as:Array[A], p:A => Boolean): Int = {
  @annotation.tailrec
  def loop2(n: Int) : Int =
    if( n>= as.length) -1
    else if (p(as(n))) n
    else loop2(n+1)

  loop2(0)
}

val myList2: Array[Int] =Array(4,5,6,8)
val myList3: Array[Int] =Array(4,9,6,1)

// 함수 method
def orderedFun(a:Int, b:Int) : Boolean = { a<b }

def orderedFun : (Int, Int) => Boolean = (a : Int, b: Int) => a<b


val predicate4 : (Int, Int) => Boolean = new ((Int, Int) => Boolean){
  override def apply(v1: Int, v2:Int ): Boolean = v1<v2
}

// 제 2장 연습문제 2.2
def isSorted[A](as: Array[A], ordered: (A,A) => Boolean) : Boolean = {
  @annotation.tailrec
  def loop(n: Int): Boolean = {
    if( n >= as.length-1 ) true
    else if( ordered(as(n), as(n+1)) ){
      println(as(n) , as(n+1))
      loop(n+1)
    }
    else false
  }
  loop(0)
}

isSorted(myList2, orderedFun)


// 제 2장 연습문제 2.3
// 모든 함수는 인자를 1개만 받는다
// A => B => C => D
def curry[A,B,C](f: (A, B) => C) : A => (B => C) ={
  (a : A) => (b : B) => f(a, b)
}

def uncurry[A,B,C](f: A=> B=>C) : (A, B) =>C ={
  (a, b) => f(a)(b)
}



def foo1(a: Int, b :Int) = a+b

def compose[A,B,C](f:B => C, g:A => B) : A => C = {
  f(g(a))
}
