from math import gcd
import re


def encrypt(plaintext, a, b):
    # regex taken from StackOverflow
    # remove all non-alphabetic characters
    plaintext = re.sub("[^a-zA-Z]+", '', plaintext).lower()
    ord_values = [ord(x) - ord('a') for x in plaintext]
    shifted_chars = [chr((a * x + b) % 26 + ord('A')) for x in ord_values]
    ciphertext = ''.join(shifted_chars)
    return ciphertext


while True:
    alpha = int(input("Alpha value: "))
    if gcd(alpha, 26) == 1:
        break
    else:
        print("GCD of Alpha and 26 must be 1")

beta = int(input("Beta value: "))
plaintext = input("Text to encrypt: ")
ciphertext = encrypt(plaintext, alpha, beta)
print("Ciphertext:", ciphertext)
