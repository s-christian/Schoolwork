# Code mainly copied from Dr. O'Leary during class
def extended_euclid(a, b):
    a0 = a
    b0 = b

    r = []
    q = []
    x = [0, 1]
    y = [1, 0]
    print(" " * 50 + "x = {0:<10} y = {1:<10}".format(x[-2], y[-2]))
    print(" " * 50 + "x = {0:<10} y = {1:<10}".format(x[-1], y[-1]))
    while(b > 0):
        q.append(a // b)
        r.append(a % b)
        x.append(x[-2] - q[-1] * x[-1])
        y.append(y[-2] - q[-1] * y[-1])
        if(r[-1] > 0):
            print("{0:10} = {1:>5} * {2:<8} + {3:<8}          x = {4:<10} y = {5:<10}".format(a, q[-1], b, r[-1], x[-1], y[-1]))
        else:
            print("{0:10} = {1:>5} * {2:<8} + {3:<8}".format(a, q[-1], b, r[-1]))
            print("%d * %d = %d (mod %d)" % (a0, y[-2], (a0 * y[-2]) % b0, b0))
        a, b = b, a % b

    print("\ngcd({}, {}) = {}".format(a0, b0, a))
    print("{}*{} + {}*{} = {}".format(x[-2], b0, y[-2], a0, x[-2] * b0 + y[-2] * a0))


a = int(input("a = "))
b = int(input("b = "))
extended_euclid(a, b)
