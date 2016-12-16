object ImplicitsTest extends App {

  implicit object StringMonoid extends Monoid[String] {
    def add(x: String, y: String) = x concat y

    def unit: String = ""
  }

  implicit object IntMonoid extends Monoid[Int] {
    def add(x: Int, y: Int): Int = x + y

    def unit: Int = 0
  }

  def sum[A](xs: List[A])(implicit m:Monoid[A]) : A =
    if( xs.isEmpty ) m.unit
    else m.add(xs.head , sum(xs.tail))
  println(sum(List(1,2,3)))
  println(sum(List("a", "b", "c")))

}

def howMuchCanIMake_?(hours: Int)(implicit amount: BigDecimal, currencyName: String) =
  (amount * hours).toString() + " " + currencyName

implicit val hourlyRate = BigDecimal(34.00)
implicit val currencyName = "Dollars"

def howMuchCanIMake_?(hours: Int, amount: BigDecimal = 34, currencyName: String = "Dollars") =
  (amount * hours).toString() + " " + currencyName

howMuchCanIMake_?(30)

howMuchCanIMake_?(30, 95)
