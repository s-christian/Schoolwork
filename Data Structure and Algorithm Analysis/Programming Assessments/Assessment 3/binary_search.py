def binary_search(a, x, l, r):
    if r - l == 0:
        print(x, "not found in this array")
        return False
    else:
        m = ((r - l) // 2) + l
        if a[m] == x:
            print(x, "found at index", m)
            return True
        elif a[m] > x:
            return binary_search(a, x, l, m)
        else:
            return binary_search(a, x, m + 1, r)


arr = [-9, -5, -3, -2, 0, 3, 4, 6, 7, 8]
print("List:", arr)
elem = int(input("Element to search for in list: "))
binary_search(arr, elem, 0, len(arr))
