def quicksort(arr, l, r):  # for this implementation, r is the length of the array, not the rightmost element
    if l < r:
        check_index = partition(arr, l, r)
        quicksort(arr, l, check_index)  # subarray to the left of index
        quicksort(arr, check_index + 1, r)  # subarray to the right of index


def partition(arr, l, r):
    pivot_index = l  # pivot is set to the leftmost element
    check_index = pivot_index + 1
    for i in range(check_index, r):
        if arr[i] < arr[pivot_index]:
            arr[i], arr[check_index] = arr[check_index], arr[i]
            check_index += 1
    # make the final swap, swapping the left point and the right point 
    check_index -= 1
    arr[pivot_index], arr[check_index] = arr[check_index], arr[pivot_index]
    return check_index  # this point is a "pillar" that doesn't move,
                        # this is the point to build subarrays around


arr = [33, 35, 50, 4, 26, 25, 49, 26, 18, 3, 17, 23]
print("Original list:", arr)
quicksort(arr, 0, len(arr))
print("Sorted list:  ", arr)
