def quick_sort(a, l, r):
    if l < r:
        p = partition(a, l, r)
        quick_sort(a, l, p)
        quick_sort(a, p + 1, r)

# All values smaller than the starting position, l, are put
# before l, so that everything before l is smaller and
# everything after l is larger.
# This effectively puts a number in its "absolute correct position"
# every round until all numbers are placed in such a manner.
def partition(a, l, r):
    x = a[l]
    swap = l
    for i in range(l + 1, r):
        if a[i] < x:
            swap += 1
            a[swap], a[i] = a[i], a[swap]
    a[l], a[swap] = a[swap], a[l]
    return swap


a = [1, 5, 10, 15, 10, 5, 1, 3, 2, 4, 3, 3, 0, 5, 1]
print(a)
quick_sort(a, 0, len(a))
print(a)
