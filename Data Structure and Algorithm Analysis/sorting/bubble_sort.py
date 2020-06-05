def bubble_sort(l):
    i = 0
    while i < len(l) - 1:
        j = 0
        while j < len(l) - 1 - i:
            if l[j + 1] < l[j]:
                temp = l[j]
                l[j] = l[j + 1]
                l[j + 1] = temp
            j += 1
        i += 1


random_list = [15, 3, 11, 19, 4, 7]
print(random_list)
print(len(random_list))
bubble_sort(random_list)

