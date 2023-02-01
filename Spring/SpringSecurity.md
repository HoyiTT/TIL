# Spring Security

Spring Security는 Spring 기반의 애플리케이션의 보안(인증과 권한, 인가 등)을 담당하는 스프링 하위 프레임워크이다. 

EX)

```
<li class="nav-item">
          <a class="nav-link" sec:authorize access="isAnonymous()" th:href="@{/user/login}">로그인</a>
          <a class="nav-link" sec:authorize access="isAuthenticated()" th:href="@{/user/logout}">로그아웃</a>
        </li>
```

Spring security에 의해 로그인이 되어있는지 아닌지에 따라 보여지는 링크가 달라진다.

