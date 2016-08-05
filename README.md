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


    
    