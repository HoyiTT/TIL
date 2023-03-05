# Cascade notation

``` dart
class Player {
  String name;
  int xp;
  String team;

  Player({
    required this.name, 
    required this.xp, 
    required this.team});

  void sayHello() {
    print('Hello, my name is $name and I have $xp xp');
  }
}

void main() {
  var nico = Player(name: 'Nico', xp: 100, team: 'red');
  nico.name = 'Jun',
  nico.xp = 200,
  nico.team = 'blue';
}
```
에서 main() 함수는 다음과 같이 표현할 수 있다.

``` dart
void main() {
  var nico = Player(name: 'Nico', xp: 100, team: 'red');
  ..name = 'Jun'
  ..xp = 200,
  ..team = 'blue';
}