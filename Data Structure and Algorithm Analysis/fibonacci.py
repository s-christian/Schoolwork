def fib(n):
    if n < 0:
        return -1
    if n == 0 or n == 1:
        return n
    return fib(n - 1) + fib(n - 2)


def print_fib(n):
    i = 0
    while i <= n:
        print(fib(i), '', end='')
        i += 1


num = int(input("Print this many fibonacci numbers : "))
print_fib(num)
