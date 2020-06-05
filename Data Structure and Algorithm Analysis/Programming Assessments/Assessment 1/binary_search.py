# Programming Assessment 1, Problem 2
def binary_search(d, l):
    if len(l) != 0:
        mid = len(l) // 2
        if l[mid] == d:
            return True
        elif l[mid] < d:
            return binary_search(d, l[:mid])
        else:
            return binary_search(d, l[mid + 1:])
    else:
        return False


a = [101, 92, 41, 36, 28, 12, 10, 8, 5, 3]
print("List:", a)
num = int(input("Number to search for in List: "))
print(num, "found in List? :", binary_search(num, a))
