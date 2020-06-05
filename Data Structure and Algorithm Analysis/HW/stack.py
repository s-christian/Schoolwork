class Stack():
    class Node():
        def __init__(self, data):
            self.data = data
            self.next = None

    def __init__(self):
        self.top = None
        self.size = 0

    def push(self, x):
        node = self.Node(x)
        node.next = self.top
        self.top = node
        self.size += 1

    def pop(self):
        temp = self.top
        self.top = self.top.next
        self.size -= 1
        return temp

    def print(self):
        if self.size <= 0:
            print("Stack empty")
        else:
            temp = self.top
            while temp is not None:
                print(temp.data, end=" ")
                temp = temp.next
            print()


stack = Stack()
stack.push(5)
stack.push("Bananas")
print("Size:", stack.size)
stack.print()
n = stack.pop()
print(n.data)
print("Size:", stack.size)
stack.print()
stack.pop()
print("Size:", stack.size)
stack.print()
