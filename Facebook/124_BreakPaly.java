// https://leetcode.com/problems/break-a-palindrome/
package breakpaly;

class Solution
{
    public String breakPalindrome(String palindromeStr)
    {
        char pval[] = palindromeStr.toCharArray();
        
        int len = pval.length;
        if (len == 1) return new String();
        
        int mid = -1;
        if (len % 2 == 1) mid = len/2;
        
        boolean replaced = false;
        for (int i = 0; i < pval.length - 1; i++)
        {
            char c = pval[i];
            
            if (c > 'a' && i != mid)
            {
                pval[i] = 'a';
                replaced = true;
                break;
            }
        }
        
        if (!replaced && pval[pval.length - 1] == 'a')
        {
            pval[pval.length - 1] = 'b';
            replaced = true;
        }
        
        if (replaced)
            return new String(pval);
        else
            return new String();
    }
}
