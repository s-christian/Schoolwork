def max_contiguous_sum(a):
    max = 0
    current = 0
    for i in range(0, len(a)):
        current += a[i]
        if current > max:
            max = current
        elif current < 0:
            current = 0
    return max


arr = [4, -6, -1, 5, 6, 0, 10, -8, -10, 12, 1, -2, 0]
print(max_contiguous_sum(arr))
