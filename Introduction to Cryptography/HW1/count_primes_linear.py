# from math import sqrt, gcd
# from itertools import count, islice
"""
def is_prime(num):
    # return num > 1 and all(num % i for i in islice(count(2), int(sqrt(num) - 1)))
    return num > 1 and all(num % i for i in range(2, int(sqrt(num) - 1)))


def count_primes(x):
    total = 0
    for i in range(2, x):  # non-inclusive (not testing x for primality)
        if is_prime(i):
            total += 1
    return total
"""

# Implementation of Sieve of Eratosthenes taken from:
# https://stackoverflow.com/questions/3939660/sieve-of-eratosthenes-finding-primes-python

n = int(input("Count primes up until this number (non-inclusive) : "))
a = [False] * 2 + [True] * (n - 2)
a[0] = a[1] = False
for i, isprime in enumerate(a):
    if isprime:
        for j in range(i * i, n, i):
            a[j] = False

sum = 0
for val in a:
    if val is True:
        sum += 1

print("Number of primes before %d = %d" % (n, sum))
