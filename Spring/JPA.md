# JPA
Java Presistence API 의 약자

자바의 ORM을 위한 표준 기술

## JPA의 장점
- 생산성
- 유지보수
- 패러다임의 불일치 해결

각기 다른 DB 벤더들이 제공하는 SQL을 직접 작성하지 않아도 된다.
-> DB 벤더에 상관 없이 동일한 코드로 동작한다.

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

## JPA의 구현체
