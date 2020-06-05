def quicksort(a, l, r):
    if l < r:
        p = provision(a, l, r)
        quicksort(a, l, p)
        quicksort(a, p + 1, r)


def provision(a, l, r):
    x = a[l]
    s = l
    for i in range(l + 1, r):
        if a[i] < x:
            s += 1
            a[s], a[i] = a[i], a[s]
    a[l], a[s] = a[s], a[l]
    return s


arr = [-5, 3, 4, -9, 8, -2, 0, 6, -3, 7]
print(arr)
quicksort(arr, 0, len(arr))
print(arr)
