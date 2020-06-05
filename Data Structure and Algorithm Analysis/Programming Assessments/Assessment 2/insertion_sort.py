# Programming Assessment 2 - Problem A1/A2
#
# I forget whether this is Insertion or Selection Sort, so I ask
# the user for the n'th smallest element regardless
def insertion_sort(a):
    for i in range(0, len(a) - 1):
        min = a[i]
        minIndex = i
        for j in range(i + 1, len(a)):
            if a[j] < min:
                min = a[j]
                minIndex = j
        temp = a[i]
        a[i] = min
        a[minIndex] = temp


nums = [5, 9, 20, 683, 182, 59, 31, 261, 59, 69,
        184, 14, 47, 18, 88, 17, 597, 8272, 123, 271]
print("Before Sorting :", nums)
insertion_sort(nums)
print("After Sorting  :", nums)
n = -1
while n > 20 or n < 1:
    n = int(input("Find the n'th smallest element.\nn = "))
print(
    "The n'th (", n, ") smallest element is nums[", n-1, "] = ", nums[n-1], sep='')
