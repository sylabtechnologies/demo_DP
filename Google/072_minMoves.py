# https://leetcode.com/problems/minimum-moves-to-equal-array-elements/
# 1 2 3 > 1 1 3 > 1 1 2 > 1 1 1

class Solution:
    def minMoves(self, nums: List[int]) -> int:
        nums.sort()

        ret=0
        delta=0
        for i in range(1, len(nums)) :
            delta = nums[i] - nums[i-1] + delta
            ret += delta

        return ret
