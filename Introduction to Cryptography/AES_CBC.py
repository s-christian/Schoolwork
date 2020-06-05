# Assisted by Stack Overflow at:
# https://stackoverflow.com/questions/25261647/python-aes-encryption-without-extra-module

from cryptography.hazmat.primitives.ciphers import Cipher, algorithms, modes
from cryptography.hazmat.primitives import padding
from cryptography.hazmat.backends import default_backend


def encrypt(data):
    padded_message = padder.update(data) + padder.finalize()
    return encryptor.update(padded_message) + encryptor.finalize()


def decrypt(data):
    decrypted_message = decryptor.update(data) + decryptor.finalize()
    return unpadder.update(decrypted_message) + unpadder.finalize()


key = bytes.fromhex("EC58DFA74641AF52AD0D16E77D576623")
iv = bytes.fromhex("AFD12B66F89D1FC2FBB2AC7C56878DF8")
message = "Welcome to MATH 314!".encode("utf-8")

backend = default_backend()
cipher = Cipher(algorithms.AES(key), modes.CBC(iv), backend=backend)
encryptor = cipher.encryptor()
decryptor = cipher.decryptor()
padder = padding.PKCS7(128).padder()
unpadder = padding.PKCS7(128).unpadder()

encrypted = encrypt(message)
print(encrypted.hex().upper())

ciphertext = bytes.fromhex(
    "03e0e3645158bdf73674a8db5253ccb4f04f851f006f4ec7e0d5f3640dc541f1")
print(decrypt(ciphertext))
