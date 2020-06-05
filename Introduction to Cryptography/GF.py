# This code is for arithmetic in the Galois field GF(2^8)
#
# In this instance
#   GF(2^8) = Z_2 / (X^8 + X^4 + X^3 + X + 1)
#
# Elements of GF(2^8) are 8-bit integers.
#   The binary expanasion       a_0 + 2 a_1   + 4 a_2     + 8 a_3     + ... + 128 a_7
#   is mapped to the polynomial a_0 +   a_1 X +   a_2 X^2 +   a_3 X^3 + ... +     a_7 X^7
#
# Note that X^8  = X^4 + X^3 + X   + 1
#           X^9  = X^5 + X^4 + X^2 + X
#

def to_polynomial(x, n=8):
    return x

def add(x, y):
    assert(isinstance(x, int))
    assert(isinstance(y, int))
    assert(x>=0)
    assert(x<=255)
    assert(y>=0)
    assert(y<=255)
    # ... other stuff

def multiply(x, n=8):
    # idk if the parameters are correct

    result = 0

    # Expand x in binary coefficients
    a = [(x & 2**i) >> i for i in range(0, 8)]

    # Multiply in Z_2[X]
    for i in range(0, 8):
        if (a[i] == 1):
            result = result ^ (y << i)

    # This result is in Z_2[X] and can be up to degree 14.
    # Perform reduction mod (X^8 + X^4 + X^3 + X + 1)
    for i in range(14, 7, -1):
        if (result & (2**i) != 0):
            # Here m = (X^8 + X^4 + X^3 + X + 1) * X^(i-8)
            m = 2**i + 2**(i - 4) + 2**(i - 5) + 2**(i - 7) + 2**(i - 8)
            result = result ^ m

    return result

def power(a, n):
    assert(something)

# ...more
