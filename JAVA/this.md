# this

자바에서 인스턴스 자신을 가리키는 키워드

인스턴스 멤버 -> 인스턴스를 생성하고 사용할 수 있는 필드와 메소드

객체 내부에서 인스턴스 멤버를 접근할 때 this 키워드를 사용한다.

```
Car(String model){
    this.model = model;
}
void setModel(String model){
    this.model = model;
}
```
