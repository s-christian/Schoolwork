# Attempted to copy Dr. O'Leary's code for the encode and decode functions


def encode(plaintext, key):
    numerical_text = [ord(x) - ord('a') for x in plaintext]
    numerical_key = [ord(x) - ord('a') for x in key]
    l = len(key)
    numerical_encoded = [(x + numerical_key[i % l]) % 26 for i, x in enumerate(numerical_text)]
    ciphertext = ''.join(chr(x + ord('A')) for x in numerical_encoded)
    return ciphertext


def decode(ciphertext, key):
    numerical_text = [ord(x) - ord('A') for x in ciphertext]
    numerical_key = [ord(x) - ord('a') for x in key]
    l = len(key)
    numerical_encoded = [(x - numerical_key[i % l] ) % 26 for i, x in enumerate(numerical_text)]
    plaintext = ''.join(chr(x + ord('a')) for x in numerical_encoded)
    return plaintext


text = input("Text to encode/decode : ")
key = input("Key for encoding/decoding : ").lower()
print("\nOriginal :", text)
# Characters to remove from original user-provided String
remove = " ,.!@#$%^&*()-_=+"
# When creating a dictionary using the characters of a String as the keys,
# their values will be "None" since there are no specified corresponding values.
# str.maketrans(2 iterables or a dictionary, optional 3rd iterable) maps unicode characters
# to their replacement values, dictionary style. Every element of the optional third
# parameter will be deleted.
translation = str.maketrans(dict.fromkeys(remove))
# Force lowercase and remove specified characters using our newly-created translation table
cleaned = text.lower().translate(translation)
print("Cleaned  :", cleaned)
encoded = encode(cleaned, key)
print("\nEncoded :", encoded)
print("Decoded back :", decode(encoded, key))
print("\nDecoded original text :", decode(text, key))
