# https://leetcode.com/problems/string-compression/

class Solution:
    def compress(self, chars: List[str]) -> int:
        if len(chars) == 0 : return chars
#get len
        llens=[]
        cc=[]
        prev=chars[0]
        ll = 1
        for i in range(1, len(chars)) :
            curr = chars[i]
            if curr == prev :
                ll += 1
            else :
                llens.append(ll)
                cc.append(prev)
                prev=curr
                ll=1

        cc.append(prev)
        llens.append(ll)        

#compress
        chars.clear()
        for i in range(0, len(cc)) :
            chars.append(cc[i])

            ll = llens[i]
            if ll > 1 :
                for x in list("%d" % ll) :
                    chars.append(x)

        return len(chars)
