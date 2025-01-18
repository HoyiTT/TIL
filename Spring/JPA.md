# JPA
Java Presistence API 의 약자

자바의 ORM을 위한 표준 기술

## JPA의 장점
- 생산성
- 유지보수
- 패러다임의 불일치 해결

각기 다른 DB 벤더들이 제공하는 SQL을 직접 작성하지 않아도 된다.
-> DB 벤더에 상관 없이 동일한 코드로 동작한다.

## JPA의 동작 과정
1. JPA는 애플리케이션과 JDBC 사이에서 동작한다.
2. JPA는 JDBC API를 사용해서 SQL을 DB에 전달한다.
3. JDBC는 SQL을 DB에 전달하고 결과를 받아온다.
4. JPA는 JDBC가 받아온 결과를 자바 객체에 매핑한다.
5. JPA는 애플리케이션에 자바 객체를 반환한다.

### JDBC?

JDBC는 Java Database Connectivity 의 약자로 자바에서 데이터베이스에 접근할 수 있도록 하는 자바 API이다. DBMS에 종속되지 않는 관련 API를 제공한다.

## JPA의 구현체
- Hibernate
- EclipseLink
- DataNucleus

## ORM
Object Relational Mapping 의 약자 
자바의 객체와 관계형 DB의 데이터를 매핑해주는 기술

SQL문을 일일이 작성하지 않아도 객체를 통해 DB에 접근할 수 있게 해준다.

ex) 테이블의 구성 예시

|ID|Subject|Content|
|------|---|---|
|1|안녕하세요|신입이에요|
|2|반갑습니다|잘 부탁 드립니다|
|...|...|...|

sql 쿼리로 작성할 시
``` sql
insert into question (subject, content) values ('안녕하세요', '신입이에요');
insert into question (subject, content) values ('반갑습니다', '잘 부탁 드립니다');
```

JPA를 사용하면
``` java
Question q1 = new Question();
q1.setSubject("안녕하세요");
q1.setContent("신입이에요");
this.questionRepository.save(q1);

Question q2 = new Question();
q2.setSubject("반갑습니다");
q2.setContent("잘 부탁 드립니다");
this.questionRepository.save(q2);
```
로 작성할 수 있다.

가독성이 좋고 DB 벤더에 상관없이 사용할 수 있다!


## 엔티티

다음과 같은 엔티티가 있다고 가정해보자

|속성명|설명|
|------|---|
|id|질문의 고유 번호|
|subject|질문의 제목|
|content|질문의 내용|
|createDate|질문의 생성일|

이러한 엔티티를 생성하기 위한 클래스를 작성해보자

```java
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;
```

엔티티로 만들기 위해 Question 클래스에 @Entity 애너테이션을 적용했다. @Entity 애너테이션을 적용해야 JPA가 엔티티로 인식한다. 그리고 Getter, Setter 메서드를 자동으로 생성하기 위해 롬복의 @Getter, @Setter 애너테이션을 적용했다.

컨트롤러에 @Controller 애너테이션을 적용하는 것과 마찬가지로 엔티티는 @Entity 애너테이션을 적용해야 한다.



---

## 주요 어노테이션

###  @Entity
- JPA에서 엔티티 클래스를 지정하는 어노테이션입니다.
- 이 어노테이션이 붙은 클래스는 데이터베이스 테이블에 매핑됩니다.

```java
import javax.persistence.Entity;

@Entity
public class Member {
    @Id
    private Long id;
    private String name;
}
```

###  @Id
- 기본 키를 나타내는 필드에 사용됩니다.

### @GeneratedValue
- 기본 키의 값을 자동 생성할 때 사용합니다.
- 전략:
  - `GenerationType.IDENTITY`: 데이터베이스에 위임
  - `GenerationType.SEQUENCE`: 시퀀스 객체를 사용
  - `GenerationType.TABLE`: 별도의 키 생성용 테이블 사용
  - `GenerationType.AUTO`: 자동 선택

```java
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
```

###  @Column
- 테이블의 열에 매핑되는 필드를 지정합니다.
- 속성: name, length, nullable 등

```java
@Column(name = "username", length = 50, nullable = false)
private String name;
```

---

## JPA 주요 인터페이스

###  EntityManager
- 엔티티를 저장, 수정, 삭제, 조회하는 데 사용됩니다.

```java
EntityManager em = emf.createEntityManager();
```

###  EntityTransaction
- 트랜잭션 관리를 위한 인터페이스입니다.

```java
EntityTransaction transaction = em.getTransaction();
transaction.begin();
em.persist(entity); // 엔티티 저장
transaction.commit();
```

---

## JPQL (Java Persistence Query Language)
- JPA에서 제공하는 객체 지향 쿼리 언어입니다.
- SQL과 유사하지만 엔티티 객체를 대상으로 쿼리합니다.

```java
String jpql = "SELECT m FROM Member m WHERE m.name = :name";
List<Member> result = em.createQuery(jpql, Member.class)
                        .setParameter("name", "John")
                        .getResultList();
```

---
