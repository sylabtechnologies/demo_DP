package goog30;
import java.util.*;

// x,y,n @ n = x + y https://leetcode.com/problems/additive-number/
class Solution
{
    public boolean isAdditiveNumber(String num)
    {
        if (num.length() < 3) return false;
        if (num.equals(repeatChar('0', num.length()))) return true;
        
        for (int i = 0; i < num.length()/2; i++)
        {
            if (i > 0 && num.charAt(0) == '0') return false;
            long x = Long.parseLong(num.substring(0, i+1));
            if (help(num, i + 1, x)) return true;
        }
        
        return false;
    }

    private boolean help(String num, int start, long x)
    {
        for (int mylen = 1; start + mylen < num.length(); mylen++)
        {
            if (mylen > 1 && num.charAt(start) == '0') return false;
        
            long y = Long.parseLong(num.substring(start, start + mylen));
            
            String next = Long.toString(x + y);
            if (num.substring(start + mylen).equals(next)) return true;

            if (num.substring(start + mylen, Math.min(start + mylen + next.length(), num.length())).equals(next))
            {
                if (help(num, start + mylen, y)) return true;
            }
        }
        
        return false;
    }

    private String repeatChar(char c, int length)
    {
        char rep[] = new char[length];
        Arrays.fill(rep, '0');
        return new String(rep);
    }
}

public class Goog30
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().isAdditiveNumber("0235813"));
    }
}
