# https://leetcode.com/problems/find-the-most-competitive-subsequence/
# TLE

class Solution:
    def mostCompetitive(self, nums: List[int], k: int) -> List[int]:
        ans = []
        notdone=True
        while k > 1 :
            k-=1
            nxt = min(nums[:-k])
            ans.append(nxt)
            ind = nums.index(nxt)
            nums = nums[ind + 1:]
            if len(nums) == k :
                ans.extend(nums)
                notdone = False
                break
                
        if notdone :
            ans.append(min(nums))
        
        return ans
