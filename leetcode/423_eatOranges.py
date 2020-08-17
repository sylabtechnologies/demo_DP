# https://leetcode.com/problems/minimum-number-of-days-to-eat-n-oranges/
# select each day n / 2 or 2n /3 each day plus allowance

class Solution:
    @lru_cache()
    def minDays(self, n: int) -> int:
        if n <= 1 : return n

        x2 = n % 2 + self.minDays(int(n/2))
        x3 = n % 3 + self.minDays(int(n/3))
        return 1 + min(x2, x3)
