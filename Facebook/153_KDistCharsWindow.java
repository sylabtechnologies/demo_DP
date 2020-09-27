// https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
package duptree;
import java.util.*;

class Solution
{
    public int lengthOfLongestSubstringKDistinct(String s, int lim)
    {
        if (s.isEmpty() || lim < 1) return 0;
        
        int freq[] = new int[256];
        
        int str = 0, fin = 0, max = 1, charCnt = 1;
        freq[s.charAt(0)] = 1;

        while (fin < s.length() - 1)
        {
            if (charCnt <= lim)
            {
                fin++;
                char next = s.charAt(fin);
                
                if (freq[next]++ == 0)
                    charCnt++;
            }
            else
            {
                char b4 = s.charAt(str);
                if (freq[b4]-- == 1)
                    charCnt--;

                str++;
                if (fin < str) fin++;
                
            }

            if (charCnt <= lim)
                max = Math.max(max, fin - str + 1);
        }
        
        return max;
    }
}
