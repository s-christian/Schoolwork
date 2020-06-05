def merge_sort(a):
    if len(a) > 1:
        m = len(a) // 2
        left = a[:m]
        right = a[m:]

        merge_sort(left)
        merge_sort(right)

        l = r = index = 0

        while l < len(left) and r < len(right):
            if left[l] < right[r]:
                a[index] = left[l]
                l += 1
            else:
                a[index] = right[r]
                r += 1
            index += 1

        while l < len(left):
            a[index] = left[l]
            l += 1
            index += 1
        while r < len(right):
            a[index] = right[r]
            r += 1
            index += 1


a = [1, 5, 10, 15, 10, 5, 1, 3, 2, 4, 3, 3, 0, 5, 1]
print(a)
merge_sort(a)
print(a)
