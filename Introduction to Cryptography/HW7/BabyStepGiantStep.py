# BSGS taken from GeeksForGeeks
# https://www.geeksforgeeks.org/discrete-logarithm-find-integer-k-ak-congruent-modulo-b/
import math

def fastpow(base, exponent, n):
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

def bsgs(b, a, p):
    n = int(math.sqrt(p) + 1)

    value = [0] * p

    # Store all values of a^(n*i) of LHS
    for i in range(n, 0, -1):
        value[fastpow(a, i * n, p)] = i

    for j in range(n):

        # Calculate (a ^ j) * b and check
        # for collision
        cur = (fastpow(a, j, p) * b) % p

        # If collision occurs i.e., LHS = RHS
        if (value[cur]):
            ans = value[cur] * n - j

            # Check whether ans lies below m or not
            if (ans < p):
                return ans

    return -1


# L499(15123) for p = 48611  =>  15123 === 499^x (mod 48611)
b = 15123
a = 499
p = 48611
print(b, "=", a, "^ x ( mod", p, ")")
x = bsgs(b, a, p)
print("x =", x)
print("a^x =", fastpow(a, x, p), "(mod p)")
