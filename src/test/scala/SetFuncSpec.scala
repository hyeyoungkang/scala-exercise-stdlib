/**
  * Created by juliet on 2016. 9. 7..
  */
package std_lib.set

import org.scalatest.{Matchers, WordSpec}
class SetFuncSpec extends WordSpec with Matchers {

  "set" should {

    "basic" in {
      val set = Set("a", 1, true, "a")

      val size : Int = set.size
      size shouldBe 3

      val contains: Boolean = set.contains(true)
      contains shouldBe true

      val apply: Boolean = set.apply(true)
      apply shouldBe true
    }

    "add, delete" in {
      val set = Set(1,2,3)

      val add: Set[Int] = set ++ Set(4,5)
      add shouldBe Set(1,2,3,4,5)

      val delete: Set[Int] = set -- Set(2,3)
      delete shouldBe Set(1)
    }

    "useful functions" in {
      val set1 = Set(1,2,3)
      val set2 = Set(2,3,4,5)

      val both: Set[Int] = set1.intersect(set2)
      both shouldBe Set(2, 3)

      val sum: Set[Int] = set1.union(set2)
      sum shouldBe Set(1, 2, 3, 4, 5)

      val sub1: Boolean = set1.subsetOf(set2)
      sub1 shouldBe false

      val sub2: Boolean = ???
      sub2 shouldBe true

      val sub3: Set[Int] = set2 -- set1
      sub3 shouldBe Set(4, 5)
    }
  }
}
