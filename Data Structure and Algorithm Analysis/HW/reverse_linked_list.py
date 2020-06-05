from collections import deque

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
    temp = linked_list.head
    if temp is not None and temp.next is not None:
        stack = deque()
        while temp is not None:
            stack.append(temp)
            temp = temp.next
        new_head = stack.pop()
        temp = stack.pop()
        new_head.next = temp
        while len(stack) > 0:
            temp.next = stack.pop()
            temp = temp.next
        temp.next = None
        linked_list.head = new_head


new_list = SingleLinkedList()
new_list.insert(5)
new_list.insert(10)
new_list.insert(2)
new_list.insert(77)
new_list.insert(154)
new_list.insert(14)
new_list.insert(89)
new_list.print()

reverse_linked_list(new_list)
new_list.print()
