class Binary_Search_Tree():
    class Node():
        def __init__(self, data, lLink=None, rLink=None):
            self.data = data
            self.lLink = lLink
            self.rLink = rLink
    def __init__(self):
        self.head = None
        self.size = 0
    
    def isEmpty(self):
        return self.size == 0

    def insert_helper(self, data, n):  # the purpose of this is to return an actual "hard assignment" (my wording) to an lLink or rLink
        if n is None:  # empty node, return new node for assignment
            return self.Node(data)
        elif n.data == data:  # found data in Binary_Search_Tree, duplicates not allowed, do nothing
            return
        elif data < n.data:  # insert to the left
            n.lLink = self.insert_helper(data, n.lLink)
        else:  # insert to the right
            n.rLink = self.insert_helper(data, n.rLink)
        return n  # return "completed" node with its lLink and rLink "filled out" (my wording), think of buliding the entire Binary_Search_Tree from the bottom up, chaining together nodes
    def insert(self, data):  # will always start at head to insert
        if self.head is None:  # empty tree, insert head
            self.head = self.Node(data)
        elif data == self.head.data:  # found data in Binary_Search_Tree, duplicates not allowed, do nothing
            return
        elif data < self.head.data:  # insert to the left
            self.head.lLink = self.insert_helper(data, bst.head.lLink)
        else:  # insert to the right
            self.head.rLink = self.insert_helper(data, bst.head.rLink)
        self.size += 1  # increment the size of the Binary_Search_Tree
    
    def search(self, data, n):  # n must be a Node object
        if not isinstance(n, self.Node) or n is None:  # if n is not a Node object or is None (empty tree), return
            return False
        if data == n.data:  # found data in Binary_Search_Tree
            return True
        elif data < n.data:  # search to the left
            return self.search(data, n.lLink)
        else:  # search to the right
            return self.search(data, n.rLink)

    def print_inorder(self, n):  # n must be a Node object
        if not isinstance(n, self.Node) or n is None:  # if n is not a Node object or is None (empty tree), return
            return
        self.print_inorder(n.lLink)
        print(n.data, end=' ')
        self.print_inorder(n.rLink)
    

bst = Binary_Search_Tree()
nums = [5, 4, 2, 10, 20, 15]
print(nums)
for num in nums:
    bst.insert(num)
print("bst.head =", bst.head.data)

print()
for num in nums:
    print("{0:<2} found in nums? : {1:}".format(num, bst.search(num, bst.head)))

print()
print("Doing bst.print_inorder:")

bst.print_inorder(bst.head)
print()

print()
print("bst.size =", bst.size)

# Everything works up until this point!