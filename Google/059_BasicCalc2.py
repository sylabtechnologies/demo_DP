# https://leetcode.com/problems/basic-calculator-ii/

class Solution:
    def calculate(self, s: str) -> int:
        
        s.replace(" ", "")
        toks = []
        token=""
        
        for c in s :
            if  c in ["+", "-", "*", "/",] :
                toks.append(token)
                token=""
                toks.append(str(c))
            else :
                token += str(c)
        
        toks.append(token)
        
        #1
        stk = []
        go = False
        prev = ""
        for op in toks :
            if go :
                go = False
                op2 = int(op)
                op1 = stk[-1]
                del stk[-1]
                if prev == "*" :
                    stk.append(op1*op2)
                else :
                    stk.append(op1//op2)
                continue

            if op in ["*", "/"] :
                go = True
                prev = op
                continue

            if op in ["+", "-"] :
                stk.append(op)
                continue

            stk.append(int(op))

        #2
        ret = 0
        prevPlus = True
        for op in stk :
            if op == "+" :
                prevPlus = True
                continue
            if op == "-" :
                prevPlus = False
                continue
                
            if prevPlus :
                ret += op
            else :
                ret -= op

        return ret

