# 리포지터리

## 리포지터리란?
엔티티에 의해 관리되는 데이터베이스에 접근하는 메서드들을 모아놓은 인터페이스이다.

CRUD를 어떻게 처리할지 정의하는 계층이 바로 리포지터리이다.


EX)
[파일명:/sbb/src/main/java/com/mysite/sbb/QuestionRepository.java]
```
package com.mysite.sbb;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

}
```
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
