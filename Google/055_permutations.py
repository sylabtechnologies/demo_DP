// https://leetcode.com/problems/permutations-ii/
from itertools import permutations

class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        ret = []
        for l in list(permutations(nums)) :
            if l not in ret : ret.append(l)

        return ret
            