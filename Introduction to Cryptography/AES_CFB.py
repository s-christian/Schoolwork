# Assisted by Stack Overflow at:
# https://stackoverflow.com/questions/25261647/python-aes-encryption-without-extra-module

from cryptography.hazmat.primitives.ciphers import Cipher, algorithms, modes
from cryptography.hazmat.backends import default_backend


def encrypt(data):
    return encryptor.update(data) + encryptor.finalize()


def decrypt(data):
    return decryptor.update(data) + decryptor.finalize()


key = bytes.fromhex("EC58DFA74641AF52AD0D16E77D576623")
iv = bytes.fromhex("AFD12B66F89D1FC2FBB2AC7C56878DF8")
message = "Thanksgiving is soon!".encode("utf-8")

backend = default_backend()
cipher = Cipher(algorithms.AES(key), modes.CFB(iv), backend=backend)
encryptor = cipher.encryptor()
decryptor = cipher.decryptor()

encrypted = encrypt(message)
print(encrypted.hex().upper())

ciphertext = bytes.fromhex(
    "03899b518753b7552858e6d37a4a830104723d6ecc443b0496686d60")
print(decrypt(ciphertext))
