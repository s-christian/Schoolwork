def factorial(n):
    if n < 2:
        return 1
    return n * factorial(n - 1)


def fac_non_rec(n):
    if n < 2:
        return 1
    sum = 1
    while n > 1:
        sum = n * sum
        n -= 1
    return sum


print(factorial(10))
print(fac_non_rec(10))
