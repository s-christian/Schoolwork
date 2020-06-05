def mergesort(arr):
    if len(arr) > 1:
        mid = len(arr) // 2
        left = arr[:mid]
        right = arr[mid:]

        mergesort(left)
        mergesort(right)

        l = r = index = 0
        while l < len(left) and r < len(right):
            if left[l] < right[r]:
                arr[index] = left[l]
                l += 1
            else:
                arr[index] = right[r]
                r += 1
            index += 1

        while l < len(left):
            arr[index] = left[l]
            l += 1
            index += 1
        while r < len(right):
            arr[index] = right[r]
            r += 1
            index += 1


a = [5, 9, 2, 3, 59, 98, 23, 24, 26, 25, 1, 0]
print("Original array:", a)
mergesort(a)
print("Sorted array  :", a)