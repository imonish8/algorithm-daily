// Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.

// You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.

class Solution(object):
    def firstMissingPositive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)

        # Change all [negative, zeros, numbers that out of range] => n+1
        for i in range(n):
            if nums[i] <=0 or nums[i] > n:
                nums[i] = n+1
        # change all number of it's order in list by negative [example: 5 change nums[4] "the fifth number in list" => negative]
        for i in range(n):
            if abs(nums[i]) > n:
                continue
            nums[abs(nums[i]) - 1] = -abs(nums[abs(nums[i]) - 1])
        # check every number in range list if the equivalent of it isn't negative this means that the number is not in the list. 
        for i in range(n):
            if nums[i] > 0:
                return i+1
        # Finally if all of them didn't return any thing this mean that the number the lose is the last number 
        return n + 1
