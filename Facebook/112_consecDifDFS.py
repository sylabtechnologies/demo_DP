# https://leetcode.com/problems/numbers-with-same-consecutive-differences/
class Solution:
    def numsSameConsecDiff(self, N: int, K: int) -> List[int]:
        self.elements=[]
        if N == 1 : self.elements.append(0)
        
        self.elemSize=N
        self.elemStep=K
        for x in range(1,10):
            self.dfs(x,1)
            
        return self.elements;

    def dfs(self, number: int, size: int) :
        if size == self.elemSize :
            self.elements.append(number)
            return

        dig = number % 10
        nextNum = dig - self.elemStep
        if nextNum >= 0 :
            self.dfs(number*10 + nextNum, size + 1)
        
        if self.elemStep == 0 : return

        nextNum = dig + self.elemStep
        if nextNum < 10 :
            self.dfs(number*10 + nextNum, size + 1)
