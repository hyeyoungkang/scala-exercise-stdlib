import org.scalatest.{FunSuite, Matchers}

import scala.annotation.tailrec

/**
  * Created by juliet on 2016. 9. 19..
  */
class Recursion extends FunSuite with Matchers{

  test("test"){
    def factorial_tail(n: Int) :Int ={
      @tailrec
      def fact(n1: Int, acc:Int) : Int ={
        if( n1 == 0) {
          acc
        }
        else{
          fact(n1-1, acc*n1)
        }
      }
      fact(n, 1)

    }
    factorial_tail(1000000)  shouldBe ( 120)
  }

  test("test2"){
    def factorial2(n : Int) : Int ={
        var acc: Int = 1
        var n1: Int = n
        while (n1 != 0) {
          acc = acc * n1
          n1 = n1 - 1
        }
        acc
    }
  }


  // 0! = 1
  // n! = 1*2*3 .. n-1 * n
  // (n+1)! = n! * (n+1)

//  def factorial(n: Int) :Int ={
//    if( n == 0) {
//      1
//    }
//    else {
////      factorial(n-1)*n
//      factorial(n-1)
//    }
//
//  }
//  def factorial_tail2(n: Int) :Int ={
//    @tailrec
//    def fact(n1: Int, acc:Int) : Int ={
//      if( n == 0) {
//        acc
//      }
//      else{
//        fact(n1-1, acc*n1)
//      }
//    }
//    fact(n, 1)
//
//  }
  // 피보나치 수열
  //    1
  //   1 1
  //  1 2 1
  // 1 3 3 1
  // 재귀함수

  def fib(n: Int): Int = {
    // 장점 : 구현이 간단하다 수학공색을 ㅡㄱ대로 표현할수가 있따
    // 단점 : stackoverflow
    @annotation.tailrec
    def loop(n: Int, prev: Int, cur: Int): Int =
      //  base case 끝나는 부분 값을 구현
      if (n <= prev ) prev

      // 반복 부분을 구현
      else loop(n - (n-1) , cur, prev + cur)
    loop(n, 0, 1)
  }
}

// tail recursion


