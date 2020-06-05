def chinese_remainder_theorem(a1, n1, a2, n2):
    a, b = n1, n2
    r = []
    q = []
    x = [0, 1]
    y = [1, 0]
    while(b > 0):
        q.append(a // b)
        r.append(a % b)
        x.append(x[-2] - q[-1] * x[-1])
        y.append(y[-2] - q[-1] * y[-1])
        a, b = b, a % b
    if a != 1:  # a represents gcd(n1, n2)
        return -1  # will not work if gcd(n1, n2) != 1
    solution = a2 * y[-2] * n1 + a1 * x[-2] * n2
    if solution < 0:
        solution = solution + n1 * n2
    return solution


print("Form: x = ai (mod ni)")
a1 = int(input("a1 = "))
n1 = int(input("n1 = "))
a2 = int(input("a2 = "))
n2 = int(input("n2 = "))
print(chinese_remainder_theorem(a1, n1, a2, n2))
