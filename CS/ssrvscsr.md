# SSR VS CSR

## 0. SPA와 MPA

### SPA(Single Page Application)

- 한 개의 페이지로 구성된 어플리케이션
- 페이지 전환 시 서버로부터 새로운 페이지를 받아오지 않고, 자바스크립트를 사용해 현재 페이지를 다시 작성하여 사용자와 상호작용

### MPA(Multi Page Application)

- 여러 개의 페이지로 구성된 어플리케이션
- 페이지 전환 시 서버로부터 새로운 페이지를 받아와 렌더링


## 1. SSR(Server Side Rendering)

### 정의

- 서버에서 사용자에게 보여줄 페이지를 모두 구성하여 사용자에게 전달하는 방식
- 클라이언트가 서버에 컨텐츠를 요청하면, 서버는 페이지에 필요한 데이터를 즉시 얻어와 모두 삽입하고, CSS까지 모두 적용해 렌더링 준비를 마친 HTML,JS,CSS를 클라이언트에게 전달

- 모든 데이터가 이미 HTML에 담긴 채로 브라우저에 전달.

### 특징

- 사용자가 페이지를 요청할 때마다 서버에서 새로운 페이지를 받아와 렌더링
- 초기 로딩 속도가 느릴 수 있으나, 검색 엔진 최적화(SEO)에 유리

### 장점

- 초기 로딩 속도가 빠르다.
- 검색 엔진 최적화(SEO)에 유리하다.

### 단점

- 사용자가 많을 경우 서버에 부하가 걸릴 수 있다.
- 사용자 경험이 떨어질 수 있다.

### 예시

- 네이버, 다음 등 포털 사이트, 블로그(검색 엔진 최적화를 위해)
- 뉴스, 쇼핑몰(초기 렌더링만)



## 2. CSR(Client Side Rendering)

### 정의

- 사용자의 요청에 따라 서버에서 필요한 데이터만 받아와 렌더링하는 방식
- 클라이언트가 서버에 컨텐츠를 요청하면, 서버느 빈 뼈대만 있는 HTML을 응답함. 클라이이언트는 연결된 JS 링크를 통해 서버로부터 다시 JS 파일을 다운받은 뒤, JS를 통해 동적으로 페이지를 만들어 브라우저에 보여줌



### 특징

- 초기 로딩 속도가 빠르지만, 검색 엔진 최적화(SEO)에 불리

### 장점

- 사용자 경험이 좋다.
- 서버에 부하가 적다.

### 단점

- 초기 로딩 속도가 느리다.
- 검색 엔진 최적화(SEO)에 불리하다.

### 예시

- 구글, 페이스북, 인스타그램 등 SNS
- Gmail,GoogleDocs
- slack, GPT 둥


#### SSR + CSR 혼합 예시

혼합 방식은 초기에는 SSR로 렌더링하고, 이후 JavaScript로 CSR처럼 동작하는 방식이다. 초기 로딩 성능과 상호작용성을 동시에 만족시킨다.


Gmail:
→ 초기 화면은 SSR로 렌더링하지만, 이후 받은 메일과 보낸 메일은 CSR 방식으로 동적으로 업데이트된다.

eBay:
→ 초기 상품 목록은 SSR로 로드하지만, 필터 변경 시 CSR로 새 데이터를 비동기적으로 받아 업데이트한다.

Next.js 기반 웹사이트:
→ Next.js는 SSR과 CSR을 혼합하여 SEO와 실시간 상호작용을 모두 충족한다.





## 3. SSR vs CSR

### SSR

- 초기 로딩 속도가 빠르다.
- 검색 엔진 최적화(SEO)에 유리하다.
- 사용자가 많을 경우 서버에 부하가 걸릴 수 있다.
- 사용자 경험이 떨어질 수 있다.

### CSR

- 사용자 경험이 좋다.
- 서버에 부하가 적다.
- 초기 로딩 속도가 느리다.
- 검색 엔진 최적화(SEO)에 불리하다.

## 4. SSR vs CSR 선택 기준

- 초기 로딩 속도가 중요하다면 SSR
- 사용자 경험이 중요하다면 CSR
- 검색 엔진 최적화(SEO)가 중요하다면 SSR
- 서버 부하가 중요하다면 CSR
- 사용자가 많다면 SSR
- 사용자 경험이 중요하다면 CSR

