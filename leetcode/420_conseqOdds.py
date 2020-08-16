# https://leetcode.com/problems/three-consecutive-odds/
class Solution:
    def threeConsecutiveOdds(self, arr: List[int]) -> bool:
        oddcount = 0
        for x in arr :
            oddcount = 0 if x % 2 == 0 else oddcount + 1
            if oddcount == 3 : return True

        return False
