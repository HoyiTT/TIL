# 리포지터리

## 리포지터리란?
엔티티에 의해 생성된 데이터베이스 테이블에 접근하는 메서드들(예: findAll, save 등)을 사용하기 위한 인터페이스이다.

CRUD를 어떻게 처리할지 정의하는 계층이 바로 리포지터리이다.

엔티티만으로는 데이터베이스에 데이터를 저장하거나 조회할 수 없다. 데이터 처리를 위해서는 실제 데이터베이스와 연동하는 JPA리포지터리가 필요하다.



EX)
[파일명:/sbb/src/main/java/com/mysite/sbb/QuestionRepository.java]
``` java
package com.mysite.sbb;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

}
```

QuestionRepository는 JpaRepository를 상속받는다. JpaRepository는 JPA를 사용하기 위한 인터페이스이다. JpaRepository를 상속할 때는 제네릭스 타입으로 <Question, Integer> 처럼 리포지터리의 대상이 되는 엔티티의 타입(Question)과 해당 엔티티의  PK 타입(Integer)을 명시해야 한다. 이것은 JpaRepository를 생성하기 위한 규칙이다.

|method|기능|
|------|---|
|save()|저장(insert, update)|
|findOne|primary key로 레코드 한건 찾기|
|findAll|전체 레코드 불러오기, 정렬(sort), 페이징(pageble) 가능|
|count()|레코드 갯수|
|delete()|레코드 삭제|


DB에 저장하는 것은 JPA가 해주기 때문에, 리포지터리에는 DB에 저장하는 메서드를 정의할 필요가 없다.

[파일명:/sbb/src/test/java/com/mysite/sbb/SbbApplicationTests.java]
``` java
package com.mysite.sbb;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class SbbApplicationTests {

    @Autowired
    private QuestionRepository questionRepository;

    @Test
    void testJpa() {        
        Question q1 = new Question();
        q1.setSubject("sbb가 무엇인가요?");
        q1.setContent("sbb에 대해서 알고 싶습니다.");
        q1.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(q1);  // 첫번째 질문 저장

        Question q2 = new Question();
        q2.setSubject("스프링부트 모델 질문입니다.");
        q2.setContent("id는 자동으로 생성되나요?");
        q2.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(q2);  // 두번째 질문 저장
    }
}
```

@SpringBootTest 어노테이션은 sbbApplicationTests 클래스가 스프링 부트의 테스트 클래스임을 알려준다.

@Autowired 어노테이션은 스프링의 DI 기능으로 questionRepository를 객체를 스프링이 자동으로 생성해준다.

### 기능 추가

위의 기본 기능을 제외한 조회 기능을 추가하고 싶으면 규칙에 맞는 메서드를 추가 해야 한다.
``` java
public interface QuestionRepository extends JpaRepository<Question, Integer> {
    
    Optional<Question> findById(int i);
    Question findBySubject(String subject);
    Question findBySubjectAndContent(String subject, String content);
    List<Question> findBySubjectLike(String subject);
    Page<Question>findAll(Pageable pageable);
}
```


|method|설명|
|------|---|
|findBy로 시작|쿼리를 요청하는 메서드 임을 알림|
|countBy로 시작| 쿼리 결과 레코드 수를 요청하는 메서드 임을 알림|