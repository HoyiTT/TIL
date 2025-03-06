# JPA와 ORM

## ORM (Object-Relational Mapping)
객체 지향 프로그래밍(OOP)의 객체와 관계형 데이터베이스(RDB)의 데이터를 매핑하는 기술

객체(Entity)와 데이터베이스의 테이블을 매핑하여, SQL을 직접 작성하지 않고도 데이터를 저장, 조회, 수정, 삭제할 수 있도록 해줌

예를들어, User 테이블의 데이터를 출력하기 위해서 MySQL에서는 SELECT * FROM user; 라는 query를 실행해야 하지만,

ORM을 사용하면 User 테이블과 매핑된 객체를 user라 할 때, user.findAll() 라는 메서드 호출로 데이터 조회가 가능

대표적인 ORM 프레임워크: JPA, Hibernate, MyBatis(일부 ORM 기능 포함)

## JPA (Java Persistence API)
Java의 공식 ORM 표준 인터페이스

ORM을 추상화한 자바의 API이며, 특정 구현체(예: Hibernate, EclipseLink, OpenJPA 등)를 사용해야 함

직접 SQL을 작성하지 않고, 객체를 조작하는 것만으로 데이터베이스 연동 가능

주요 기능:

객체와 관계형 데이터베이스 매핑 (@Entity, @Table, @Column 등)

트랜잭션 관리 및 영속성 컨텍스트 (EntityManager, flush(), detach() 등)

JPQL(Java Persistence Query Language) 지원

캐시와 지연 로딩(Lazy Loading) 기능 제공

## JPA의 계층도

![jpa](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FcrVG6z%2FbtsysGHrYrp%2FuXKHa6h1hdSQsntX2sdXQ0%2Fimg.png)

Spring Data JPA   →   JPA (Java Persistence API)   →   Hibernate (JPA 구현체)   →   JDBC (저수준 API)
(최상위, 가장 편리함)               (표준 ORM API)                (ORM 프레임워크)                 (가장 기초적인 DB 연결)



## JPA의 등장 과정

1. JDBC 기반의 데이터 접근 방식의 한계(직접 쿼리를 작성해야함, 객체 지향 프로그래밍과 관계형 데이터베이스간의 불일치)
2. Hibernate 등 ORM 프레임워크의 등장(객체와 데이터베이스를 매핑해주는 기술) -> 일관된 표준이 없었음
3. JPA 등장(ORM을 사용하기 위한 자바 API 표준 인터페이스) -> 기술을 표쥰화하려 ORM 프레임워크가 JPA를 구현하도록 강제
4. Spring Data JPA 등장(스프링에서 JPA를 쉽게 사용할 수 있도록 지원)

### 1. JDBC (Java Database Connectivity)
가장 기초적인 Java의 데이터베이스 연결 API.
SQL을 직접 작성하고, Connection, Statement, ResultSet 등을 이용하여 데이터를 조회/삽입/수정/삭제함.
가장 낮은 수준의 데이터베이스 접근 방식이며, 코드의 반복이 많고 유지보수가 어려움.

✅ 특징

SQL을 직접 작성해야 함.
Java 코드에서 Connection, Statement, ResultSet을 직접 다룸.
데이터베이스 변경 시 SQL 수정 필요.

🔽 단점 극복을 위해 Hibernate 같은 ORM 프레임워크 등장.

### 2. Hibernate (JPA 구현체, ORM 프레임워크)
Hibernate는 JDBC의 번거로움을 해결하고 객체와 관계형 데이터베이스를 매핑해주는 ORM 프레임워크.
SQL을 직접 작성하지 않아도 엔티티(Entity) 객체를 통해 데이터를 조작할 수 있음.
하지만 Hibernate는 독자적인 방식으로 ORM을 구현했기 때문에, 표준화된 방식이 아님.

✅ 특징

객체와 테이블을 자동으로 매핑.
SQL을 직접 작성하지 않고, 객체의 메서드를 통해 데이터 조작 가능.
1차 캐시, 지연 로딩(Lazy Loading) 같은 최적화 기능 제공.

🔽 하지만 Hibernate는 표준이 아니었고, 다른 ORM 프레임워크(TopLink, iBatis 등)와 통일된 방식이 필요했음. 이를 해결하기 위해 JPA 등장.

### 3. JPA (Java Persistence API)

Hibernate를 포함한 여러 ORM 기술을 표준화한 Java의 공식 ORM API.
인터페이스 기반의 표준 ORM으로, JPA 자체로는 동작하지 않고 Hibernate 같은 구현체가 필요함.
EntityManager를 통해 데이터를 관리하며, SQL 대신 JPQL(Java Persistence Query Language) 을 사용.

✅ 특징

ORM 기술을 표준화함 (특정 구현체에 종속되지 않음).
@Entity, @Table, @Column 등 어노테이션을 이용해 객체와 테이블을 매핑.
JPQL을 사용하여 객체 중심 쿼리 작성 가능.

🔽 JPA는 표준이지만 여전히 EntityManager를 직접 사용해야 하므로 코드가 복잡할 수 있음 → Spring Data JPA 등장.

### 4. Spring Data JPA
Spring에서 JPA를 더 쉽게 사용할 수 있도록 추상화한 라이브러리.
JpaRepository, CrudRepository 등의 인터페이스를 제공하여 SQL 없이도 CRUD 작업이 가능.
JPA의 반복적인 코드를 줄이고, 더 간결한 방식으로 데이터 접근을 가능하게 함.

✅ 특징

JpaRepository 인터페이스만 상속하면 기본적인 CRUD 기능이 자동 제공됨.
메서드 이름만으로도 쿼리 자동 생성 (findByName(), findByEmail())
JPQL을 직접 사용할 필요 없이 메서드 쿼리(@Query)를 활용할 수 있음.


## 결론

ORM은 개념, JPA는 자바에서 ORM을 구현하는 표준 API