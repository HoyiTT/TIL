# Controller

URL 매핑을 통해 요청을 처리하는 컨트롤러 클래스를 정의한다.

ex)
/question/list URL에 대한 매핑을 정의한다.

```
@Controller
public class QuestionController {

    @GetMapping("/question/list")
    @ResponseBody
    public String list() {
        return "question list";
    }
}
```

## Thyemeleaf

스프링 부트에서 사용할 수 있는 템플릿 엔진에는 타임리프, 머스테치, JSP 등이 있다.
타임리프는 스프링 부트에서 기본으로 제공하는 템플릿 엔진이다.

타임리프를 사용하려면 설치가 필요하다. 다음과 같이 build.gradle 파일을 수정하자.

```
dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'
    implementation 'nz.net.ultraq.thymeleaf:thymeleaf-layout-dialect'
}
```

그 후 
src/main/resources/templates 폴더를 생성하고,  html 폴더를 생성한다.

ex) /src/main/resources/templates/main.html

그 후 컨트롤러 파일을 수정해준다.

```
@Controller
public class QuestionController {

    @GetMapping("/question/list")
    public String list() {
        return "main";
        // html 파일명과 동일한 문자열을 리턴한다.
    }
}
```

그 후 http://localhost:8080/question/list URL로 접속하면 다음과 같이 화면이 출력된다.



