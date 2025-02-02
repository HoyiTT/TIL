# 교착상태(deadlock)

## 교착상태란?

두 개 이상의 작업이 서로 상대방의 작업이 끝나기만을 기라디고 있어 결과적으로 아무것도 완료되지 못하는 상태를 의미.

## 교착상태의 필요조건

1. 상호배제(Mutual Exclusion): 자원은 한 번에 한 프로세스만 사용할 수 있어야 한다.
2. 점유대기(Hold and Wait): 프로세스가 할당된 자원을 가진 상태에서 다른 자원을 기다리고 있다.
3. 비선점(No Preemption): 다른 프로세스에 할당된 자원을 강제로 빼앗을 수 없다.
4. 순환대기(Circular Wait): 프로세스의 집합 {P0, P1, P2, ..., Pn}에서 P0는 P1이 점유한 자원을 대기하고, P1은 P2가 점유한 자원을 대기하고, P2는 Pn이 점유한 자원을 대기하고, Pn은 P0이 점유한 자원을 요구해야 한다.
