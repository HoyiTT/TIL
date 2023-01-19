# Thymeleaf

Thymeleaf는 JAVA 템플릿 엔진 중에 하나이다.

## 준비
html 문서 상단에 thymeleaf 네임스페이스를 선언해야 한다.

```
<html xmlns:th="http://www.thymeleaf.org">
```

## 변수
```
<p th:text="${name}">이름</p> 
```
이런시으로 ${} 를 사용해 변수를 표현할 수 있다.
