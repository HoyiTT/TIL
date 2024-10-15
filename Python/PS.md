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

# Queue

``` python
from collections import deque

q = deque()

q.append(1)
q.popleft()
```
