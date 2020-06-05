def quicksort(a, l, r):
    if l < r:
        p = partition(a, l, r)
        quicksort(a, l, p)
        quicksort(a, p + 1, r)

def partition(a, l, r):
    x = a[l]
    s = l
    for i in range(l + 1, r):
        if a[i] < x:
            s += 1
            a[s], a[i] = a[i], a[s]
    a[l], a[s] = a[s], a[l]
    return s


arr = [1, 8, -47, 10, 8, 4, 3, 2, 847, 1874, 18]
print(arr)
quicksort(arr, 0, len(arr))
print(arr)
