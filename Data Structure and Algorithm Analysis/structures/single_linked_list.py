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
            print(i.data, end=' ')
            i = i.next
        print()


list = SingleLinkedList()
list.insert(5)
list.insert(10)
list.insert(2)
list.print()
print(list.search(3) is not None)
print(list.search(10) is not None)
print(list.search(2) is not None)
list.delete(10)
list.print()
