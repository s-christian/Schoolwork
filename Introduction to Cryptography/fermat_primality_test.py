import random


def modular_exponentiation(base, exponent, n):
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


def fermat_primality_test(n):
    if n < 2:
        print("n must be at least 2")
    elif n % 2 == 0:
        print(n, "is composite")
    elif n == 3:
        print(n, "is prime")
    else:
        a = random.randint(2, n - 2)
        print("a =", a)
        if modular_exponentiation(a, n - 1, n) != 1:
            print(n, "is composite")
        else:
            print(n, "is probably prime")


fermat_primality_test(5341497503)
print()
fermat_primality_test(644604977)
