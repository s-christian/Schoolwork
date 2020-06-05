def quicksort(a, l, r):
    if l < r:
        q = partition(a, l, r)
        quicksort(a, l, q-1)
        quicksort(a, q+1, r)

# rearranges the subarray in place,results in two subarrays
# where all values in first subarray <= all values in second.
# returns the index of the "pivot" element separating the two subarrays.
def partition(a, l, r):
    x = a[l]
    q = l
    for i in range(1, r):
        if a[i] < x:
            q += 1
            temp = a[q]
            a[q] = a[i]
            a[i] = temp
    temp = a[l]
    a[l] = a[q]
    a[q] = temp
    return q


array = [5, 3, 2, 6, 4, 1, 3, 7]
print(array)
quicksort(array, 0, len(array))
print(array)