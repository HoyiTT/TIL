# from node import Node

# self는 메서드가 호출된 객체를 의미(클래스의 인스턴스를 의미)

class Node:
    def __init__(self, value = 0, next = None):
        self.value = value
        self.next = next


class LinkedList(object):
    def __init__(self):
        self.head = None

    # O(N)
    def append(self,value):
        new_node = Node(value)
        if self.head is None:
            self.head = new_node
        else:
            current = self.head
            while current.next:
                current = current.next
            current.next = new_node

    # O(N)
    def get(self,idx):
        current = self.head
        for _ in range(idx):
            current = current.next
        return current.value


    def insert(self, idx, value):
        new_node = Node(value)
        current = self.head
        for _ in range(idx - 1):
            current = current.next
        new_node.next = current.next
        current.next = new_node

    def remove(self, idx):
        current = self.head
        for _ in range(idx - 1):
            current = current.next
        current.next = current.next.next

        

if __name__ == "__main__":
    ll = LinkedList()

    ll.append(1)
    ll.append(2)
    ll.append(3)
    ll.append(4)
    ll.append(5)

    # ll.get(0) 
    # ll.get(1) 
    # ll.get(2)

    # ll.insert(idx = 2, value = 9)

    ll.remove(3) 

    print(ll)

        
