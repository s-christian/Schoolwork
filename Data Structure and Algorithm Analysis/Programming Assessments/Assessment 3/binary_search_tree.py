class Node():
    def __init__(self, data, leftChild=None, rightChild=None):
        self.data = data
        self.leftChild = leftChild
        self.rightChild = rightChild

    def insert(self, data):
        if self.data == data:
            return False
        elif self.data > data:
            if self.leftChild:
                self.leftChild.insert(data)
            else:
                self.leftChild = Node(data)
                return True
        else:
            if self.rightChild:
                self.rightChild.insert(data)
            else:
                self.rightChild = Node(data)
                return True

    def find(self, data):
        if self.data == data:
            return True
        elif self.data > data:
            if self.leftChild:
                return self.leftChild.find(data)
            else:
                return False
        else:
            if self.rightChild:
                return self.rightChild.find(data)
            else:
                return False

    def delete(self, data):
        if self.data > data:
            self.leftChild = self.leftChild.delete(data)
        elif self.data < data:
            self.rightChild = self.rightChild.delete(data)
        else:  # self.data == data
            if self.leftChild is None and self.rightChild is None:
                return None
            elif self.leftChild is None:  # has a right child
                return self.rightChild
            elif self.rightChild is None:  # has a left child
                return self.leftChild
            else:  # has two children, left and right
                newNode = self.rightChild.findMin()
                newNode.leftChild = self.leftChild
                return newNode
        return self

    def findMin(self):
        if self.leftChild is None:
            return self
        else:  # has self.leftChild
            if self.leftChild.leftChild:  # can continue down left path
                return self.leftChild.findMin()
            else:  # return last node from left path, rebuilt properly
                newNode = self.leftChild
                self.leftChild = newNode.rightChild
                newNode.rightChild = self
                return newNode

    def inOrder(self):
        if self.leftChild:
            self.leftChild.inOrder()
        print(self.data, end=' ')
        if self.rightChild:
            self.rightChild.inOrder()


class BST():
    def __init__(self, root=None):
        self.root = root

    def insert(self, data):
        if self.root:
            self.root.insert(data)
        else:
            self.root = Node(data)
            return True

    def find(self, data):
        if self.root:
            return self.root.find(data)
        else:
            return False

    def delete(self, data):
        if self.root:
            self.root = self.root.delete(data)
        else:
            return False

    def inOrder(self):
        if self.root:
            self.root.inOrder()
        else:
            print("Tree is empty")


# TESTING SPACE
bst = BST()
print("New tree created")
bst.inOrder()
print()
print("Inserting...")
print()
bst.insert(20)
bst.insert(10)
bst.insert(30)
bst.insert(5)
bst.insert(6)
bst.insert(7)
bst.insert(25)
bst.insert(27)
bst.insert(35)
print("After inserts:")
bst.inOrder()
print()
print()
print("Searching for nodes with values, 5, 25, 7, 35, 1000...")
print(bst.find(5))
print(bst.find(25))
print(bst.find(7))
print(bst.find(35))
print(bst.find(1000))
print()
print("Deleting node with value 7...")
bst.delete(7)
print("After node deletion:")
bst.inOrder()
print()
print("Deleting node with value 20 (the root)...")
bst.delete(20)
print("After node deletion:")
bst.inOrder()
print()
print("Deleting node with value 30...")
bst.delete(30)
bst.inOrder()
print()
