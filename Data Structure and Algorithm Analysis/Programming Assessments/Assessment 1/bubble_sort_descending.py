# Programming Assessment 1, Problem 1
def bubble_sort_descending(a):
    for i in range(0, len(a) - 1):
        for j in range(0, len(a) - 1 - i):
            if a[j + 1] > a[j]:
                temp = a[j]
                a[j] = a[j + 1]
                a[j + 1] = temp


a = [92, 8, 5, 28, 36, 41, 12, 10, 3, 101]
print("Unsorted:", a)
bubble_sort_descending(a)
print("Sorted:  ", a)
