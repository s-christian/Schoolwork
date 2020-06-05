def is_prime(num):
    return num > 1 and all(num % i for i in range(2, int(num ** 0.5) - 1))
    # Only have to check up until the number's square root to see if there are any factors
    # Used information from:
    # https://stackoverflow.com/questions/4114167/checking-if-a-number-is-a-prime-number-in-python


num = int(input("Number to check for prime status: "))
print(is_prime(num))
