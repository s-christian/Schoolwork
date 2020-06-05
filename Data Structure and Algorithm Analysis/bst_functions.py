class Node:
    def __init__(self, data, left_link=None, right_link=None):
        self.data = data
        self.left_link = left_link
        self.right_link = right_link

    def insert(self, data):
        if self.data == data:
            return False
        elif self.data > data:
            if self.left_link:
                return self.left_link.insert(data)
            else:
                self.left_link = Node(data)
                return True
        else:
            if self.right_link:
                return self.right_link.insert(data)
            else:
                self.right_link = Node(data)
                return True

    def find(self, data):
        if self.data == data:
            return True
        elif self.data > data:
            if self.left_link:
                return self.left_link.find(data)
            else:
                return False
        else:
            if self.right_link:
                return self.right_link.find(data)
            else:
                return False

    def delete(self, data):
        if self.right_link == data or self.left_link == data:
            if self.right_link:
                node = self.findMin(self.right_link)
            else:
                node = self.findMin(self.left_link)
            if node:
                node.right_link = self.right_link
                node.left_link = self.left_link
            if self.right_link == data:
                self.right_link = node
            else:
                self.left_link = node
        elif self.data > data:
            if self.left_link:
                return self.left_link.delete(data)
            else:
                return False
        else:
            if self.right_link:
                return self.right_link.delete(data)
            else:
                return False

    def findMin(self, node):
        if node.left_link:
            return self.findMin(node.left_link)


class BST:
    def __init__(self):
        self.root = None
        self.size = 0

    def insert(self, data):
        if self.root:
            return self.root.insert(data)
        else:
            self.root = Node(data)
            return True

    def delete(self, data):
        if self.find(data):
            return self.root.delete(data)
        else:
            return False

    def find(self, data):
        if self.root:
            return self.root.find(data)
        else:
            return False  #it messes up here for some reason

    def print_inorder(self, node):
        if node:
            self.print_inorder(node.left_link)
            print(node.data, end=' ')
            self.print_inorder(node.right_link)


bst = BST()
bst.insert(5)
bst.insert(3)
bst.insert(2)
bst.insert(4)
bst.insert(8)
bst.insert(10)
bst.print_inorder(bst.root)
print()
print(bst.delete(8))
bst.print_inorder(bst.root)
print()
print(bst.find(8))
