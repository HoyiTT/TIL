# namedParameter


``` dart
String sayHello({
    required String name ,
    required String country,
    required int age,
}) {
    return "Hello $name, you are $age, and you are from $country";
}

void main() {
    print(sayHello(name: 'John', country: 'USA', age: 12));
}

```
null safety를 지키기위해 required를 사용해야 한다.


``` dart
String sayHello({
    String name = 'anon',
    String country = 'ccc',
    int age = 12,
}) {
    return "Hello $name, you are $age, and you are from $country";
}

void main() {
    print(sayHello(name: 'John', country: 'USA', age: 12));
    print(sayHello(name: 'John', country: 'USA'));
    print(sayHello(name: 'John'));
    print(sayHello());
}
```

출력값
``` dart
Hello John, you are 12, and you are from USA
Hello John, you are 12, and you are from USA
Hello John, you are 12, and you are from ccc
Hello anon, you are 12, and you are from ccc
```


혹은 기본값을 정해주어 null safety를 지킬 수 있다.


## Optional Positional Parameters

position parameter는 위치가 중요하다.

각 위치에 맞는 값을 넣어줘야 한다.



``` dart    
String sayHello(String name, int age, [String? country = 'korea']) =>
    'Hello $name, you are $age years old and you are from $country';

void main() {
  var result = sayHello( 
    name : 'nico',
    age : 12,
    country: 'japan');
  print(result);
}
```
출력값
``` dart
Hello nico, you are 12 years old and you are from japan
```

[] 로 감싸면 required가 아니라 optional이 된다.

기본 값을 정해주지 않는다면 null이 된다.

## Optional Named Parameters

``` dart
String sayHello({
    required String name,
    required int age,
    String? country,
}) {
    return "Hello $name, you are $age, and you are from $country";
}

void main(){
    print(sayHello(name: 'John', age: 12));
    print(sayHello(name: 'John', age: 12, country: 'USA'));
}
```

출력값
``` dart
Hello John, you are 12, and you are from null
Hello John, you are 12, and you are from USA
```

아래는 chatGPT를 사용한 예시이다.

``` dart
void printMessage(String message, [String sender]) {
  if (sender != null) {
    print('$sender says: $message');
  } else {
    print(message);
  }
}

void main() {
  printMessage('Hello, world!'); // Output: Hello, world!
  printMessage('Hello, world!', 'Alice'); // Output: Alice says: Hello, world!
}
```

이런식으로 if 문을 사용하여 null safety를 지킬 수 있다.


