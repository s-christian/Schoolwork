# Programming Assessment 2 - Problem B2
class Stack():
    class Node():
        def __init__(self, data=None, next=None):
            self.data = data
            self.next = next

    def __init__(self):
        self.top = None
        self.size = 0

    def push(self, x):
        node = self.Node(x, self.top)
        self.top = node
        self.size += 1

    def pop(self):
        self.top = self.top.next
        self.size -= 1

    def search(self, x):
        iter = self.top
        while iter is not None:
            if iter.data == x:
                return True
            iter = iter.next
        return False

    def print(self):
        iter = self.top
        while iter is not None:
            print(iter.data, " ", end='')
            iter = iter.next
        print()


stack = Stack()
for i in range(20):
    n = int(input("Push integer into stack (total of 20 times) : "))
    stack.push(n)

stack.print()
print()

x = int(input("Element to search for in stack: "))
print(x, "found in stack? :", stack.search(x))
