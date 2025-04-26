

SOLID 원칙

SOLID는 객체지향 프로그래밍에서 유지보수성, 확장성을 높이기 위해 제안된 5가지 원칙의 약어입니다.

약어	원칙 이름	의미 요약
S	단일 책임 원칙 (Single Responsibility Principle)	클래스는 하나의 책임만 가져야 한다.
O	개방-폐쇄 원칙 (Open/Closed Principle)	확장에는 열려 있고, 수정에는 닫혀 있어야 한다.
L	리스코프 치환 원칙 (Liskov Substitution Principle)	하위 타입은 언제나 상위 타입을 대체할 수 있어야 한다.
I	인터페이스 분리 원칙 (Interface Segregation Principle)	인터페이스는 클라이언트에 맞게 분리되어야 한다.
D	의존 역전 원칙 (Dependency Inversion Principle)	고수준 모듈은 저수준 모듈에 의존하면 안 된다. 둘 다 추상화에 의존해야 한다.



⸻

1. S - 단일 책임 원칙 (Single Responsibility Principle, SRP)

“하나의 클래스는 하나의 책임만 가져야 한다.”

	•	클래스는 변경이 일어날 수 있는 이유가 오직 하나여야 한다.
	•	여러 책임을 가지면, 하나의 변경이 다른 기능에 영향을 미칠 수 있다.

예시

// 잘못된 예시
class Report {
    void printReport() { ... }    // 출력 책임
    void calculateStatistics() { ... } // 통계 계산 책임
}

// 올바른 분리
class ReportPrinter {
    void printReport() { ... }
}

class ReportCalculator {
    void calculateStatistics() { ... }
}



⸻

2. O - 개방-폐쇄 원칙 (Open/Closed Principle, OCP)

“소프트웨어 요소는 확장에는 열려 있어야 하고, 변경에는 닫혀 있어야 한다.”

	•	기존 코드를 수정하지 않고 새로운 기능을 추가할 수 있어야 한다.
	•	보통 인터페이스와 다형성을 활용해서 구현한다.

예시

interface Shape {
    double area();
}

class Rectangle implements Shape {
    double area() { return width * height; }
}

class Circle implements Shape {
    double area() { return Math.PI * radius * radius; }
}



⸻

3. L - 리스코프 치환 원칙 (Liskov Substitution Principle, LSP)

“하위 타입은 상위 타입을 대체할 수 있어야 한다.”

	•	프로그램의 동작은 하위 타입을 상위 타입으로 바꿔도 문제없이 수행되어야 한다.
	•	하위 클래스는 상위 클래스의 계약(Contract)을 깨지 않아야 한다.

예시

class Bird {
    void fly() { ... }
}

class Ostrich extends Bird {
    // 날 수 없는 새는 fly()를 상속받으면 안 된다. (LSP 위반)
}

	•	Ostrich는 Bird 타입을 대체할 수 없으므로 설계를 수정해야 한다.

⸻

4. I - 인터페이스 분리 원칙 (Interface Segregation Principle, ISP)

“특정 클라이언트를 위한 인터페이스 여러 개가 범용 인터페이스 하나보다 낫다.”

	•	사용하지 않는 메서드를 강제하지 말아야 한다.
	•	작고, 구체적인 인터페이스로 분리하는 것이 좋다.

예시

// 잘못된 예시
interface Worker {
    void work();
    void eat();
}

// 개선된 예시
interface Workable {
    void work();
}

interface Eatable {
    void eat();
}



⸻

5. D - 의존 역전 원칙 (Dependency Inversion Principle, DIP)

“고수준 모듈은 저수준 모듈에 의존하면 안 되고, 둘 다 추상화에 의존해야 한다.”

	•	구체적인 것이 아니라 추상화(Interface, Abstract Class) 에 의존해야 한다.
	•	구현체가 바뀌어도 고수준 모듈이 영향받지 않게 한다.

예시

// 나쁜 예시 (구체 클래스에 의존)
class LightSwitch {
    private LightBulb bulb = new LightBulb();
    void turnOn() { bulb.turnOn(); }
}

// 좋은 예시 (추상화에 의존)
interface Switchable {
    void turnOn();
}

class LightBulb implements Switchable {
    public void turnOn() { ... }
}

class LightSwitch {
    private Switchable device;
    public LightSwitch(Switchable device) { this.device = device; }
    void turnOn() { device.turnOn(); }
}



⸻

요약 한 줄씩
	•	SRP: 하나의 클래스는 하나의 책임만 가져야 한다.
	•	OCP: 코드를 수정하지 않고 기능을 확장할 수 있어야 한다.
	•	LSP: 하위 타입은 상위 타입을 대체할 수 있어야 한다.
	•	ISP: 인터페이스는 작고 명확하게 쪼개야 한다.
	•	DIP: 추상화에 의존하고, 구체 구현에 의존하지 않는다.

⸻