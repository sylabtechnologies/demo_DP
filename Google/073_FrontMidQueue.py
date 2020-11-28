# Design a queue that supports push and pop operations in the front, middle, and back

from collections import deque
class FrontMiddleBackQueue(object):

    def __init__(self):
        self.deq = deque()

    def pushFront(self, val):
        self.deq.appendleft(val)

    def pushMiddle(self, val):
        mid = len(self.deq)//2
        self.deq.insert(mid, val)

    def pushBack(self, val):
        self.deq.append(val)
        
    def popFront(self):
        if len(self.deq) == 0 :
            return -1
        else :
            return self.deq.popleft()

    def popBack(self):
        if len(self.deq) == 0 :
            return -1
        else :
            return self.deq.pop()

    def popMiddle(self):
        mid = len(self.deq)

        if mid == 0 :
            return -1

        if mid % 2 == 0 :
            mid = mid // 2 - 1
        else :
            mid = mid // 2 

        ret = self.deq[mid]
        del self.deq[mid]
        return ret
