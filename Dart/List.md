# List

## List

dart에서 list는 다음과 같이 사용한다.

```dart
void main() {
  var giveMeFive = true;
  var numbers = [1, 2, 3, 4,];
  print(numbers);
}
```

## List with if

collection if를 이용하여 list의 값을 넣거나 뺼 수 있다.

``` dart
void main() {
  var giveMeFive = true;
  var numbers = [
    1,
    2,
    3,
    4,
    if (giveMeFive) 5,
  ];
  print(numbers);
}
```

