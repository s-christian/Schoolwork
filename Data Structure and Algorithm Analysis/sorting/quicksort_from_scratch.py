def quicksort(arr, l, r):
    if l < r:
        check_index = partition(arr, l, r)
        quicksort(arr, l, check_index)
        quicksort(arr, check_index + 1, r)

def partition(arr, l, r):
    pivot_point = l
    check_index = pivot_point + 1
    for i in range(check_index, r):
        if arr[i] < arr[pivot_point]:
            arr[i], arr[check_index] = arr[check_index], arr[i]
            check_index += 1
    check_index -= 1
    arr[pivot_point], arr[check_index] = arr[check_index], arr[pivot_point]
    return check_index


# a = [9, 8, 7, 3, 90, 17, 58, 43, 42, 42, 42, 47, 43, 100, 1, 0]
a = [5, 4, 1, 2]
print("Unsorted list:", a)
quicksort(a, 0, len(a))
print("Sorted list:  ", a)
