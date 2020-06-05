# This is the most popular linear sorting algorithm, supposedly.
# Think of it as scooting the lowest element down to the left.
def insertion_sort(a):
    for i in range(1, len(a)):
        temp = a[i]
        # Slide elements down to make room for a[i]
        j = i
        while (j > 0 and a[j - 1] > temp):
            a[j] = a[j - 1]
            j -= 1
        a[j] = temp


random_list = [2, 15, 8, 1, 17, 10, 12, 5]
print("Before sort:\n", random_list, sep='')
insertion_sort(random_list)
print("After sort:\n", random_list, sep='')
