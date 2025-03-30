# Docker 

## 1. Docker란?
Docker는 컨테이너 기반의 가상화 기술을 제공하는 오픈소스 플랫폼이다. 애플리케이션을 컨테이너라는 단위로 패키징하여 배포하고 실행할 수 있다.

### 특징
- **경량화**: 가상 머신(VM)보다 가볍고 빠름.
- **이식성**: 어디서든 실행 가능 (로컬, 서버, 클라우드 등).
- **일관된 환경 제공**: 개발 환경과 배포 환경의 차이를 줄여줌.
- **빠른 배포 및 확장**: 컨테이너 단위로 손쉽게 확장 가능.

---

## 2. Docker 기본 개념
### 2.1 이미지(Image)
- 컨테이너 실행에 필요한 파일과 설정을 포함한 읽기 전용 템플릿.
- `Dockerfile`을 기반으로 생성됨.
- Docker Hub 등의 레지스트리에 저장 및 공유 가능.

### 2.2 컨테이너(Container)
- 이미지를 기반으로 실행되는 독립적인 실행 환경.
- 필요한 애플리케이션과 의존성을 포함.
- 컨테이너는 일시적이지만, 데이터 저장을 위해 볼륨을 사용 가능.

### 2.3 Dockerfile
- 이미지를 생성하는 설정 파일.
- `FROM`, `RUN`, `CMD`, `COPY`, `WORKDIR` 등의 명령어로 구성됨.

### 2.4 볼륨(Volume)
- 컨테이너가 종료되거나 삭제되어도 데이터가 유지되는 저장 공간.

### 2.5 네트워크(Network)
- 컨테이너 간 통신을 가능하게 하는 Docker 네트워크 기능.

---

## 3. Docker 기본 명령어
### 3.1 Docker 설치 확인
```sh
docker --version
```

### 3.2 이미지 관련 명령어
```sh
# 이미지 목록 조회
docker images

# 이미지 다운로드
docker pull <이미지명>:<태그>

# Dockerfile로 이미지 빌드
docker build -t <이미지명> .
```

### 3.3 컨테이너 실행 및 관리
```sh
# 컨테이너 실행
docker run -d -p 8080:80 --name my-container <이미지명>

# 실행 중인 컨테이너 목록 확인
docker ps

# 모든 컨테이너 목록 확인 (종료된 컨테이너 포함)
docker ps -a

# 컨테이너 중지
docker stop <컨테이너ID>

# 컨테이너 삭제
docker rm <컨테이너ID>
```

### 3.4 볼륨 사용
```sh
# 볼륨 생성
docker volume create my-volume

# 볼륨을 컨테이너에 연결하여 실행
docker run -d -v my-volume:/data --name my-container <이미지명>
```

### 3.5 Docker Compose
- 여러 개의 컨테이너를 정의하고 실행하는 도구 (`docker-compose.yml` 사용).

```yaml
version: '3'
services:
  web:
    image: nginx
    ports:
      - "8080:80"
  db:
    image: mysql
    environment:
      MYSQL_ROOT_PASSWORD: root
```

```sh
# docker-compose 실행
docker-compose up -d
```

---

## 4. Docker 네트워크
### 4.1 기본 네트워크 유형
- **Bridge**: 기본 네트워크 모드 (컨테이너 간 통신 가능).
- **Host**: 컨테이너가 호스트 네트워크를 직접 사용.
- **None**: 네트워크를 비활성화.

```sh
# 네트워크 목록 확인
docker network ls

# 새로운 네트워크 생성
docker network create my-network

# 네트워크에 컨테이너 연결하여 실행
docker run -d --network my-network --name my-container <이미지명>
```

---

## 5. Docker와 Kubernetes
- Docker는 개별 컨테이너를 실행하는 기술.
- Kubernetes(K8s)는 여러 컨테이너를 오케스트레이션하는 플랫폼.

---

## 6. Docker Best Practices
1. **작은 단위의 이미지 사용**: 필요 없는 패키지 제거.
2. **멀티스테이지 빌드 활용**: 빌드 이미지와 실행 이미지를 분리.
3. **환경 변수 사용**: `ENV`를 활용하여 설정값 관리.
4. **볼륨을 활용한 데이터 보존**.
5. **컨테이너 로그 관리**: `docker logs` 활용.

---

## 7. Docker를 활용한 Java 개발 환경
```sh
# OpenJDK 기반 컨테이너 실행
docker run -d -v $(pwd):/app -w /app openjdk:17 java -jar myapp.jar
```

### Dockerfile 예제 (Spring Boot)
```dockerfile
FROM openjdk:17
WORKDIR /app
COPY target/myapp.jar myapp.jar
CMD ["java", "-jar", "myapp.jar"]
```

### 실행 방법
```sh
docker build -t myapp .
docker run -d -p 8080:8080 myapp
```

---

## 8. Docker 활용 예시
- github action or Jenkins 와 같은 서비스와 결합하여 cicd 파이프라인에 활용
- **클라우드 환경**에서 컨테이너 기반 애플리케이션 실행.
- **마이크로서비스 아키텍처**에서 서비스 간 격리 및 독립적 배포.
- **로컬 개발 환경 구축** (DB, Redis, API 서버 등).

---

## 9. 결론
Docker는 개발, 배포, 운영을 단순화하는 강력한 도구이다. 컨테이너를 사용하면 환경 차이를 줄이고, 빠르게 배포 및 확장이 가능하다. 특히, Kubernetes와 함께 사용하면 대규모 애플리케이션을 효과적으로 관리할 수 있다.
```