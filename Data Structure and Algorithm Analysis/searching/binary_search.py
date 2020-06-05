def rec_bin_search(x, nums):
    if len(nums) == 0:
        return False
    if nums[len(nums) // 2] == x:
        return True
    elif nums[len(nums) // 2] > x:
        return rec_bin_search(x, nums[:len(nums) // 2])
    elif nums[len(nums) // 2] < x:
        return rec_bin_search(x, nums[len(nums) // 2 + 1:])


nums = [1, 3, 5, 7, 9, 27, 45, 46, 48, 50, 500]

num = int(input("Number to search for: "))
print("Was", num, "found in nums? :", rec_bin_search(num, nums))
