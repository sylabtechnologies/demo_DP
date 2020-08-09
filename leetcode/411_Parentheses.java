// https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/
package pareninsert;
import java.util.*;

class Solution
{
    public int minInsertions(String s)
    {
        Stack<Character> stk = new Stack<>();
        for (char c : s.toCharArray())
        {
            if (c == '(')
                stk.push(c);
            else
            {
                if (stk.isEmpty())
                    stk.push(')');
                else
                {
                    char prev = stk.peek();
                    
                    if (prev == ')')
                    {
                        stk.pop();
                        
                        if (!stk.isEmpty() && stk.peek() == '(')
                            stk.pop();
                        else
                            stk.push(']');
                    }
                    else
                        stk.push(c);
                }
            }
            
            System.out.println(stk);
        }
        
        int ans = 0; char prev = '0';
        for (char c : stk)
        {
            if ( c != ']')
            {
                if (c == ')' && prev == '(')
                    ans--;
                else
                    ans += 2;
            }
            else
                ans++;
            
            prev = c;
        }
        
        return ans;
    }
}

public class ParenInsert
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().minInsertions( "))(()()))()))))))()())()(())()))))()())(()())))()(" ));
    }
}

