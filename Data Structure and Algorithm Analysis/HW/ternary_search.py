def ternary_search(nums, x):
    l = len(nums)
    if l == 0:
        return False
    if l == 1:
        return nums[0] == x
    elif l == 2:
        return nums[0] == x or nums[1] == x
    else:
        m1 = l // 3
        m2 = 2 * l // 3
        if nums[m1] == x:
            return True
        elif nums[m2] == x:
            return True
        elif nums[m1] > x:
            return ternary_search(nums[0:m1], x)
        elif nums[m2] > x:
            return ternary_search(nums[m1 + 1:m2], x)
        else:
            return ternary_search(nums[m2 + 1:l], x)


nums = [1, 3, 5, 7, 9, 27, 45, 46, 48, 50, 500]

num = int(input("Number to search for: "))
print("Was", num, "found in nums? :", ternary_search(nums, num))
