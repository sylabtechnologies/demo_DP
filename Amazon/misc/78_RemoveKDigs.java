// https://leetcode.com/problems/remove-k-digits/

package removekdigs;
import java.util.*;

class Solution
{
    public String removeKdigits(String num, int k)
    {
        if (num.length() <= k) return "0";
        char digs[] = num.toCharArray();

        Stack<Character> stk = new Stack<>();
        for (char d : digs)
        {
            while (k > 0 && !stk.isEmpty() && d < stk.peek())
            {
                stk.pop();
                k--;
            }
            
            stk.push(d);
            System.out.println(stk);
        }
        
        for (int i = 0; i < k; i++)
            stk.pop();
        
        StringBuilder sb = new StringBuilder();
        
        for (Character d : stk)
            sb.append(d);
        
        int leadZZ = 0;
        for (int i = 0; i < sb.length(); i++)
        {
            if (sb.charAt(i) == '0')
                leadZZ++;
            else
                break;
        }
        
        if (leadZZ > 0) sb.delete(0, leadZZ);
        return sb.length() > 0 ? sb.toString() : "0";
    }
}

public class RemoveKDigs
{
    public static void main(String[] args)
    {
        String num = "10200";    
        System.out.println(new Solution().removeKdigits(num, 1));
    }
}
