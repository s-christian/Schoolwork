# Tested and verified accurate


def binary_search(x, arr, l, r):
    if r - l > -1:
        m = (r + l) // 2
        if arr[m] == x:
            return True, m
        elif arr[m] > x:
            return binary_search(x, arr, l, m - 1)
        else:
            return binary_search(x, arr, m + 1, r)
    return False, -1


arr = [1, 3, 5, 6, 8, 28]  #, 29, 29, 29, 37, 1048, 1111]
print(binary_search(50, arr, 0, len(arr) - 1))
print(binary_search(1, arr, 0, len(arr) - 1))
print(binary_search(28, arr, 0, len(arr) - 1))
print(binary_search(5, arr, 0, len(arr) - 1))
