# https://leetcode.com/problems/magnetic-force-between-two-balls/

class Solution:
    def maxDistance(self, position: List[int], k: int) -> int:

        position.sort()
        ll = len(position)

        hi = position[ll-1] - position[0]
        if k == 2 : return hi
        
        lo = position[ll-1]
        for i in range(1, ll) :
            d = position[i] - position[i - 1]
            if d < lo : lo = d 

        res = -1
        while lo < hi :
            mid = int((hi + lo) / 2)
            if self.canDo(position, mid, ll, k) :
                if mid > res : res = mid
                lo = mid + 1
            else :
                hi = mid
                
        return res

    def canDo(self, arr: List[int], mid: int, n : int, k : int) -> bool:
        position = arr[0]
        nElem = 1

        for i in range(1, n) :
            if arr[i] - position >= mid :
                position = arr[i]
                nElem += 1
                if nElem == k : return True

        return False

