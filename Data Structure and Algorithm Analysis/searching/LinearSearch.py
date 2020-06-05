def LinearSearch(x, nums):
    for num in nums:
        if x == num:
            return True
    return False


nums_list = [1, 8, 3, 0, 381, 6, 7]
find = int(input("Number to search for in nums: "))

print("Was", find, "found? :", LinearSearch(find, nums_list))
