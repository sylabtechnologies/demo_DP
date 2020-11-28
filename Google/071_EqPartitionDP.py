# https://leetcode.com/problems/partition-equal-subset-sum/

class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        mysum = sum(nums)
        if mysum % 2 == 1 :
            return False
        else :
            mysum = mysum//2
        
        dp = [False]*(mysum+1)
        dp[0] = True
        for cur in nums :
            for i in reversed(range(cur,mysum+1)) :
                if dp[i - cur] :
                    dp[i] = True
            print(dp)

        return dp[mysum]
