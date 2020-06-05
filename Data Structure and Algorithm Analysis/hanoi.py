def hanoi(n, a, b, c):
    if n == 1:
        print("Move disc 1 from rod", a, "to rod", c)
        return
    hanoi(n - 1, a, c, b)
    print("Move disc", n, "from rod", a, "to rod", c)
    hanoi(n - 1, b, a, c)


hanoi(3, 'a', 'b', 'c')
