package std_lib.map

import org.scalatest.{Matchers, WordSpec}

import scala.collection.mutable

/**
  * Created by karellen on 2016. 8. 14..
  */
class MapFuncSpec extends WordSpec with Matchers {

  "map" should {

    "java style" in {
      // 스칼라지만 자바스타일로 짠거
      val map = new mutable.HashMap[String, Int]()
      map.put("a", 1)
      map.put("b", 2)

      map.get("a") shouldBe (Some(1))
      map.foreach(m => print(m))
    }

    "custom Map" in {
      object MyMap {
        def apply[T1, T2](list: (T1, T2)*) = {
          val map = new mutable.HashMap[T1, T2]()
          list.foreach(one => map.put(one._1, one._2))
          map
        }
      }

      val myMap = MyMap(("a", 1),("b", 2))
      val myMap2 = MyMap((1, 1),(2, 2))
      val myMap3 = MyMap("a" -> 1, "b"->2)
      myMap.get("a") shouldBe (Some(1))
      myMap2.get(1) shouldBe (Some(1))
      myMap3.get("a") shouldBe (Some(1))
    }

    "basic" in {
      val map = Map("a" -> 1, "b" -> 2, "c" -> 2, "c" -> 3)

      val size: Int = map.size
      size shouldBe 3

      val keys: Iterable[String] = map.keySet
      keys shouldBe Set("a", "b", "c")

      val values: Iterable[Int] = map.values
      values.toList shouldBe List(1, 2, 3)

      val find: Int = map("a")
      find shouldBe 1

      val findOption: Any = map.getOrElse("a", Some(1))
      findOption shouldBe Some(1)
    }

    "값 추가, 삭제" in {
      val map = Map("a" -> 1, "b" -> 2, "c" -> 3)

      val add: Map[String, Int] = map ++ Map( "d" -> 4, "e" -> 5)
      val delete: Map[String, Int] = map - ("b", "c")

      add shouldBe Map("a" -> 1, "b" -> 2, "c" -> 3, "d" -> 4, "e" -> 5)
      delete shouldBe Map("a" -> 1)
    }

    "mixed type map" in {
      val map = Map("a" -> 1, 2 -> "b", true -> 3)

      map("a") shouldBe 1
      map(true) shouldBe 3

      // val map = Map() // tuple로 생성
      // map.head
    }
  }
}