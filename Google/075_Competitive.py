# https://leetcode.com/problems/find-the-most-competitive-subsequence/
# TLE

from itertools import combinations

class Solution:
    def mostCompetitive(self, nums: List[int], k: int) -> List[int]:
        ans = [10000000]*len(nums)
        for lst in combinations(nums,k) :
            if list(lst) < ans :
                ans.clear()
                ans.extend(lst)
                
        return ans