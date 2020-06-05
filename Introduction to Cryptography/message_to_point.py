# Code partially copied from Dr. O'Leary during class
# y^2 = x^3 + 2x + 1 (mod 905507)
import sys

def g(x, p):
    return (x**3 + 2 * x + 1) % p

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


p = 905507
print("Prime p = {}".format(p))
if (p % 4 == 3):
    print("{} % 4 == 3, we can continue\n".format(p))
else:
    print("{} % 4 != 3, this will not work with our implementation".format(p))
    sys.exit(0)

K = 20
print("K = {}".format(K))
print("Probability of message encoding failure is ~ 1 in {:,}\n".format(2**20))

m = 41723
print("Message = {}\n".format(m))
if m * K > p:
    print("Message too long")
    sys.exit(0)

j = 0
while j < K:
    x = m * K + j
    y = fastpow(g(x, p), (p + 1) // 4, p)
    print("x={}\t g(x)={}\t y={}\t y*y(mod p)={}".format(x, g(x, p), y, (y * y) % p))
    if (y * y) % p == g(x, p):
        print("\nPoint found! --> ({}, {})".format(x, y))
        sys.exit(0)
    else:
        j += 1
print("No point found! Unlucky!")
