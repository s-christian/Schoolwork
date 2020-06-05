x = [4, 5, 6, 7]
a = []

# Fill list 'a' with the running average from list 'x'
sum = 0
for i in range(0, len(x)):
    sum += x[i]
    a.append(sum / (i + 1))

print(a)
