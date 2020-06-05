import random
import time

def bubble_sort(a):
    for i in range(1, len(a)):
        for j in range(0, len(a) - i):
            if a[j] > a[j + 1]:
                a[j], a[j + 1] = a[j + 1], a[j]



a = []
for i in range(0, 1000):
    a.append(random.randint(1, 1000))

print("Original list :", a)

tic = time.perf_counter()
bubble_sort(a)
toc = time.perf_counter()

print("Sorted list   :", a)

print("Time elapsed  :", toc - tic)
