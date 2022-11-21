# thymeleaf 템플릿 엔진
ava/hello.hellospring 안에 controller라는 패키지를 생성해준다.

그 안에 HelloController 이라는 클래스를 생성해준다.

(참고로 Tree Appearance는 Compact middle packages이다.)

<img src=img/hellocontroller1.JPG>

java/hello.hellospring/controller/HelloController
```
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

<img src=img/hellohtml1.JPG>

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

<img src=img/hellohtml2.JPG>


HelloController를 통해 입력한

data:hello!!! 가 그대로 출력된 내용이다.

<img src=img/원리1.JPG>

컨트롤러에서 리턴 값으로 반환된 문자로 뷰 리졸버가 화면을 찾아서 처리한다.

resources:templates/{ViewName}.html


# 정적 페이지

resoureces/static/hello-static.html
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

실행
(localhost:8080/hello-static.html (포트는 다를 수 있음!))

<img src=img/원리2.jpg>

컨트롤러에 hello-static관련 컨트롤러가 없으므로 바로 정적인 페이지가 출력되게 된다.



# MVC와 템플릿 엔진

MVC : Model, View. Controller

Controller
```
@Controller
public class HelloController {
    @GetMapping("hello-mvc")
        public String helloMvc(@RequestParam(value = "name", required = false) String name, Model model){
            model.addAttribute("name", name);
            return "hello-template";
        }
}
```

View
templates/hello-template.html
```
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<body>
<p th:text="'hello. ' + ${name}"></p>
</body>
</html>
```

실행
(localhost:8080/hello-mvc?name=spring (포트는 다를 수 있음!))

<img src=img/원리3.jpg>

컨트롤러에 hello-mvc관련 컨트롤러가 있기에 뷰 리졸버를 통하여 html로 변환되어 출력된다.


# API

```
@Controller
public class HelloController {
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    //리턴 값이 텍스트가 아니라 객체가 오면 JSON 방식으로 출력함(기본 정책)

    //Getter Setter
    static class Hello{
        private String name;

        public String getName(){
            return name;
        }

        public void setName(String name){
            this.name = name;
        }
    }
}
```
@ResponseBody를 사용하고, 객체를 반환하면 객체가 JSON으로 변환되어 출력된다.
(객체가 아닐경우는 일반적인 String으로 출력됨)

<img src=img/원리4.jpg>
