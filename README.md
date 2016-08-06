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
    