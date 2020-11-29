# https://leetcode.com/problems/longest-increasing-subsequence/ 
# replace w/ smaller elem

from sortedcontainers import SortedSet

class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        s = SortedSet()
        for x in nums :
            if x in s :
                continue
                
            s.add(x)
            it = s.irange(x+1)
            nxt = next(it, None)
            if nxt :
                s.remove(nxt)
                        
        return len(s)                

