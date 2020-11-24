# https://leetcode.com/problems/shortest-distance-to-a-character/

class Solution:
    def shortestToChar(self, S: str, C: str) -> List[int]:
        ret = []
        ix = []
        for x in range(0, len(S)) :
            ret.append(100000) # equals to inf
            if S[x] == C :
                ix.append(x)
                ret[-1] = 0

        prev = -1
        for x in ix :
            pos = x - 1
            cnt = 1
            while pos != prev :
                ret[pos] = min(cnt, ret[pos])
                cnt+=1
                pos-=1
            prev = x

        last = len(S)
        for x in reversed(ix) :
            pos = x + 1
            cnt = 1
            while pos != last :
                ret[pos] = min(cnt, ret[pos])
                cnt+=1
                pos+=1
            last = x

        return ret
