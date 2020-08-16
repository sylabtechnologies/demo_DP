# https://leetcode.com/problems/minimum-operations-to-make-array-equal/

class Solution:
    def minOperations(self, n: int) -> int:
        if n == 1 : return 0
        if n == 2 : return 1
        return n - 1 + self.minOperations(n - 2)
        