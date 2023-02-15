# Null Safety

Dart에서의 null safety는 어떤 변수, 혹은 데이터가 null이 될 수 있음을 __명시__하는 것을 말한다.

``` dart
void main() {
  String name = 'dart'
  name = null; // error
}
```

위와 같은 코드를 실행할 경우 에러가 발생한다.
name을 String으로 선언했기 때문에 null을 할당할 수 없다.

``` dart    
void main() {
  String? name = 'dart'
  name = null; // ok
}
```

하지만 `?`를 사용하여 null을 할당할 수 있음을 명시해주면 에러가 발생하지 않는다.

dart에서 기본적으로 모든 변수는 not-nullable이다.



``` dart
void main() {
  String? name = 'dart'
  name = null; 
  if(name != null) {
    name.isNotEmpty;
  }
}
```
위의 코드는

``` dart
void main() {
  String? name = 'dart'
  name = null; 
  name?.isNotEmpty; // ok
}
```
과 같은 코드이다.

`?.`은 null이 아닐 경우에만 해당 코드를 실행하라는 의미이다.

