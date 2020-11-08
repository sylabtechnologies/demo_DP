// https://leetcode.com/problems/get-maximum-in-generated-array/

class Solution:
    def getMaximumGenerated(self, n: int) -> int:
        if n <= 1 : return n

        arr = []
        for i in range(1,n+1) :
            arr.append(self.generate(i))

        return max(arr)

    @lru_cache(maxsize=128)
    def generate(self, n: int) ->int :
        if n <= 1 : return n

        if n % 2 == 0 :
            return self.generate(n//2)
        else :
            return self.generate(n//2) + self.generate(n//2+1);
