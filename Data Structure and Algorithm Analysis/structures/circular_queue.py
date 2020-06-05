class CircularQueue:
    # can't seem to make this circular for some reason,
    # search never works properly when circling back
    def __init__(self, max_size=100):
        self.max_size = max_size
        self.front = 0
        self.back = -1
        self.size = 0
        self.q = ['' for _ in range(0, self.max_size)]

    def enqueue(self, x):
        if self.size >= self.max_size:
            print("Queue already full!")
            return -1
        self.back = self.back + 1
        if self.back == self.max_size:
            self.back = 0
        self.q[self.back] = x
        self.size = self.size + 1

    def dequeue(self):
        if self.size <= 0:
            print("Queue already empty!")
            return -1
        self.front = self.front + 1
        if self.front == self.max_size:
            self.front = 0
        self.size = self.size - 1

    def search(self, x):
        print("FRONT : ", self.front)
        print("BACK  : ", self.back)
        if self.size <= 0:
            return False
        m = self.front - 1
        while m != self.back:
            print("At", self.q[m + 1])
            if self.q[m] == x:
                return True
            m = (m + 1) % self.max_size
        return False

    def clear(self):
        self.front = 0
        self.back = -1
        self.size = 0

    def q_print(self):
        if self.size <= 0:
            print("List empty.")
            return -1
        if self.front > self.back:
            temp_q = [self.q[i] for i in range(self.front, self.max_size)]
            temp_q += [self.q[i] for i in range(0, self.front)]
        else:
            temp_q = [self.q[i] for i in range(self.front, self.back + 1)]
        print(temp_q)


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
