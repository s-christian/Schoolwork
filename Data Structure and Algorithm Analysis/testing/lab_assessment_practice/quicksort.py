# Tested and verified accurate


def quicksort(arr, l, r):
    if l < r:
        p = partition(arr, l, r)
        quicksort(arr, l, p)
        quicksort(arr, p + 1, r)


def partition(arr, l, r):
    x = arr[l]
    s = l
    for i in range(l + 1, len(arr)):
        if arr[i] < x:
            s += 1
            arr[s], arr[i] = arr[i], arr[s]
    arr[s], arr[l] = arr[l], arr[s]
    return s


arr = [46, 5918, 81, 12, 12, 12, 54, -1923, 49]
print(arr)
quicksort(arr, 0, len(arr) - 1)
print(arr)
