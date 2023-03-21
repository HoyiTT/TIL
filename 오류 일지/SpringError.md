# Sping 오류 일지
Spring을 공부하며 발생한 오류들을 기록합니다.

###  An error happened during template parsing
오류 원인 

실제 엔티티의 필드명과 템플릿에서 사용하는 필드명이 다를 경우 발생합니다.

해결 방법

실제 엔티티의 필드명과 템플릿에서 사용하는 필드명을 동일하게 맞춰주면 해결됩니다.
오늘 같은 경우에는 엔티티의 필드명이 'CREATEDATE' 였지만  html에서 타임리프 엔진을 사용하며 DB를 불러들이는 과정에서 question.createDate로 사용하였습니다. 이때 'createdate'로 변경하니 정상적으로 동작하였습니다.

+) 추가

다시 알아보니 엔티티를 생성할 때 작성한 코드인 Qustion.java에서 LocalDatatime의 컬럼을 생성할 때 createdate로 작성하였습니다. 엔티티 생성이 그렇게 생성되어 이러한 오류가 발생하였습니다. 


### Entity 객체를 생성했지만 h2 DB에 데이블이 생성되지 않는 경우

오류 원인
application.properties에서 Spring JPA관련 환경설정 부분에서 ddl-auto를 create로 설정하지 않은 경우 발생합니다.
```
spring.jpa.hibernate.ddl-auto=none
```

해결 방법
application.properties에서 Spring JPA관련 환경설정 부분에서 ddl-auto를 create로 설정합니다.
```java
spring.jpa.hibernate.ddl-auto=create
```
+) 추가

create로 설정하면 기존에 테이블이 있더라도 삭제하고 새로 생성합니다. 이때 기존에 테이블이 있더라도 삭제하지 않고 변경분만 적용하려면 update로 설정하면 됩니다.


## Spring Securit를 이용하여 로그인 여부를 확인 후 로그인 / 로그아웃 버튼 표시하는 과정에서 둘 다 표시되는 문제

오류 원인
``` java
<a class="nav-link" 

sec:authorize="isAnonymous()" th:href="@{/user/login}">로그인</a>
                    
<a class="nav-link" 

sec:authorize="isAuthenticated()" th:href="@{/user/logout}">로그아웃</a>
```

sec:authorize를 사용할 때 isAnonymous()와 isAuthenticated()를 이용하여 로그인 여부를 구분하려 하였지만 둘 중에 하나만 표시되어야 하는 화면에 두 개가 모두 표시되는 문제가 발생하였습니다.

해결 방법

build.gradle에 아래와 같이 의존성을 변경해주었습니다

전
``` java
implementation 'org.thymeleaf.extras:thymeleaf-extras-springsecurity6:3.1.1.RELEASE' 
```

후
``` java
implementation 'org.thymeleaf.extras:thymeleaf-extras-springsecurity5' 
```

스프링부트 2.7.x 버전을 사용할 시 thymeleaf-extras-springsecurity6를 사용하면 오류가 발생합니다. thymeleaf-extras-springsecurity5를 사용하면 정상적으로 동작합니다.
