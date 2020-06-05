def decrypt_all(string):
    ord_values = [ord(x) - ord('A') for x in string]
    for key in range(0, 26):
        shifted_ords = [(x + key) % 26 for x in ord_values]
        print(''.join(chr(x + ord('a')) for x in shifted_ords))


# Correct answer: Plaintext encrypted using a key of 17 (26 - 9)
# "studying cryptography requires time and effort"
string = "JKLUPZEXTIPGKFXIRGYPIVHLZIVJKZDVREUVWWFIK"
decrypt_all(string)
