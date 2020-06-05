import random
from collections import deque as Stack

# List class
class SingleLinkedList:
    # Node class nested inside the List class,
    # since you shouldn't be accessing it from outside anyway
    class Node:
        def __init__(self, data=None, next=None):
            self.data = data
            self.next = next

    def __init__(self, head=None):
        self.head = head

    def search(self, data):
        i = self.head
        while i is not None and i.data != data:
            i = i.next
        return i

    def insert(self, data):
        new_node = self.Node(data)
        i = self.head
        if i is None:
            self.head = new_node
        else:
            while i.next is not None:
                i = i.next
            i.next = new_node

    def delete(self, data):
        d = self.search(data)
        if d is not None:
            i = self.head
            if i != d:
                while i.next != d:
                    i = i.next
                i.next = d.next
            else:
                self.head = i.next

    def print(self):
        i = self.head
        while i is not None:
            print(i.data, end=" ")
            i = i.next
        print()

def reverse_linked_list(linked_list):
    s = Stack()
    iter = linked_list.head
    while iter is not None:
        s.append(iter)
        iter = iter.next
    first = s.pop()
    iter = first
    while len(s) > 0:
        iter.next = s.pop()
        iter = iter.next
    iter.next = None
    linked_list.head = first


sll = SingleLinkedList()
for i in range(0, 10):
    sll.insert(random.randint(1, 10))
sll.print()

reverse_linked_list(sll)
sll.print()
