print("x^a (mod n)")
x = int(input("x: "))
a = int(input("a: "))
n = int(input("n: "))
b = 1

while a > 0:
    if a % 2 == 0:
        a /= 2
        x = (x * x) % n
    else:
        a -= 1
        b = (b * x) % n

print(b)
