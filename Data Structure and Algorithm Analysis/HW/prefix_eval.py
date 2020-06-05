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


def prefix_eval(arr):
    stack = Stack()
    n = len(arr) - 1
    while n >= 0:
        if type(arr[n]) == int:
            stack.push(arr[n])
        else:
            a = stack.pop()
            b = stack.pop()
            print("%f %s %f" % (a.data, arr[n], b.data))
            print(eval("%f %s %f" % (a.data, arr[n], b.data)))
            stack.push(eval("%f %s %f" % (a.data, arr[n], b.data)))
        n -= 1
    return stack

# - + / * 5 6 * 7 8 * / 9 10 11 + 12 13
# (5*6) / (7*8) + (9/10 * 11) - (12+13)
prefix_string = ['-', '+', '/', '*', 5, 6, '*', 7, 8, '*', '/', 9, 10, 11, '+', 12, 13]
print(prefix_string)
stack = prefix_eval(prefix_string)
stack.print()
