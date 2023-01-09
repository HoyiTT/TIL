# 좋은 객체 지향 설계의 5가지 원칙 (SOLID)

## SRP (단일 책임 원칙)
한 클래스는 하나의 책임만 가져야 한다.
-> 한 클래스에 여러기지 책임을 물지 말아야 한다.

(EX: 코드를 분리해놓지 않고 한 클래스에 모든 기능을 작성한다.)

## OCP (개방 폐쇄 원칙)
확장에는 열려 있어야 하고, 변경에는 닫혀 있어야 한다.

다형성을 활용해야 한다.

(EX: 인터페이스를 구현한 새로운 클래스를 하나 생성하여 새로운 기능을 구현한다.)


## LSP (리스코프 치환 원칙)
상위 타입의 객체를 하위 타입의 객체로 치환해도 상위 타입을 사용하는 프로그램은 정상적으로 동작해야 한다.

## ISP (인터페이스 분리 원칙)
특정 클라이언트를 위한 인터페이스 여러 개가 범용 인터페이스 하나보다 낫다.

## DIP (의존 역전 원칙)
의존 관계는 추상화에 의존해야지, 구체화에 의존하면 안된다.
