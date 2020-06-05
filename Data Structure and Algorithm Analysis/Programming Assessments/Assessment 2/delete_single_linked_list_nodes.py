# Programming Assessment 2 - Problem E1
class LinkedList():
    class Node():
        def __init__(self, data=None, next=None):
            self.data = data
            self.next = next

    def __init__(self):
        self.head = None

    def insert(self, x):
        node = self.Node(x)
        if self.head == None:
            self.head = node
        else:
            temp = self.head
            while temp.next is not None:
                temp = temp.next
            temp.next = node

    def delete_nodes(self, y, x):
        temp = self.head
        for i in range(1, y):
            temp = temp.next
        temp2 = temp.next
        for i in range(1, x+1):
            temp2 = temp2.next
        temp.next = temp2

    def print(self):
        temp = self.head
        while temp is not None:
            print(temp.data, end=" ")
            temp = temp.next
        print()


llist = LinkedList()
print("--- Fill the list with 20 random integers ---")
for i in range(20):
    n = int(input("Insert "))
    llist.insert(n)
llist.print()
print("Go to node y and delete x nodes after it:")
y, x = -1, -1
while y < 1 or y > 19:
    y = int(input("y = "))
while x < 0 or x > 20 - y:
    x = int(input("x = "))
llist.delete_nodes(y, x)
llist.print()
