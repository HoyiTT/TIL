# Hello! world!

Dart에서는 `main()` 함수가 있어야만 실행이 가능하다

```dart 
void main() {
  print('Hello! world!');
}
```

# 변수

Dart에서는 변수를 선언할 때 `var` 키워드를 사용한다

```dart
void main() {
  var name = 'Dart';
  print(name);
}
```
관습적으로 함수나 메소드 내부에 지역 변수를 선언할 떄에는 var를 사용한다.


명시적으로 타입을 선언해줄수도 있다.
```dart
void main() {
  String name = 'Dart';
  print(name);
}
```
Class에서 변수나 property를 선언할 때에는 타입을 지정해 준다.

__Dynamically Type__

Dart에서는 타입이 지정되지 않은 상태의 변수를 선언할 수 있다.
이를 Dynamically Type이라고 한다.

```dart
void main() {
  var name;
  name = 1;
  name= "dart";;
}
```

or 

```dart
void main() {
  dynamic name = 1;
  name = "dart";
}
```



