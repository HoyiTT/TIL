# Welcome Page
# 1. 정적 페이지

resoureces/static안에 index.html 파일을 생성해 넣어주기만 하면 된다.

resoureces/static/index.html
```
<!DOCTYPE HTML>
<html>
<head>
    <title>Hello</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> </head>
<body>
Hello World!!
</body>
</html>

```

결과
(localhost:8080 (포트는 다를 수 있음!))

<img src=img/hello_world.JPG>




# 2. 동적 페이지

## thyymeleaf 템플릿 엔진 사용

java/hello.hellospring 안에 controller라는 패키지를 생성해준다.

그 안에 HelloController 이라는 클래스를 생성해준다.

(참고로 Tree Appearance는 Compact middle packages이다.)

<img src=img/hellocontroller1.JPG>

java/hello.hellospring/controller/HelloController
```
package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello";
    }
}

```

그 후 
resources에 templates에 hello.html을 만들고 

<img src=img/hellohtml1.jpg>

resources/templates/hello.html 를 생성해 작성해준다.

resources/templates/hello.html
```
<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Hello</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> </head>
<body>
<p th:text="'안녕하세요. ' + ${data}" >안녕하세요. 손님</p>
</body>
</html>
```

결과
(localhost:8080/hello)

<img src="img/hellohtml2.jpg">


정리

HelloController를 통해 입력한

data:hello!!! 가 그대로 출력된 내용이다.

<img src="img/원리1.jpg">

브라우저(클라이언트)에서 서버에 localhost:8080/hello를 요청하면 

스프링 부트에 내장된 톰캣서버에서 컨테이너에서 "hello"컨트롤러가 있는지 확인 후

모뎅(data:"hello!!")과 hello를 리턴한다.

그 후 뷰 리졸버에서 thymeleaf템플릿 엔진 처리 후 hello.html로 변환하여

응답해준다.
