# OS

## 커널
커널 모드 : 커널 영역의 코드를 실행 할 수 있는 모드
사용지 모드 : 커널 영역의 코드를 실행 할 수 없는 모드

시스템 콜 : 운영체제 서비스를 제공받기 위해 커널 모드로 전환하는 것 (소프트웨어 인터럽트)

### 이중모드
커널 모드 : 운영체제 서비스를 제공받을 수 있는 모드(입출력 가능)
사용지 모드 :운영체제 서비스를 제공받을 수 없는 모드(입출력 불가능)

운영체제 서비스 : 프로세스 관리, 자원 관리 접근 및 할당, 파일 시스템 관리

### 대표적인 리눅스 시스템 콜

- open() : 파일을 열고 파일 디스크립터를 반환
- read() : 파일을 읽어 버퍼에 저장
- write() : 버퍼에 있는 내용을 파일에 저장
- close() : 파일을 닫음
- fork() : 자식 프로세스를 생성
- exec() : 새로운 프로그램을 실행
- wait() : 자식 프로세스가 종료될 때까지 대기

