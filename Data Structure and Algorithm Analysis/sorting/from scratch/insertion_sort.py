def insertion_sort(a):
    for i in range(1, len(a)):
        j = i
        while j > 0 and a[j] < a[j - 1]:
            a[j], a[j - 1] = a[j - 1], a[j]
            j -= 1


a = [1, 5, 10, 15, 10, 5, 1, 3, 2, 4, 3, 3, 0, 5, 1]
print(a)
insertion_sort(a)
print(a)
