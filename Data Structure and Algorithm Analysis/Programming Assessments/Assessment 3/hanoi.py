def hanoi(n, x, y, z):
    if n == 1:
        print("Move disc 1 from rod", x, "to rod", z)
        return
    hanoi(n - 1, x, z, y)
    print("Move disc", n, "from rod", x, "to rod", z)
    hanoi(n - 1, y, x, z)


n = int(input("n = "))
if n < 50:
    print("n must be >= 50. Setting n to 50.")
    n = 50

hanoi(n, 'x', 'y', 'z')
