def selection_sort(a):
    for i in range(0, len(a)):
        min_index = i
        for j in range(i + 1, len(a)):
            if a[j] < a[min_index]:
                min_index = j
        a[i], a[min_index] = a[min_index], a[i]


a = [1, 5, 10, 15, 10, 5, 1, 3, 2, 4, 3, 3, 0, 5, 1]
print(a)
selection_sort(a)
print(a)
