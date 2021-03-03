# Competitive programming

class Solution:
    def findErrorNums(self, nums: List[int]) -> List[int]:
        c = Counter(nums)
        ret = [0,0]
        for i in range(1, len(nums) + 1) :
            if i not in c :
                ret[1] = i
            elif c[i] == 2 :
                ret[0] = i
        return ret


# Dynamic Programming

Convert recursion to memoization!