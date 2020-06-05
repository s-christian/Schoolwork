def selection_sort(a):
    for i in range(0, len(a)):
        # find index of smallest element
        min_index = i
        for j in range(i + 1, len(a)):
            if a[j] < a[min_index]:
                min_index = j
        
        # swap smallest element with a[i]
        temp = a[i]
        a[i] = a[min_index]
        a[min_index] = temp

random_list = [2, 15, 8, 1, 17, 10, 12, 5]
print("Before sort:\n", random_list, sep='')
selection_sort(random_list)
print("After sort:\n", random_list, sep='')
