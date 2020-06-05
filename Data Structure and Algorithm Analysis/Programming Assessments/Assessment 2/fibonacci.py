# Programming Assessment 2 - Problem C1
def fibonacci_sequence(n):
    if n == 1:
        print([0])
    else:
        fib = [0, 1]
        for i in range(2, n):
            fib.append(fib[i-2] + fib[i-1])
        print(fib)


n = -1
while n < 1:
    n = int(
        input("Print the fibonacci sequence up to the n'th number (where n > 0)\nn = "))
fibonacci_sequence(n)
