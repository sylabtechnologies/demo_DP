// https://leetcode.com/problems/repeated-substring-pattern/
package repeatsub;

class Solution
{
    public boolean repeatedSubstringPattern(String str)
    {
        int len = str.length();
        if (len == 0) return false;
        
        for (int pattLen = 1; pattLen <= len/2; pattLen++)
        {
            if (len % pattLen != 0) continue;
            
            String patt = str.substring(0, pattLen);
            boolean found = true;
            for (int pattNum = 1; pattNum < len / pattLen; pattNum++)
            {
                String test = str.substring(pattNum*pattLen, pattNum*pattLen + pattLen);
                if (!patt.equals(test))
                {
                    found = false;
                    break;
                }
            }

            if (found) return true;
        }

        return false;
    }
}

public class RepeatSub
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().repeatedSubstringPattern("abab"));
    }
}
