// https://leetcode.com/problems/number-of-good-ways-to-split-a-string/

package taska;
import java.util.*;

class Solution
{
    public int numSplits(String s)
    {
        int freq[] = setFreq(s);
        
        int total = 0;
        for (int f : freq)
            if (f > 0) total++;
        
        int ans = 0, leftDistict = 0;
        int leftfreq[] = new int[26];
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            int ix = c - 'a';
            
            if (leftfreq[ix] == 0)
                leftDistict++;

            leftfreq[ix]++;
            
            if (freq[ix] > 0)
            {
                freq[ix]--;
                if (freq[ix] == 0) total--;                
            }
            
            if (leftDistict == total) ans++;
        }

        return ans;
    }

    private int[] setFreq(String s)
    {
        int freq[] = new int[26];
        for (char c : s.toCharArray())
        {
            int ix = c - 'a';
            freq[ix]++;
        }

        return freq;
    }
}


public class TaskA
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().numSplits("aacaba"));
//        System.out.println(new Solution().numSplits("abcd"));
    }
    
}
