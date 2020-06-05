def mod_multiplicative_inverse(a):
    for x in range(0, 26):
        if (a * x) % 26 == 1:
            return x
    print("mod_multiplicative_inverse ERROR!")
    return -1


def decrypt(ciphertext):  # mod_multiplicative_inverse(a) * (ord_value - b) (mod 26)
    ord_values = [ord(x) - ord('A') for x in ciphertext]
    alpha_values = [1, 3, 5, 7, 9, 11, 15, 17, 19, 21, 23, 25]
    for b in range(0, 26):
        for a in alpha_values:
            plaintext = [(mod_multiplicative_inverse(a) * (x - b)) % 26 for x in ord_values]
            print(''.join(chr(x + ord('a')) for x in plaintext), "- a=%2d, b=%d" % (a, b))


ciphertext = input("Ciphertext: ")
decrypt(ciphertext)  # alpha should be 21, and beta should be 10 for our example
