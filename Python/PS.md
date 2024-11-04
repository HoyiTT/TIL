# DFS

``` python
def dfs(c):
    ansDfs.append(c)
    v[c] = 1
    for n in g[c]:
        if not v[n]:
            dfs(n)
```

# BFS

``` python
def bfs(s):
    q = deque()
    q.append(s)
    ansBfs.append(s)
    v[s] = 1
    
    while q:
        c = q.popleft()
        for n in g[c]:
            if not v[n]:
                q.append(n)
                ansBfs.append(n)
                v[n] = 1
    
```

# 리스트로 방문 처리를 할 수 없는 이유

    리스트는 방문 처리를 할 때 시간복잡도가 O(N)이기 때문에 비효율적이기도 하지만,
    근본적으로 파이썬에서 리스트는 주소값을 참조하는 방식이기 때문에 방문 처리를 할 수 없다.
    동일한 요소를 가지더라도 주소값이 다르기 때문이다.

# Queue

``` python
from collections import deque

q = deque()

q.append(1)
q.popleft()
```

# set을 이용한 연산

sorted를 활용해 set에서 - 연산을 할 수 있다.

``` python
ori = set(i for i in range(1, 10001))

data = set()

for i in range(1, 10001):
    tmp = i
    i = str(i)
    for s in range(len(i)):
        tmp += int(i[s])
    data.add(tmp)

ans = sorted(ori - data)
```

# combinations 활용

``` python
from itertools import combinations
chickens = [(0,1), (0,2),(0,3)]
M = 2
for chicken_comb in combinations(chickens, M):
    print(chicken_comb)
```
실행 시

```
((0, 1), (0, 2))
((0, 1), (0, 3))
((0, 2), (0, 3))
```

와 같이 조합을 구할 수 있다.

# 리스트 컴프리헨션 (List Comprehension)

리스트 컴프리헨션을 사용하면 반복문과 조건문을 간단하게 작성하여 리스트를 생성할 수 있습니다. 기본 구문은 다음과 같습니다:

```python
[표현식 for 변수 in iterable if 조건문]

even_numbers = [x for x in range(1, 11) if x % 2 == 0]
print(even_numbers)  # 출력: [2, 4, 6, 8, 10]
```


