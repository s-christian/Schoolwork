def binary_search(a, x):
    m = len(a) // 2
    if len(a) == 0:
        return False
    elif a[m] == x:
        return True
    elif a[m] > x:
        return binary_search(a[:m], x)
    elif a[m] < x:
        return binary_search(a[m + 1:], x)


arr = [-47, 1, 2, 3, 4, 8, 8, 10, 18, 847, 1874]
print(binary_search(arr, -47))
print(binary_search(arr, 1))
print(binary_search(arr, 18))
print(binary_search(arr, 2))
print(binary_search(arr, 999))
print(binary_search(arr, 1234))
