# Node

```py
class Node:
    def __init__(self, value = 0, next = None):
        self.value = value
        self.next = next


first = Node(1)
second = Node(2)
third = Node(3)
first.next = second
second.next = third
first.value = 5
```