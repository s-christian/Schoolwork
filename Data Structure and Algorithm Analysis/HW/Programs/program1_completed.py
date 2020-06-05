class SingleLinkedList:
    class Node:
        def __init__(self, r=None, c=None, next=None):
            self.r = r
            self.c = c
            self.next = next

    def __init__(self, head=None):
        self.head = head

    def search(self, data):
        i = self.head
        while i is not None and i.data != data:
            i = i.next
        return i

    def insert(self, r, c):
        new_node = self.Node(r, c)
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


def print_maze(maze):
    # print column numbers
    print("   | 0  1  2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17 18 19")
    print("----------------------------------------------------------------")
    for line_number, line in enumerate(maze):
        # print row numbers
        print("{0:<2} |".format(line_number), end=' ')
        # print maze contents in a grid
        for char in line:
            print(char, end='  ')  # print maze contents in a grid
        print()


def maze_solver(r, c):
    # If we've reached the exit,
    if maze[r][c] == "E":
        return True
    # If we start on an invalid space (a 1),
    if maze[r][c] == 1:
        print("Invalid starting point! Must start on a 0")
        return False
    # Mark every space we visit with an X so we don't visit spaces twice
    maze[r][c] = "X"

    # Move in a direction of descending priority: Up, Left, Right, Down

    # Go Up
    if r - 1 >= 0 and maze[r - 1][c] != 1 and maze[r - 1][c] != "X" and maze[r - 1][c] != "S":
        if maze_solver(r - 1, c):
            path.insert(r, c)
            return True
        # else, up is a dead end
    # Go Left
    if c - 1 >= 0 and maze[r][c - 1] != 1 and maze[r][c - 1] != "X" and maze[r][c - 1] != "S":
        if maze_solver(r, c - 1):
            path.insert(r, c)
            return True
        # else, left is a dead end
    # Go Right
    if c + 1 < 20 and maze[r][c + 1] != 1 and maze[r][c + 1] != "X" and maze[r][c + 1] != "S":
        if maze_solver(r, c + 1):
            path.insert(r, c)
            return True
        # else, right is a dead end
    # Go Down
    if r + 1 < 20 and maze[r + 1][c] != 1 and maze[r + 1][c] != "X" and maze[r + 1][c] != "S":
        if maze_solver(r + 1, c):
            path.insert(r, c)
            return True
        # else, down is a dead end

    # If every space leads to a dead end,
    return False


def highlight_path(maze, path):
    path_iter = path.head
    # +s represent the path we take to reach the exit
    while path_iter is not None:
        maze[path_iter.r][path_iter.c] = "+"
        path_iter = path_iter.next


# Open the maze file, split it into lines, split lines into ints, set the exit point

f = open("maze.txt")
maze = f.read().split()  # each line in the file becomes a list

# Each String list becomes a list of ints for easy reference and comparison
maze = [[int(char) for char in line] for line in maze]

# Place our exit point
# (E changed to 0 in file for easier conversion to ints)
# You could also create any maze, then place the exit point wherever you want
maze[0][0] = "E"

print_maze(maze)
print()

# Get starting point from user
print("----- Starting point -----")
r = -1
while r < 0 or r > 19:
    r = int(input("Row    [min:0, max:19]: "))
c = -1
while c < 0 or c > 19:
    c = int(input("Column [min:0, max:19]: "))
print()

# Create single linked list that keeps track of our successful path
path = SingleLinkedList()
path.insert(r, c)

if maze_solver(r, c):
    print("I'm free!\n")
    highlight_path(maze, path)
else:
    print("Help! I'm trapped!\n")

# Mark where we started with an S, then print the completed maze
maze[r][c] = "S"
print_maze(maze)
