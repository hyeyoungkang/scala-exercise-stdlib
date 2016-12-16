#Tuple
- 튜플을 사용하면 클래스를 정의하지 않고도 여러 아이템을 한데 묶을수 있다
```
    val t = (1, "hello", Console)
    val t2 = new Tuple3(1, "hello", Console)

    assert(t == t2)
```

- 케이스 클래스와 달리 튜플의 억세서(accessor)에는 이름이 없다. 대신 위치에 따라 숫자로 된 억세서가 있다
- 1부터 시작 튜플은 22까지
```
    val tuple5 = ("a", 1, 2.2, new Date(), "five")

    tuple5._2 shouldBe (1)
    tuple5._5 shouldBe("five")
```

#고차함수
- 함수를 인자로 넘길수 있는 함수

# Function / Method 의 차이
- method : class, object 내에 있어야 한느거
 -- def는 class, ojbect에 종속되어야 함.
- function : class, object 밖에서도 호출이 되됨
 -- 

#foldLeft
- foldLeft는 리스트의 모든 값을 하나 하나씩 계산에 적용한후  마지막 값을 구하는데 쓰인다 
- 왼쪽부터 하나하나씩 접어서 마지막 하나의 접음을 리턴하는것을 생각하라 
- 리스트에 모든 값을 더할려면 foldLeft를 사용하라

    
#flatMap
- flatMap 은 map 이랑 flatten 을 합해놓것과 같다. 예를들어 List[List[Int]] 를 List[Int] 로 바꿀려면 밑에 처럼 flatten 을 쓰면 된다.
```
    val ints = List(List(1,2,3), List(4,5))
    ints.flatten // => this returns List(1,2,3,4,5)
```
- 그렇다면 List[List[Int]] 를 List[String] 으로 바꿀려면 어떻해야 할까? flatMap 을 쓰면된다.
```
    scala> val ints = List(List(1,2,3), List(4,5))
    ints: List[List[Int]] = List(List(1, 2, 3), List(4, 5))
    
    scala> ints.flatMap(_.map(_.toString))
    res0: List[java.lang.String] = List(1, 2, 3, 4, 5)
```
    
    
#Set
- 집합에는 중복된 원소가 들어갈 수 없다
- contains, intersect(deprecated v2.8), union, diff,subsetOf

#case class
- case class는 생성자 파라미터를 노출하고 패턴매칭을 통해 재귀적 디컴포지션 메커니즘을 제공하는 일반 클래스이다 
- 특징
```
1. 자동으로 Companion 오브젝트가 생성되며 apply 메소드 와 unapply 메소드가 제공된다. 
그러므로 새로운 오브젝트를 instantiate 할때 new keyword 는 옵션이며, 또한 pattern matching 에 유용하기 쓰일수 있다.
2. 케이스 클래스의 파라미터 목록에는 모든 파라미터에 암시적으로 val 키워드가 붙음으로 파라미터가 곧 클래스의 필드가 된다
 - val v = Val("x") 로 생성된 객체는 name라는 String타입의 파라미터를 가지고 name 파라미터는 value로 x를 가리킨다
 (Case class 의 Constructor arguments 는 default 로 val 으로 취급된다 그러므로 멤버 variable 처럼 엑세스 할수 있다)
3. 컴파일러는 case class에 toString, hashCode, equals메소드에 대하여 자연스러운 구현을 추가한다
4. 컴파일러는 case class에서 일부를 변경한 복사본을 생성하는 copy메소드를 추가하는데 이 copy메소드는 정의한 case
class의 파라미터 이름을 사용한다
```

```
case class CaseClassExample(message:String)
val x = CaseClassExample("Hello")
println(x.message) // constructor argument 는 member variable처럼 액세스 할수 이다 
```


#
- 함수 리터럴 : 함수가 생성된게 아니라 클래스 정의 만 있는것
- 함수 : val 실제 함수가 생성됨
- 함수를 실행 시점에 새로 만들어서 인자로 넘기거나 반환할수 있다

#PARTIALLY APPLIED FUNCTIONS
 