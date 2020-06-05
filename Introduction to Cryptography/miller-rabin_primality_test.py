# Code largely copied from Dr. O'Leary during class

import random

def fastpower(base, exponent, n):
    # base^exponent (mod n)
    ans = 1
    while exponent > 0:
        if exponent % 2 == 0:
            exponent /= 2
            base = (base * base) % n
        else:
            exponent -= 1
            ans = (ans * base) % n
    return ans

def factortwos(n):
    if n % 2 == 1:
        return (0, n)
    else:
        starting_n = n
        count = 0
        while n % 2 == 0:
            n //= 2
            count += 1
        return (count, starting_n // 2**count)

def millerrabin(n, a):
    (k, m) = factortwos(n - 1)

    print("n =", n)
    print("k =", k)
    print("m =", m)
    print("a =", a)


    b = fastpower(a, m, n)
    print("b_0 = a^m (mod n)     =", b)

    if b == 1 or b == (n - 1):
        return "probably prime"

    for i in range(0, k - 1):
        b = fastpower(b, 2, n)
        print("b_{} = (b_{})^2 (mod n) = {}".format(i + 1, i, b))
        if b == (n - 1):
            return "probably prime"
        if b == 1:
            return "composite"

    if b == -1:
        return "probably prime"
    else:
        return "composite"


n = int(input("n = "))
print()
print("\nn = {} is {}".format(n, millerrabin(n, random.randint(2, n - 1))))
