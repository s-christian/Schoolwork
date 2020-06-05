# Code mainly copied from Dr. O'Leary during class
def gcd(a, b):
    while b:
        q = (a // b)
        r = (a % b)
        print("{0:10} = {1:>3} * {2:<8} + {3:<8}".format(a, q, b, r))
        a, b = b, a % b
    return a


a = int(input("a = "))
b = int(input("b = "))
print("gcd({}, {}) = {}".format(a, b, gcd(a, b)))
