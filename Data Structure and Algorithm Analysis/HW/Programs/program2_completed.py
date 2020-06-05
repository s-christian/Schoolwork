# ==============================================================
#     Program 2 – Sorting Program
# ==============================================================

import random
import time
import sys

# increase recursion limit to prevent error with 10^6 inputs
sys.setrecursionlimit(5000)


def bubble_sort(a):
    s = len(a)
    # each round "sinks" the largest element to the right
    # not necessary to check the largest element every round,
    # so the number of checked elements reduces by 1 each round
    for i in range(1, s):
        for j in range(0, s - i):
            if a[j + 1] < a[j]:
                temp = a[j]
                a[j] = a[j + 1]
                a[j + 1] = temp


def insertion_sort(a):
    for i in range(1, len(a)):
        x = a[i]
        # slide elements down to make room for a[i]
        j = i
        while j > 0 and a[j - 1] > x:
            a[j] = a[j - 1]
            j -= 1
        a[j] = x


def selection_sort(a):
    # finds the smallest element in the array and shoves it to the left
    # after the first iteration, the smallest element becomes the leftmost element, etc.
    for i in range(0, len(a)):
        smallest_index = i
        for j in range(i + 1, len(a)):
            if a[j] < a[smallest_index]:
                smallest_index = j
        a[i], a[smallest_index] = a[smallest_index], a[i]


def merge_sort(a):
    if len(a) > 1:
        # split the array into 2 halves
        m = len(a) // 2
        left = a[:m]
        right = a[m:]

        # sort left and right halves until you get down to 2-element subarrays
        merge_sort(left)
        merge_sort(right)

        l = r = index = 0
        # sort
        while l < len(left) and r < len(right):
            if left[l] < right[r]:
                a[index] = left[l]
                l += 1
            else:
                a[index] = right[r]
                r += 1
            index += 1

        # add any leftover elements
        while l < len(left):
            a[index] = left[l]
            l += 1
            index += 1
        while r < len(right):
            a[index] = right[r]
            r += 1
            index += 1


def quick_sort(a, l, r):
    if l < r:
        # go through a round of sorting, then sort subarrays built aroud p
        p = provision(a, l, r)
        quick_sort(a, l, p)
        quick_sort(a, p + 1, r)


def provision(a, l, r):
    x = a[l]
    s = l
    for i in range(l + 1, r):
        # if element is less than the pivot point
        if a[i] < x:
            s += 1
            # swap that element with the swap point, which starts at pivot + 1
            a[s], a[i] = a[i], a[s]
    # swap the pivot point with the final swap point
    a[l], a[s] = a[s], a[l]
    return s


rand_max = int(input("Range max  : "))
input_size = int(input("Input size : "))

# fill the lists with random numbers
a1 = []
a2 = []
a3 = []
a4 = []
a5 = []
for i in range(0, input_size):
    x = random.randint(1, rand_max)
    a1.append(x)
    a2.append(x)
    a3.append(x)
    a4.append(x)
    a5.append(x)

print("--- Original List ---")
print(a1)

print()

print("... starting bubble sort")
tic = time.perf_counter()
bubble_sort(a1)
toc = time.perf_counter()
bubble_time = toc - tic
print("[!] Bubble sort finished")

print()

print("... starting insertion sort")
tic = time.perf_counter()
insertion_sort(a2)
toc = time.perf_counter()
insertion_time = toc - tic
print("[!] Insertion sort finished")

print()

print("... starting selection sort")
tic = time.perf_counter()
selection_sort(a3)
toc = time.perf_counter()
selection_time = toc - tic
print("[!] Selection sort finished")

print()

print("... starting merge sort")
tic = time.perf_counter()
merge_sort(a4)
toc = time.perf_counter()
merge_time = toc - tic
print("[!] Merge sort finished")

print()

print("... starting quick sort")
tic = time.perf_counter()
quick_sort(a5, 0, len(a5))
toc = time.perf_counter()
quick_time = toc - tic
print("[!] Quick sort finished")

print()

print("[=] Do all the sorting algorithms result in the same sorted list? -",
      a1 == a2 == a3 == a4 == a5)

print()

print("Input size  =", input_size)
print("Input range = (1, %d)" % rand_max)
print("[+] Bubble Sort elapsed time    :", bubble_time)
print("[+] Insertion Sort elapsed time :", insertion_time)
print("[+] Selection Sort elapsed time :", selection_time)
print("[+] Merge Sort elapsed time     :", merge_time)
print("[+] Quick Sort elapsed time     :", quick_time)
