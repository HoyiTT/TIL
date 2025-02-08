# 시스템 콜

운영체제 서비스를 제공받기 위한 요청을 의미

## 시스템 콜의 종류

1. 프로세스 제어

    - fork(): 새로운 프로세스 생성
    - exec(): 새로운 프로세스 실행
    - wait(): 자식 프로세스가 종료될 때까지 대기
    - exit(): 프로세스 종료

2. 파일 관리

    - open(): 파일 열기
    - read(): 파일 읽기
    - write(): 파일 쓰기
    - close(): 파일 닫기


3. 장치 관리

    - read(): 장치 읽기
    - write(): 장치 쓰기
    - ioctl(): 장치 제어

4. 정보 유지

    - getpid(): 프로세스 ID 반환
    - alarm(): 시간 경과 시그널 전송
    - sleep(): 프로세스 지정 시간 동안 대기


## 시스템 콜의 동작

1. 사용자 프로그램이 시스템 콜을 호출

2. 사용자 모드에서 커널 모드로 전환

3. 커널이 시스템 콜을 처리

4. 처리 결과를 사용자 프로그램에 반환

## 시스템 콜의 예시

1. `fork()`

    - 부모 프로세스가 자식 프로세스를 생성

    ```c
    #include <stdio.h>
    #include <unistd.h>

    int main() {
        int pid = fork();
        if (pid == 0) {
            printf("자식 프로세스\n");
        } else {
            printf("부모 프로세스\n");
        }
        return 0;
    }
    ```

2. `exec()`

    - 새로운 프로세스를 실행

    ```c
    #include <stdio.h>
    #include <unistd.h>

    int main() {
        execl("/bin/ls", "ls", "-al", NULL);
        return 0;
    }
    ```


3. `wait()`

    - 자식 프로세스가 종료될 때까지 대기

    ```c
    #include <stdio.h>
    #include <unistd.h>
    #include <sys/wait.h>

    int main() {
        int pid = fork();
        if (pid == 0) {
            printf("자식 프로세스\n");
        } else {
            wait(NULL);
            printf("부모 프로세스\n");
        }
        return 0;
    }
    ```

4. `exit()`

    - 프로세스 종료

    ```c
    #include <stdio.h>
    #include <stdlib.h>

    int main() {
        printf("프로세스 종료\n");
        exit(0);
    }
    ```

5. `open()`

    - 파일 열기

    ```c
    #include <stdio.h>
    #include <fcntl.h>

    int main() {
        int fd = open("test.txt", O_RDONLY);
        if (fd == -1) {
            printf("파일 열기 실패\n");
        } else {
            printf("파일 열기 성공\n");
        }
        return 0;
    }
    ```

    