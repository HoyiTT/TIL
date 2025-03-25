

## 🔄 동기화(Synchronization)

**동기화**란 다수의 프로세스나 스레드가 **공유 자원**에 접근할 때 **충돌이나 예기치 않은 결과를 방지하기 위한 제어 방식**

---

## ✅ 운영체제가 제공하는 동기화의 의미

1. **실행 순서 제어**
   - 예시: 프린터를 사용하는 여러 프로세스가 있을 때, 한 프로세스가 문서 인쇄 중이면 다른 프로세스는 대기해야 함.
   - 🧾 **코드 예시 (의사코드 수준)**  
     ```java
     synchronized void printDocument(String name) {
         System.out.println(name + " 문서 인쇄 중...");
     }
     ```
     → 한 번에 하나의 문서만 인쇄되도록 순서를 제어하는 방식

2. **상호 배제 (Mutual Exclusion)**
   - 예시: 한 은행 계좌에 여러 ATM이 동시에 접근해 입출금하면 잔액 오류 발생 가능 → **동시에 하나의 ATM만 작업** 가능해야 함.

---

## 🛠 공유 자원과 임계구역 (Critical Section)

- **공유 자원**
  - 여러 프로세스나 스레드가 공통적으로 사용하는 자원  
  - 예시: 파일, 메모리, 전역 변수, DB 연결, 프린터 등

- **임계구역 (Critical Section)**
  - 공유 자원에 접근하는 코드 블록  
  - 동시에 여러 프로세스가 접근하면 문제가 발생할 수 있음

---

### 🔥 임계구역 문제: Race Condition (경쟁 상태)

- 예시  
  A 스레드와 B 스레드가 같은 변수 `count`를 1씩 증가시키는 상황
  ```
  count = 0  
  A: 읽기 → 0  
  B: 읽기 → 0  
  A: 쓰기 → 1  
  B: 쓰기 → 1  
  결과: count == 1 (원래는 2가 되어야 함)
  ```
  → 동기화가 없으면 값이 꼬일 수 있음

- ✅ **해결 코드 예시**
  ```java
  class Counter {
      private int count = 0;

      public synchronized void increment() {
          count++;
      }

      public int getCount() {
          return count;
      }
  }
  ```

---

## 🎯 생산자-소비자 문제

- 공유 자원: 버퍼(Queue)  
- 생산자: 버퍼에 데이터를 넣는 역할  
- 소비자: 버퍼에서 데이터를 꺼내는 역할

### 예시  
- 생산자: 유튜브 영상 업로드 서버  
- 소비자: 유저가 영상 스트리밍 요청 시 버퍼에서 읽음  
- 문제점: 버퍼가 가득 찼는데 생산자가 계속 넣거나, 비었는데 소비자가 꺼내려 하면 문제 발생

### ✅ 코드 예시 (BlockingQueue 사용)

```java
import java.util.concurrent.*;

public class ProducerConsumer {
    private static final BlockingQueue<String> buffer = new ArrayBlockingQueue<>(5); // 버퍼 용량 5

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // 생산자
        executor.execute(() -> {
            int videoNum = 1;
            try {
                while (true) {
                    String video = "영상 " + videoNum++;
                    buffer.put(video); // 버퍼가 꽉 차면 대기
                    System.out.println("업로드 완료: " + video);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // 소비자
        executor.execute(() -> {
            try {
                while (true) {
                    String video = buffer.take(); // 버퍼가 비면 대기
                    System.out.println("시청 시작: " + video);
                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
    }
}
```

---

## 🔒 뮤텍스(Mutex)와 세마포어(Semaphore)

### 💡 동기화 해결의 3원칙
1. 상호 배제
2. 진행
3. 유한 대기

---

### 🔐 뮤텍스(Mutex)

- Binary 상태 (lock/unlock)
- 임계 구역 보호

#### ✅ 예시

> 예를 들어 하나의 계좌에서 여러 사람이 동시에 출금을 하려고 하면 안됨 
> 이럴 때는 뮤텍스 락을 걸어서 한 사람만 출금하도록 제어가능.

```java
class BankAccount {
    private int balance = 1000;

    public synchronized void withdraw(int amount, String name) {
        if (balance >= amount) {
            System.out.println(name + " 출금 시도: " + amount);
            balance -= amount;
            System.out.println(name + " 출금 성공! 남은 잔액: " + balance);
        } else {
            System.out.println(name + " 출금 실패! 잔액 부족.");
        }
    }
}
```

---

### 🚦 세마포어(Semaphore)

- 정수값으로 자원 개수 제어

#### ✅ 예시

> 5명만 들어갈 수 있는 세미나실을 10명이 사용하려 할 때,  
> 세마포어를 `5`로 설정하면 최대 동시 5명까지만 입장할 수 있도록 만들 수 있어.

```java
import java.util.concurrent.Semaphore;

public class SeminarRoom {
    private static final Semaphore seats = new Semaphore(5); // 세미나실 입장 제한 인원

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            final int person = i;
            new Thread(() -> {
                try {
                    System.out.println("사람 " + person + " 입장 시도 중...");
                    seats.acquire(); // 자리가 없으면 대기
                    System.out.println("사람 " + person + " 입장 완료!");
                    Thread.sleep(2000); // 세미나 참여 중...
                    System.out.println("사람 " + person + " 퇴장");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    seats.release(); // 자리 반납
                }
            }).start();
        }
    }
}
```

---

## 🔒 교착 상태 (Deadlock)

### ❗ 발생 조건 (4가지 모두 만족 시)

1. **상호 배제**
2. **점유 대기**
3. **비선점**
4. **원형 대기**

---

### 💥 예시

> A 프로세스는 프린터를 사용하고, 이후 스캐너를 요청  
> B 프로세스는 스캐너를 사용하고, 이후 프린터를 요청  
> 서로 상대 자원이 풀리기를 기다리면서 무한 대기 상태에 빠짐

```java
class DeadlockExample {
    static final Object printer = new Object();
    static final Object scanner = new Object();

    public static void main(String[] args) {
        Thread A = new Thread(() -> {
            synchronized (printer) {
                System.out.println("A: 프린터 확보");
                try { Thread.sleep(100); } catch (Exception e) {}
                synchronized (scanner) {
                    System.out.println("A: 스캐너 확보");
                }
            }
        });

        Thread B = new Thread(() -> {
            synchronized (scanner) {
                System.out.println("B: 스캐너 확보");
                try { Thread.sleep(100); } catch (Exception e) {}
                synchronized (printer) {
                    System.out.println("B: 프린터 확보");
                }
            }
        });

        A.start();
        B.start();
    }
}
```

→ 이 코드는 **서로 락을 잡고 상대 자원을 요청**하는 구조이기 때문에 교착 상태가 발생할 수 있음.

---

## 🔧 교착 상태 해결 방법

| 방법 | 설명 | 예시 |
|------|------|------|
| **예방** | 4가지 조건 중 최소 하나 제거 | 비선점 조건 제거 → 일정 시간 동안 자원 못 얻으면 회수 |
| **회피** | 자원 상태를 분석하여 위험한 요청을 회피 | 은행가 알고리즘(Banker's Algorithm) |
| **탐지 및 복구** | 교착 상태를 탐지하고 해결 | 자원 점유 그래프를 만들고 순환 존재 여부 확인 후 프로세스 강제 종료 |

---
