# Spring Security

Spring Security는 Spring 기반의 애플리케이션의 보안(인증과 권한, 인가 등)을 담당하는 스프링 하위 프레임워크이다. 

EX)

``` html
<li class="nav-item">
          <a class="nav-link" sec:authorize access="isAnonymous()" th:href="@{/user/login}">로그인</a>
          <a class="nav-link" sec:authorize access="isAuthenticated()" th:href="@{/user/logout}">로그아웃</a>
        </li>
```
(스프링 시큐리티5 에서만 가능하다)

Spring security에 의해 로그인이 되어있는지 아닌지에 따라 보여지는 링크가 달라진다.

# Spring Security는 어떻게 동작할까?

![image.png](attachment:18323355-1c10-421c-9bd9-f44710fe3a6a:image.png)

Spring Security의 큰 흐름은 위 그림처럼 이루어져 있따.

## 서버 시작 시 Spring Security 작동 흐름

```java

서버 시작
  ↓
[Security 관련 Bean 등록]
  ↓
[SecurityFilterChain 구성 (우리가 만든 filterChain() 실행)]
  ↓
[HttpSecurity 설정 분석]
  ↓
[FilterChainProxy 구성]
  ↓
[DispatcherServlet] → [FilterChainProxy] → [실제 요청 처리]

```

# Spring Security의 전체 동작 흐름 (서버 시작 ~ 요청 처리까지)

---

## 1. **서버 시작**

Spring Boot 실행 시 `main()` 메서드에서 `SpringApplication.run(...)`이 호출되며

→ 내부적으로 ApplicationContext(SDI 컨테이너)가 구성됨

```java

@SpringBootApplication
public class WelcommuApplication {
    public static void main(String[] args) {
        SpringApplication.run(WelcommuApplication.class, args);
    }
}

```

- 여기서부터 모든 Bean 관리가 시작돼
- `@ComponentScan`이 `com.welcommu` 이하의 모든 클래스를 뒤짐

---

## 2. **Security 관련 Bean 등록**

> 이건 @EnableWebSecurity가 트리거가 돼서 일어남
> 

```java

@EnableWebSecurity
public class SecurityConfig { ... }

```

- 내부적으로 `WebSecurityConfiguration`, `SecurityFilterAutoConfiguration`, `SpringBootWebSecurityConfiguration` 같은 클래스들이 활성화됨
- 이 설정들이 **Spring Security의 보안 구조를 초기화**하고,
- 우리가 만든 `@Bean SecurityFilterChain`을 찾고 실행함

---

## 3. **SecurityFilterChain 구성 (filterChain() 실행)**

```java

@Bean
public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
    // 이 메서드가 서버 시작 시 자동 실행됨
    ...
    return httpSecurity.build();
}

```

- 이 시점에 우리가 설정한 보안 정책들을 `HttpSecurity` 객체에 "차곡차곡" 쌓아감
- 내부적으로 `.authorizeHttpRequests()` 같은 설정은 **Configurer 객체로 등록**됨

---

## 4. **HttpSecurity 설정 분석**

> 핵심: httpSecurity.build() 호출 시점
> 

```java

httpSecurity
    .csrf(csrf -> csrf.disable())
    .cors(Customizer.withDefaults())
    .authorizeHttpRequests(auth -> auth
        .requestMatchers(...).permitAll()
        .anyRequest().authenticated()
    )
    .addFilterBefore(...);

return httpSecurity.build(); // 여기서 설정이 실행되며, FilterChain이 생성됨

```

- `build()` 메서드는 내부적으로 **등록된 모든 보안 설정(Configurers)**을 하나씩 실행함
- 결과적으로 `SecurityFilterChain` 객체가 생성되고, **Security 관련 필터들이 필터 체인에 등록**됨
- 이때 `addFilterBefore()`로 추가한 `JwtAuthenticationFilter`도 여기에서 포함됨

---

## 5. **FilterChainProxy 구성**

- Spring Security는 이렇게 구성된 필터 체인들을 `FilterChainProxy`라는 **하나의 마스터 필터**로 묶음

```

DispatcherServlet 앞에 위치한 단 하나의 Filter
└── SecurityFilterChain 리스트 보유
      └── 각 SecurityFilterChain은 다양한 Filter를 가짐

```

- 이 `FilterChainProxy`가 **DispatcherServlet 앞단**에 위치함으로써
- 모든 요청은 이 필터를 거치게 됨

---

## 6. **DispatcherServlet → FilterChainProxy → 실제 요청 처리**

### 클라이언트가 요청을 보냄

```

GET /api/user
Authorization: Bearer xxxxxx

```

### **DispatcherServlet → FilterChainProxy 진입**

- DispatcherServlet은 모든 HTTP 요청을 가로채고
- 서블릿 필터로 등록된 `FilterChainProxy`가 우선 실행됨

---

### **FilterChainProxy → SecurityFilterChain 실행**

- 요청 경로에 매칭되는 SecurityFilterChain을 찾아
- 해당 체인의 필터들을 순차적으로 실행

### 필터 실행 예시 (순서 중요):

1. `SecurityContextPersistenceFilter`
2. `CorsFilter`
3. `JwtAuthenticationFilter` ← 너가 만든 커스텀 필터
4. `UsernamePasswordAuthenticationFilter` (폼 로그인용)
5. `ExceptionTranslationFilter`
6. `FilterSecurityInterceptor` (인가 판단)
7. ...

---

### **JwtAuthenticationFilter에서 인증 처리**

- Authorization 헤더에서 토큰 추출 → 유효성 검사
- 유효하면 `SecurityContextHolder.getContext().setAuthentication(...)`
- 인증 정보가 SecurityContext에 저장됨

---

### **FilterSecurityInterceptor에서 인가 판단**

```java

.authorizeHttpRequests(it -> it
    .requestMatchers("/api/auth/login").permitAll()
    .anyRequest().authenticated()
)

```

- 이 설정에 따라 현재 요청이 접근 가능한지 인가 확인
- 인증이 안 되어 있거나 권한이 없으면 401 / 403 발생

---

### 통과되면 → **Controller로 전달**

```java

@GetMapping("/api/user")
public ResponseEntity<?> getUserInfo(@AuthenticationPrincipal String username) { ... }

```

- `SecurityContext`에 등록된 인증 정보를 통해 사용자 정보 접근 가능
- 요청 처리 완료 후 응답 반환

---

## 전체 시각화 요약

```
plaintext
복사편집
서버 기동
├─ @EnableWebSecurity → 내부 설정 로딩
├─ @Bean SecurityFilterChain → filterChain(HttpSecurity) 실행
│    └ HttpSecurity 설정 분석
│    └ addFilterBefore(...), authorizeHttpRequests(...) 적용
│    └ build() 호출 → SecurityFilterChain 완성
├─ FilterChainProxy 구성 완료

요청 발생
├─ DispatcherServlet
├─ FilterChainProxy
│   ├─ JwtAuthenticationFilter (토큰 인증)
│   ├─ FilterSecurityInterceptor (인가 확인)
│   └ ...
└─ Controller 호출

```

---

이 흐름을 정확히 이해하면 Spring Security 커스터마이징할 때 한계가 거의 사라져.

예를 들어 필터 추가 위치 조정, `@PreAuthorize` 적용, 커스텀 AuthenticationProvider 확장 등 모든 게 가능해져.

더 깊게 들어가고 싶은 포인트 있어? 예: SecurityContext 생명주기, 인증 객체 커스터마이징, 필터 우선순위 등.

### JwtTokenHelper 생성자가 자동 실행되는 이유

우리의 코드를 살펴보면 JwtTokenHelper의 생성자가 자동으로 실행되는 것을 알 수 있다

![Screenshot 2025-04-05 at 7.34.55 PM.png](attachment:d3e43871-61c2-4aa3-9c83-5bd99c6bf49f:Screenshot_2025-04-05_at_7.34.55_PM.png)

서버를 시작하면 위처럼 로그가 찍히는 것을 확인할 수 있따.

근데?!? 분명 우리 코드에서는 

![Screenshot 2025-04-05 at 7.35.30 PM.png](attachment:16f57029-9374-4719-a100-6f41bfaa9205:Screenshot_2025-04-05_at_7.35.30_PM.png)

위 사진의 JwtTokenHelper 생성자를 호출하는 부분이 없다..

근데 왜 실행될까?!

## Spring Boot가 Bean을 초기화할 때 실행됨

 `@Component` 붙은 클래스는 Spring이 자동으로 Bean으로 등록

```java
java
복사편집
@Component
public class JwtTokenHelper

```

→ 이 클래스는 Spring Boot가 **자동 구성 과정**에서 감지하고, 내부적으로 객체를 생성함

---

### `@Autowired` 생성자 기반 의존성 주입

```java
java
복사편집
@Autowired
public JwtTokenHelper(Environment env) { ... }

```

- Spring이 `Environment` 객체를 주입해서 생성자를 호출함
- 이때 `application.yml` 또는 `application.properties`에 있는 설정 값을 읽어오고,
- `logger.info(...)` 구문을 실행 → **이 로그가 서버 기동 시점에 터지는 이유**

## 실제 흐름 요약

```java
서버 시작
  ↓
[@Component 스캔] → [JwtTokenHelper 발견]
  ↓
[Spring이 Bean으로 등록하기 위해 생성자 호출]
  ↓
[@Value 또는 Environment 로딩]
  ↓
[생성자 내부 로그 실행 (→ 바로 로그 출력됨)]

```

## User Request가 왔을 시 작동 흐름

```java
[Client]
   ↓ 로그인 요청 (email, pw)
[AuthController]
   ↓ 유효성 검사 → JWT 생성
[JwtTokenHelper]
   ↓ Access, Refresh Token 발급
   ↓ Refresh Token 저장
   → 클라이언트 응답 (JWT 반환)

[Client]
   ↓ 인증된 API 요청 (Authorization: Bearer token)
[JwtAuthenticationFilter]
   ↓ 토큰 파싱 & 유효성 검증
   ↓ SecurityContext에 등록
   → Controller 접근 가능

[Client]
   ↓ Access Token 만료됨
   ↓ /refresh-token 요청 (Refresh Token 전송)
[AuthController]
   ↓ 유효성 검사, DB 조회
   ↓ 새 토큰 생성 + 저장
   → 클라이언트 응답
```

### 참고링크

https://github.com/spring-projects/spring-security-samples

https://docs.spring.io/spring-framework/reference/web/webmvc/mvc-servlet.html