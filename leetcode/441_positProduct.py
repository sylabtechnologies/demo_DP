## https://leetcode.com/problems/maximum-length-of-subarray-with-positive-product/

class Solution:
    def getMaxLen(self, nums: List[int]) -> int:

        negCount = 0
        totLen = 0
        negSecondary = 0
        posLen = 0
        max = 0

        for x in nums :
            if x == 0 :
                negCount = 0
                totLen = 0
                negSecondary = 0
                posLen = 0
                continue

            totLen += 1

            if x < 0 :
                if (negCount == 1) :
                    negSecondary = posLen

                posLen = 0
                negCount += 1
            else :
                posLen += 1
                if posLen > max : max = posLen
            
            if negCount > 1 :
                negSecondary += 1

            if negCount % 2 == 0 :
                if totLen > max : max = totLen
            else :
                if negSecondary > max : max = negSecondary

        return max
