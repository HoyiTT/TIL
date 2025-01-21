# Spring Container 

## 1. 스프링 컨테이너

스프링 컨테이너(Spring Container)는 **스프링 애플리케이션의 객체(Bean)를 생성하고 관리**하는 역할을 합니다. 스프링 컨테이너는 **BeanFactory**와 **ApplicationContext** 인터페이스를 구현한 클래스로, **IoC(Inversion of Control, 제어의 역전)**와 **DI(Dependency Injection, 의존성 주입)**을 구현합니다.

### 1.1. BeanFactory

BeanFactory는 스프링의 **최상위 인터페이스**로, **Bean을 등록하고 조회**하는 기능을 제공합니다. BeanFactory는 다음과 같은 주요 메서드를 제공합니다:

- `getBean(String name)`: 이름을 이용하여 Bean을 조회합니다.

### 1.2. ApplicationContext

ApplicationContext는 BeanFactory를 상속받은 인터페이스로, **BeanFactory의 모든 기능을 포함**하며 **추가적인 기능**을 제공합니다. ApplicationContext는 다음과 같은 주요 메서드를 제공합니다:

- `getBean(String name)`: 이름을 이용하여 Bean을 조회합니다.
- `getBean(Class<T> requiredType)`: 타입을 이용하여 Bean을 조회합니다.
- `getBeanDefinitionNames()`: 등록된 모든 Bean의 이름을 조회합니다.

### 1.3. 스프링 컨테이너 종류

스프링은 다양한 컨테이너를 제공하며, 주로 사용되는 컨테이너는 다음과 같습니다:

- **BeanFactory**: 가장 기본적인 컨테이너로, 지연 로딩 방식을 사용합니다.
- **ApplicationContext**: BeanFactory를 상속받은 컨테이너로, 미리 Bean을 로딩하여 사용합니다.
- **AnnotationConfigApplicationContext**: 자바 설정 클래스를 이용하여 Bean을 등록하는 컨테이너입니다.
- **GenericXmlApplicationContext**: XML 설정 파일을 이용하여 Bean을 등록하는 컨테이너입니다.

## 2. 스프링 컨테이너 생성

스프링 컨테이너를 생성하는 방법은 다양하며, 주로 사용되는 방법은 다음과 같습니다:

### 2.1. AnnotationConfigApplicationContext

AnnotationConfigApplicationContext는 **자바 설정 클래스**를 이용하여 스프링 컨테이너를 생성합니다. 다음은 AnnotationConfigApplicationContext를 사용하는 예시입니다:

```java
@Configuration
public class AppConfig {
    @Bean
    public UserService userService() {
        return new UserService();
    }
}


public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);
    }
}
```

