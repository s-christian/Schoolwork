def shift_encrypt(string, key):
    # Make it all lowercase and remove spaces
    string = string.lower().replace(' ', '')
    # Set so that our values are simpler, within the range 0-25
    # This helps for when we % by 26 for wrapping around the alphabet
    ord_values = [ord(x) - ord('a') for x in string]
    # Apply the shift
    shifted_ords = [(x + key) % 26 for x in ord_values]
    # Translate back into proper uppercase ASCII values
    # .join() takes elements from a list and makes them into a string
    # with the string inside the parenthesis being placed between
    # each element of the list, which is nothing in this case
    ciphertext = ''.join(chr(x + ord('A')) for x in shifted_ords)
    return ciphertext


def shift_decrypt(string, key):
    # No need to force into uppercase since it should already be
    ord_values = [ord(x) - ord('A') for x in string]
    shifted_ords = [(x - key) % 26 for x in ord_values]
    # translate back into proper lowercase ASCII values
    plaintext = ''.join(chr(x + ord('a')) for x in shifted_ords)
    return plaintext


print("A  B  C  D  E  F  G  H  I  J  K  L  M  N  O  P  Q  R  S  T  U  V  W  X  Y  Z ")
print("00 01 02 03 04 05 06 07 08 09 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25")

print()

string = input("String: ")
key = int(input("Key: "))

print()

ciphertext = shift_encrypt(string, key)
print("Ciphertext:\n%s" % ciphertext)
print("Plaintext:\n%s" % shift_decrypt(ciphertext, key))
