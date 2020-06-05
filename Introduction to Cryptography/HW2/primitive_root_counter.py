def primitive_roots(x):
    roots = []
    for n in range(2, x):
        correct = [i for i in range(1, x)]
        nums = [1]
        for pows in range(1, x - 1):
            nums.append((n ** pows) % x)
        nums.sort()
        if nums == correct:
            roots.append(n)
    return roots


num = int(input("num = "))
prim_roots = primitive_roots(num)
print(prim_roots)
