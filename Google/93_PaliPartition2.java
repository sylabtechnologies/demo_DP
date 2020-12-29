package goog43;
import java.util.*;

/**
 * https://leetcode.com/problems/palindrome-partitioning-ii/
 */

class Solution 
{
    public int minCut(String s) 
    {
        final int len = s.length();
        if (len == 1) return 0;
        
        int dp[] = new int[len];
        for (int i = 0; i < len; i++) 
            dp[i] = i;  // + 1?
        
        // chain from right
        for (int cent = 0; cent < len; cent++) 
        {
            int left = cent, rght = cent;
            while (left >= 0 && rght < len && s.charAt(left) == s.charAt(rght))
            {
                int val = left > 0 ? dp[left - 1] + 1 : 0;
                dp[rght] = Math.min(dp[rght], val);
                left--; rght++;
            }
            
            left = cent; rght = cent+1;
            while (left >= 0 && rght < len && s.charAt(left) == s.charAt(rght))
            {
                int val = left > 0 ? dp[left - 1] + 1 : 0;
                dp[rght] = Math.min(dp[rght], val);
                left--; rght++;
            }
        }

        return dp[len-1];
    }
}


public class Goog43
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().minCut("aabba"));
    }
}

