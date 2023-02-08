# Spring Boot Validation

화면에서 전달받은 입력 값을 검증할때는 Spring Boot Validation 라이브러리를 사용한다.

## 준비
build.gradle에 아래와 같이 의존성을 추가한다.

```groovy       
dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-validation'
}
```

"Spring Boot Validation"을 설치하면 다음과 같은 애너테이션들을 사용하여 입력 값을 검증할 수 있다.

- @Null : null만 허용
- @NotNull : null이 아닌 값만 허용
- @AssertTrue : true만 허용
- @AssertFalse : false만 허용
- @Min(value) : 최소값을 지정
- @Max(value) : 최대값을 지정
- @DecimalMin(value) : 최소값을 지정
- @DecimalMax(value) : 최대값을 지정
- @Size(max, min) : 최소, 최대값을 지정
- @Digits (integer, fraction) : integer와 fraction의 최대값을 지정
- @Past : 과거 날짜만 허용
- @Future : 미래 날짜만 허용
- @Pattern(value) : 정규표현식을 지정
....

에시
    
```java
    public class QuestionForm {
        
    @NotEmpty(message="제목은 필수항목입니다.")
    @Size(max=200)
    private String subject;

    @NotEmpty(message="내용은 필수항목입니다.")
    private String content;
}
```

