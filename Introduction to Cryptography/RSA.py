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


def encrypt(m, e, n):
    return modular_exponentiation(m, e, n)


def decrypt(c, d, n):
    return modular_exponentiation(c, d, n)


def extended_euclid(a, b):
    r = []
    q = []
    x = [0, 1]
    y = [1, 0]
    while(b > 0):
        q.append(a // b)
        r.append(a % b)
        x.append(x[-2] - q[-1] * x[-1])
        y.append(y[-2] - q[-1] * y[-1])
        a, b = b, a % b
    return y[-2]


p = 5336500541
q = 11037273967
n = p * q
e = 65537

d = extended_euclid(e, (p - 1) * (q - 1))
print("e * d = 1 (mod (p-1)(q-1))")
print("{0} * {1} = {2} (mod (p-1)(q-1))".format(e, d, (e * d) % ((p-1) * (q-1))))

message = 12122019
ciphertext = 19251455775916764152

encrypted = encrypt(message, e, n)
decrypted = decrypt(encrypted, d, n)
plaintext = decrypt(ciphertext, d, n)

print("n =", n)
print("Encrypted message:         ", encrypted)
print("Decrypted original message:", decrypted)
print("Decrypted ciphertext:      ", plaintext)
