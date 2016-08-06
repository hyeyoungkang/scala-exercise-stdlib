import org.scalatest.{FunSuite, Matchers}

/**
  * Created by juliet on 2016. 8. 6..
  */
class MapSpec extends FunSuite with Matchers{
  test("map test"){
    val myMap = Map("MI" -> "Michigan", "OH" -> "Ohio", "WI" -> "Wisconsin", "IA" -> "Iowa")
    myMap.size shouldBe 4
    val myMap2 = Map("MI" → "Michigan", "OH" → "Ohio", "WI" → "Wisconsin", "MI" → "Michigan")
    myMap2.size should be( 3 )

    val aNewMap = myMap2 + ("IL" → "Illinois")
    aNewMap.contains("IL") should be( true )


    val mapValues = myMap2.values
    mapValues.size should be( 3 )
    mapValues.head should be( "Michigan" ) //Failed presumption: The order in maps is not guaranteed

    val lastElement = mapValues.last
    lastElement should be( "Wisconsin" )
  }

  test("map2 test"){
    val myMap = Map("MI"->"Michigan", "OH" -> "Ohio", "WI" -> "Wisconsin", "MI" -> "Meechigan")
    val mapValues = myMap.values
    mapValues.size shouldBe 3
    myMap("MI") shouldBe "Meechigan"
  }

  test("map type test"){
    val myMap= Map("Ann Arbor" -> "MI", 499321->"MI")
    myMap("Ann Arbor") shouldBe "MI"
    myMap(499321) shouldBe "MI"
  }

  test("Map access and remove test"){
    val myMap = Map("MI"->"Michigan", "OH"->"Ohio", "WI"->"Wisconsin", "IA"->"Iowa")
    myMap("MI") shouldBe "Michigan"
    myMap("IA") shouldBe "Iowa"

    val aNewMap = myMap - "MI"
    aNewMap.contains("MI") shouldBe false
    myMap.contains("MI") shouldBe true

  }

  test("no exist key test"){
    val myMap = Map("MI" → "Michigan", "OH" → "Ohio", "WI" → "Wisconsin", "IA" → "Iowa")
    intercept[NoSuchElementException] { myMap("TX") }
    myMap.getOrElse("TX", "missing data") should be("missing data" )

    val myMap2 = Map("MI" → "Michigan", "OH" → "Ohio", "WI" → "Wisconsin", "IA" → "Iowa") withDefaultValue "missing data"
    myMap2("TX") should be( "missing data")

    val aNewMap = myMap -- List("MI", "OH")
    aNewMap.contains("MI") shouldBe  false
    myMap.contains("MI") shouldBe true

    aNewMap.contains("WI") shouldBe true
    aNewMap.size shouldBe 2
    myMap.size shouldBe 4
  }

  test("tuple remove"){
    val myMap = Map("MI" → "Michigan", "OH" → "Ohio", "WI" → "Wisconsin", "IA" → "Iowa")
    val aNewMap = myMap - ("MI", "WI") // Notice: single '-' operator for tuples

    aNewMap.contains("MI") shouldBe false
    myMap.contains("MI") shouldBe true
    aNewMap.contains("OH") shouldBe true
    aNewMap.size shouldBe 2
    myMap.size shouldBe 4
  }
  test("존재하지 않는 ele의 삭제 테스트 "){
    //handled gracefully
    val myMap = Map("MI" → "Michigan", "OH" → "Ohio", "WI" → "Wisconsin", "IA" → "Iowa")
    val aNewMap = myMap - "MN"
    aNewMap.equals(myMap) shouldBe true
  }

  test("order"){
    val myMap1 = Map("MI" → "Michigan", "OH" → "Ohio", "WI" → "Wisconsin", "IA" → "Iowa")
    val myMap2 = Map("WI" → "Wisconsin", "MI" → "Michigan", "IA" → "Iowa", "OH" → "Ohio")
    myMap1.equals(myMap2) shouldBe true
  }
}
