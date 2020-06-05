class CircularQueue:
    def __init__(self, max_size=100):
        self.max_size = max_size
        self.front = self.back = self.size = 0
        self.q = [None for i in range(max_size)]

    def enqueue(self, x):
        if self.size >= self.max_size:
            print("Queue already full!")
            return -1
        self.q[self.back] = x
        self.back = (self.back + 1) % self.max_size
        self.size += 1

    def dequeue(self):
        if self.size <= 0:
            print("Queue already empty!")
            return -1
        self.front = (self.front + 1) % self.max_size
        self.size -= 1

    def search(self, x):
        if self.size <= 0:
            return False
        n = self.front + 1
        if self.q[self.front] == x:
            return True
        while n != self.back:
            if self.q[n] == x:
                return True
            n = (n + 1) % self.max_size
        return False

    def clear(self):
        self.front = 0
        self.back = 0
        self.size = 0

    def q_print(self):
        print("FRONT:", self.front)
        print("BACK :", self.back)
        if self.size <= 0:
            print("Queue is empty!")
            return -1
        n = self.front + 1
        print(self.q[self.front], end=" ")
        while n != self.back:
            print(self.q[n], end=" ")
            n = (n + 1) % self.max_size
        print()


test_queue = CircularQueue()
print(test_queue.size)
test_queue.enqueue(10)
test_queue.enqueue("Hello!")
test_queue.q_print()
print("10 found? :", test_queue.search(10))
print("'Goodbye!' found? :", test_queue.search("Goodbye!"))
test_queue.dequeue()
print(test_queue.size)
test_queue.enqueue("Goodbye!")
test_queue.q_print()
print("'Goodbye!' found? :", test_queue.search("Goodbye!"))
print(test_queue.size)
print()

test_queue.clear()
print(test_queue.size)
test_queue.q_print()
print()

for i in range(0, 100):
    test_queue.enqueue(i)
print(test_queue.size)
test_queue.q_print()
print("40 found? :", test_queue.search(40))
print()

test_queue.enqueue(200)
print()

for i in range(0, 50):
    test_queue.dequeue()
print(test_queue.size)
test_queue.q_print()
print("40 found? :", test_queue.search(40))
test_queue.q_print()
print()

for i in range(0, 50):
    test_queue.enqueue(i)
print(test_queue.size)
test_queue.q_print()
print("40 found? :", test_queue.search(40))
print()

test_queue.dequeue()
test_queue.q_print()
