# Spring AOP

### **📌 1. AOP란?**  
**AOP(Aspect-Oriented Programming, 관점 지향 프로그래밍)** 는 **비즈니스 로직과는 별개로 공통 기능(로깅, 트랜잭션, 보안 등)을 모듈화하여 관리하는 기법**이다.
즉, **코드 중복 없이 특정 기능을 여러 곳에서 쉽게 적용할 수 있도록 도와주는 개념**

👉 **주요 개념 정리**  
- **OOP(객체 지향 프로그래밍)** → 핵심 비즈니스 로직을 중심으로 코드 작성  
- **AOP(관점 지향 프로그래밍)** → 공통 관심사를 따로 분리하여 코드 관리  

✅ **AOP를 활용하는 대표적인 예시**  
- **로깅(logging):** 모든 메서드 실행 시간을 기록  
- **트랜잭션 관리(transaction):** 특정 메서드 실행 시 자동으로 트랜잭션 적용  
- **보안(security):** 특정 메서드에 접근할 수 있는 사용자 제한  
- **예외 처리(exception handling):** 메서드 실행 중 발생하는 예외를 공통적으로 처리  

---

### **📌 2. AOP의 핵심 개념**  
Spring AOP에서는 다음과 같은 개념이 사용됨.  

| 개념 | 설명 |
|------|------|
| **Aspect (애스펙트)** | 공통 기능을 모듈화한 클래스 (ex: 로깅, 트랜잭션) |
| **JoinPoint (조인 포인트)** | AOP가 적용될 수 있는 지점 (메서드 실행, 예외 발생 등) |
| **Advice (어드바이스)** | AOP에서 수행할 로직 (ex: 메서드 실행 전/후 로깅) |
| **Pointcut (포인트컷)** | Advice가 적용될 메서드 선택 기준 (ex: 특정 패키지 내 모든 메서드) |
| **Weaving (위빙)** | Advice를 실제 코드에 적용하는 과정 |

---

### **📌 3. Spring Boot AOP 적용 방법**  
#### **✅ 1️⃣ Spring AOP 의존성 추가**  
Spring Boot에서는 `spring-boot-starter-aop`를 사용하여 AOP를 쉽게 적용할 수 있음.  

📌 **Maven (pom.xml)**  
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-aop</artifactId>
</dependency>
```

📌 **Gradle (build.gradle)**  
```gradle
implementation 'org.springframework.boot:spring-boot-starter-aop'
```

---

### **📌 4. AOP 구현 예제**  
#### **✅ 2️⃣ @Aspect와 @Component를 사용한 AOP 적용**  
아래 예제는 **모든 서비스 메서드 실행 전/후에 실행 시간을 측정하는 AOP**임.  

📌 **Aspect 구현 (LoggingAspect.java)**  
```java
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect  // AOP 클래스 선언
@Component  // 스프링 빈 등록
public class LoggingAspect {

    @Around("execution(* com.example.service.*.*(..))") // 서비스 패키지의 모든 메서드 적용
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        // 실제 메서드 실행
        Object result = joinPoint.proceed();

        long end = System.currentTimeMillis();
        System.out.println(joinPoint.getSignature() + " 실행 시간: " + (end - start) + "ms");

        return result;
    }
}
```

📌 **포인트컷(Pointcut) 설명**  
```java
@Around("execution(* com.example.service.*.*(..))")
```
- `execution(* com.example.service.*.*(..))` → `com.example.service` 패키지의 **모든 메서드**에 적용  
- `@Around` → 메서드 실행 **전/후**에 AOP 실행  

✅ **이제 `com.example.service` 패키지 내의 모든 메서드 실행 시간이 로그로 기록됨!** 🚀  

---

### **📌 5. AOP의 다양한 Advice 종류**  
AOP에서는 다양한 Advice를 제공함.  

| Advice 종류 | 설명 |
|------------|------|
| **@Before** | 메서드 실행 전에 실행 |
| **@After** | 메서드 실행 후에 실행 |
| **@AfterReturning** | 메서드가 정상적으로 실행된 후 실행 |
| **@AfterThrowing** | 예외가 발생한 경우 실행 |
| **@Around** | 메서드 실행 전/후 모두 실행 |

#### **✅ 1️⃣ @Before 예제 (메서드 실행 전에 로그 남기기)**  
```java
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BeforeAspect {

    @Before("execution(* com.example.service.*.*(..))")
    public void beforeMethod() {
        System.out.println("메서드 실행 전에 로그 출력!");
    }
}
```
📌 **메서드 실행 전에 `"메서드 실행 전에 로그 출력!"` 메시지가 출력됨.**  

---

#### **✅ 2️⃣ @AfterReturning 예제 (메서드가 정상 실행된 후 결과 확인)**  
```java
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AfterReturningAspect {

    @AfterReturning(value = "execution(* com.example.service.*.*(..))", returning = "result")
    public void afterReturning(Object result) {
        System.out.println("메서드가 정상적으로 실행됨. 결과: " + result);
    }
}
```
📌 **메서드가 정상적으로 실행된 후 결과 값이 출력됨.**  

---

### **📌 6. AOP 사용 시 주의할 점**  
1. **AOP는 Spring 빈(Component)에서만 동작함**  
   - AOP는 **Spring 컨테이너에서 관리되는 빈(Component) 객체**에서만 동작함.  
2. **AOP 적용 범위를 조정해야 함**  
   - 너무 넓은 범위(`execution(* *.*(..))`)에 AOP를 적용하면 **불필요한 성능 저하**가 발생할 수 있음.  
3. **Spring AOP는 기본적으로 프록시 기반으로 동작함**  
   - Spring Boot의 기본 AOP는 **프록시 기반**으로 동작하며, 클래스 내부의 `this` 호출에는 AOP가 적용되지 않을 수 있음.  

---

## **🔥 최종 정리**  
✔ **AOP(Aspect-Oriented Programming)는 공통 기능(로깅, 트랜잭션 등)을 모듈화하는 기법임**  
✔ **Spring AOP의 핵심 개념: Aspect, Advice, Pointcut, JoinPoint**  
✔ **Advice 종류: @Before, @After, @AfterReturning, @AfterThrowing, @Around**  
✔ **@Aspect와 @Component를 사용하여 AOP를 구현할 수 있음**  
✔ **@Around를 사용하면 실행 시간을 측정할 수 있음**  
