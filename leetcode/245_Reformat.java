// https://leetcode.com/problems/reformat-the-string/

package reformat;

class Solution
{
    public String reformat(String s)
    {
        StringBuilder alpha = new StringBuilder();
        StringBuilder num = new StringBuilder();
        
        for (char c : s.toCharArray())
        {
            if ( '0' <= c && c <= '9' )
                num.append(c);
            else
                alpha.append(c);
        }
        
        int diff = Math.abs(alpha.length() - num.length());
        if (diff > 1) return "";
        
        StringBuilder one = (alpha.length() > num.length()) ? alpha : num;
        StringBuilder two = (alpha.length() <= num.length()) ? alpha : num;
        
        StringBuilder res = new StringBuilder();
        int j = 0;
        for (int i = 0; i < one.length(); i++)
        {
            res.append(one.charAt(i));
            
            if (j < two.length())
                res.append(two.charAt(j++));
        }

        return res.toString();
    }
}

public class Reformat
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().reformat("ab123"));
    }
    
}
