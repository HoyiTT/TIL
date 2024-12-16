# java.lang 패키지

java.lang 패키지는 자바 프로그래밍에 기본적으로 필요한 클래스들을 담고 있다. 따라서 별도의 import문 없이도 사용할 수 있다.

## Object 클래스

Object 클래스는 모든 클래스의 최상위 클래스이다. 모든 클래스는 Object 클래스를 상속받는다.

Object 클래스의 주요 메소드는 다음과 같다.

다음은 `java.lang` 패키지의 **Object** 클래스에 정의된 주요 메소드들이다.

---

# `Object` 클래스의 주요 메소드

| 메소드 시그니처                          | 설명                                                                 |
|----------------------------------------|----------------------------------------------------------------------|
| `protected Object clone()`             | 객체의 복사본을 반환한다. `Cloneable` 인터페이스를 구현해야 한다.      |
| `boolean equals(Object obj)`           | 객체가 다른 객체와 같은지를 비교한다. 기본 구현은 참조 값을 비교한다.   |
| `protected void finalize()`           | 객체가 가비지 컬렉션될 때 호출된다. 리소스를 해제할 때 사용될 수 있다.   |
| `Class<?> getClass()`                  | 객체의 런타임 클래스 정보를 반환한다.                                 |
| `int hashCode()`                       | 객체의 해시코드 값을 반환한다. `equals()`와 연관된 동작을 한다.        |
| `void notify()`                        | 대기 상태에 있는 스레드 중 하나를 깨운다.                             |
| `void notifyAll()`                     | 대기 상태에 있는 모든 스레드를 깨운다.                                |
| `String toString()`                    | 객체의 문자열 표현을 반환한다. 기본 구현은 `"클래스명@해시코드"` 형태.  |
| `void wait()`                          | 다른 스레드가 `notify()`나 `notifyAll()`을 호출할 때까지 현재 스레드를 기다리게 한다. |
| `void wait(long timeout)`              | 지정된 시간(ms) 동안 스레드를 기다리게 한다.                          |
| `void wait(long timeout, int nanos)`   | 지정된 시간(ms)과 추가 나노초 동안 스레드를 기다리게 한다.            |

---

## 메소드 요약
1. **`clone()`**  
   객체를 복제할 때 사용되며 `Cloneable` 인터페이스를 구현해야 한다.

2. **`equals()`**  
   객체의 동등성을 확인할 때 사용되며 기본적으로 참조 주소를 비교한다. 필요시 오버라이딩하여 동작을 커스터마이징한다.

3. **`finalize()`**  
   객체가 GC에 의해 소멸되기 전에 수행되어야 할 작업을 정의할 때 사용한다. **Deprecated**되었으며 사용이 권장되지 않는다.

4. **`getClass()`**  
   객체의 클래스 타입 정보를 반환하며 런타임 클래스와 관련된 정보를 확인할 수 있다.

5. **`hashCode()`**  
   객체의 해시코드를 반환하며 `equals()`와 함께 오버라이딩이 필요할 수 있다.

6. **`toString()`**  
   객체를 문자열로 표현하며 기본 형식은 `클래스이름@16진수 해시코드` 형태이다.

7. **스레드 관련 메소드**  
   - **`wait()`**, **`notify()`**, **`notifyAll()`** 메소드는 **스레드 동기화**에 사용된다.  
     객체의 모니터(lock)를 기반으로 동작하며 `synchronized` 블록 내에서 호출해야 한다.

---

### 메소드 예시 코드

```java
public class ObjectExample {
    public static void main(String[] args) throws CloneNotSupportedException {
        ObjectExample obj1 = new ObjectExample();
        ObjectExample obj2 = new ObjectExample();

        // equals() 기본 동작
        System.out.println(obj1.equals(obj2)); // false

        // getClass()
        System.out.println(obj1.getClass().getName()); // ObjectExample

        // hashCode()
        System.out.println(obj1.hashCode());

        // toString()
        System.out.println(obj1.toString()); // ObjectExample@해시코드
    }
}
```