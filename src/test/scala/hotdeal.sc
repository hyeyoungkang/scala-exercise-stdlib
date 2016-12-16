// 핫딜을 가져온다
//
object HotdealService {
  def get(count : Int) = {
    val hotdeals = getHotdeal("타입", "정상", count)
    hotdeals
  }
}

// 특정 브랜드의 상품을 가져온다
object BrandService {
  def get(count : Int) = {
    val brandItems = getBrandItem(true, "정상", count)
    brandItems
  }
}

val hotdeals = HotdealService.get(10)
hotdeals.size

val items = BrandService.get(10)
items.size

//getHotdeal("타입", "정상", count)
//neFun(count)
/**
  * parially applied function을 적용해서 자동으로 모자란 만큼 가져오는 기능
  */
object AutoHotdealService {
  def newFun(count:Int): List[Item] = getHotdeal("타입", "정상", count)

  def get(count : Int) : List[Item] = getMore( newFun, count)
}

object AutoBrandService {
  def get(count : Int) = {
    getMore(getBrandItem(true, "정상", _ : Int), count)
  }

}
AutoBrandService.get(10)

val hotdeals2 = AutoHotdealService.get(10)
hotdeals2.size

def getMore[T](func : Int => List[T], count : Int) = {
  val list1 = func(count)
  val list2 = func(count - list1.size)
  list1 ::: list2
}

// Repository
case class Item(id : Int, name : String)
def getHotdeal(templateType : String, status: String, n : Int) = (0 until n).filterNot(_ == 2).map(i => Item(i, s"${i} 상품명")).toList
def getBrandItem(special : Boolean, status : String, n : Int) = (0 until n).filterNot(_ == 3).map(i => Item(i, s"${i} 상품명")).toList


def applyList(func: (Int) => (Int))(list: List[Int]) : List[Int] = {
  list.map(func)
}

// applyList를 활용해서 리스트의 모든 값을 2배로 늘리는 함수
// List(1,2,3)를 받으면 List(2,4,6)를 리턴
val doubledList : (List[Int] => List[Int]) = applyList(_*2)

doubledList(List(1,2,3))