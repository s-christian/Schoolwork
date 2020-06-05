def phi_solver(x, primes):
    mult = []
    for p in primes:
        if x % p == 0:  # if a prime divides x, add it to our list
            mult.append(1 / p)
    if len(mult) == 0:  # if there is nothing to multiply by, phi(x) = 0
        return 0
    else:
        sum = x
        for m in mult:  # keep the running total using our mult list we created
            sum = sum * (1 - m)  # Euler's Totient Function algorithm
        return sum


num = int(input("num = "))
# Build a list of all primes less than num
# Implementation of Sieve of Eratosthenes taken from:
# https://stackoverflow.com/questions/3939660/sieve-of-eratosthenes-finding-primes-python
a = [False] * 2 + [True] * (num - 2)
primes = []  # let this be our list of primes
for i, isprime in enumerate(a):
    if isprime:
        primes.append(i)  # add the prime to our list of primes
        for j in range(i * i, num, i):
            a[j] = False

phi = phi_solver(num, primes)
print(phi)
