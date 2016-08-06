import org.scalatest.{FunSuite, Matchers}

/**
  * Created by juliet on 2016. 8. 6..
  */
class SetSpec extends FunSuite with Matchers{
  test("set test"){
    val mySet = Set("Michigan", "Ohio", "Wisconsin", "Iowa")
    mySet.size shouldBe 4

    val mySet2 = Set("Michigan", "Ohio", "Wisconsin", "Michigan")
    mySet2.size shouldBe 3

    //add
    val aNewSet = mySet + "Illinois"

    aNewSet.contains("Illinois") shouldBe true
    mySet.contains("Illinois") shouldBe false

    // mixed type
    val set1 = Set("Michigan", "Ohio", 12)
    set1.contains(12) shouldBe true
    set1.contains("MI") shouldBe false

    // checked for member existence
    set1(12) shouldBe true
    set1("MI") shouldBe false

    val newSet2 = mySet - "Michigan"
    newSet2.contains("Michigan") should be( false )
    mySet.contains("Michigan") should be( true )

    // remove
    val newSet = mySet-- List("Michigan", "Ohio")
    newSet.contains("Michigan") shouldBe false
    newSet.contains("Wisconsin") shouldBe true
    newSet.size shouldBe 2
  }

  test("tuple remove test"){
    val mySet = Set("Michigan", "Ohio", "Wisconsin", "Iowa")
    val aNewSet = mySet - ("Michigan", "Ohio") // Notice: single '-' operator for tuples

    aNewSet.contains("Michigan") shouldBe false
    aNewSet.contains("Wisconsin") shouldBe true
    aNewSet.size shouldBe 2
  }

  test("noneexistent ele"){
    val mySet = Set("Michigan", "Ohio", "Wisconsin", "Iowa")
    val aNewSet = mySet - "Minnesota"

    aNewSet.equals(mySet) should be( true )
  }

  test("intersect test"){
    val mySet1 = Set("Michigan", "Ohio", "Wisconsin", "Iowa")
    val mySet2 = Set("Wisconsin", "Michigan", "Minnesota")
    val aNewSet = mySet1 intersect(mySet2)
    val aNewSet2 = mySet1 union(mySet2)

    aNewSet equals(Set("Michigan", "Wisconsin")) shouldBe true
    aNewSet2.equals(Set("Michigan", "Ohio", "Wisconsin", "Iowa", "Minnesota") ) shouldBe true

  }

  test("subsetOf test"){
    val mySet1 = Set("Michigan", "Ohio", "Wisconsin", "Iowa")
    val mySet2 = Set("Wisconsin", "Michigan", "Minnesota")
    val mySet3 = Set("Wisconsin", "Michigan")

    mySet2 subsetOf(mySet1) shouldBe false
    mySet3 subsetOf(mySet2) shouldBe true
  }

  test("diff"){
    val mySet1 = Set("Michigan", "Ohio", "Wisconsin", "Iowa")
    val mySet2 = Set("Wisconsin", "Michigan")

    val aNewSet = mySet1 diff mySet2 // Note: you can use the "&~" operator if you *really* want to.
    aNewSet.equals(Set("Ohio", "Iowa")) shouldBe true
  }
  test("Set equivalency is independent of order:"){
    // 순서와는 무관하다
    val mySet1 = Set("Michigan", "Ohio", "Wisconsin", "Iowa")
    val mySet2 = Set("Wisconsin", "Michigan", "Ohio", "Iowa")

    mySet1.equals(mySet2) shouldBe true


  }
}
