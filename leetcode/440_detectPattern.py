// https://leetcode.com/contest/weekly-contest-204/problems/detect-pattern-of-length-m-repeated-k-or-more-times/

class Solution:
    def containsPattern(self, arr: List[int], patternLen: int, pNum: int) -> bool:

        for i in range(0, len(arr) - patternLen) :
            pattern = arr[i : i + patternLen ]
            numSteps = int( (len(arr) - i) / patternLen)
            count = 1
            for k in range(1, numSteps + 1) :
                test = arr[ i + k * patternLen : i + (k + 1) * patternLen]
                if test == pattern :
                    count += 1
                else :
                    break

                if count >= pNum : return True

        return False

    




