# Programming Assessment 2 - Problem D2
def is_prime(n):
    for i in range(2, int(n**0.5 + 1)):
        if n % i == 0:
            print(n, "/", i, "=", n/i, end=', ')
            return False
    return True


n = int(input("Number to check for primality: "))
print("Is", n, "prime? : ", end='')
print(is_prime(n))
