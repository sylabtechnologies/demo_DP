# https://leetcode.com/problems/maximum-repeating-substring/

class Solution:
    def maxRepeating(self, seq: str, word: str) -> int:
        count = 0
        curr = word
        while True:
            if seq.find(curr) >= 0 :
                count += 1
                curr += word
            else :
                break
            
        return count