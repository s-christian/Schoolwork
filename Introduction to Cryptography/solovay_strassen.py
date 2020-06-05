# Code largely copied from Dr. O'Leary during class

import sympy
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

def solovaystrassen(n):
    if (n % 2) == 0:
        return "error; this only applies to odd numbers"

    for i in range(0, 10):  # run it 10 times just to be sure
        a = random.randint(2, n - 2)
        v = fastpower(a, (n - 1) / 2, n)
        j = sympy.ntheory.jacobi_symbol(a, n)

        print("Round {}:".format(i + 1))
        print("a =", a)
        print("v =", v)
        print("j =", j)
        print("n =", n)
        print("j =", j)
        print()

        if v != j % n:
            return "composite"

    return "probably prime"


# n = sympy.ntheory.generate.prime(21120188)
n = int(input("n = "))
print()
print(n, "is", solovaystrassen(n))
