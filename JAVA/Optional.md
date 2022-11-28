# Optional
Java8 부터 Optional\<T> 클래스를 사용해 NullPointerException(NPE)을 방지할 수 있게 되었다.

Optional<T> 클래스는 Integer나 Double클래스처럼 T타입의 객체를 포장해주는 래퍼클래스이다.

NPE를 피하려면 null 체크를 해야하는데, Optional 클래스를 사용하면 null 체크를 할 필요가 없다.



EX)
```
Optional<String> opt = Optional.ofNullable(null);
String name = opt.orElse("EMPTY");
System.out.println(name); // EMPTY
```

Optional.ofNullable() 메소드는 null이 아닌 T타입의 객체를 포장해주고, null이면 빈 Optional 객체를 반환한다.

orElse() 메소드는 Optional 객체가 비어있을 때 기본값을 반환한다.

위의 예제에서는 null이기 때문에 orElse() 메소드의 인자값인 "EMPTY"가 반환된다.

