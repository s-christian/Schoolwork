# Tested and verified accurate


def heapify(arr, n, i):  # max heap
    left = (i * 2) + 1
    right = (i * 2) + 2
    largest = i
    if left < n and arr[left] > arr[i]:
        largest = left
    if right < n and arr[right] > arr[largest]:
        largest = right
    if largest != i:
        arr[i], arr[largest] = arr[largest], arr[i]
        heapify(arr, n, largest)  # percolate down


def buildHeap(arr):  # max heap
    n = len(arr)
    for i in range(n // 2 - 1, -1, -1):  # from the midpoint down to index 0
        heapify(arr, n, i)


def heapSort(arr):  # max heap
    n = len(arr)
    for i in range(n - 1, 0, -1):
        arr[0], arr[i] = arr[i], arr[0]
        heapify(arr, i, 0)


arr = [2, 7, 1, -2, 56, 5, 3]
print(arr)
buildHeap(arr)
print(arr)
heapSort(arr)
print(arr)
