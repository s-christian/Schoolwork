def shift(text, num):
    new_text = ""
    print("--- Original ---")
    print(text)
    for letter in text:
        val = ord(letter)
        if 65 <= val <= 90:  # uppercase latin characters
            if val + num > 90:
                new_text += chr(val + num - 26)
            elif val + num < 65:
                new_text += chr(val + num + 26)
            else:
                new_text += chr(val + num)
        elif 97 <= val <= 122:  # lowercase latin characters
            if val + num > 122:
                new_text += chr(val + num - 26)
            elif val + num < 97:
                new_text += chr(val + num + 26)
            else:
                new_text += chr(val + num)
        elif val == 32:  # space
            new_text += letter
        else:
            print("Unsupported character!")
    print("--- Encrypted ---")
    print(new_text)


text = input("Text : ")
num = int(input("Number to shift by : "))
if num <= -26:
    num += 26 * (num // -26)
elif num >= 26:
    num -= 26 * (num // 26)

shift(text, num)
