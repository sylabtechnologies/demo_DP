package goog12;
import java.util.*;

// https://leetcode.com/problems/maximum-length-of-repeated-subarray/
class Solution
{
    public int findLength(int[] arr1, int[] arr2)
    {
        int dp[][] = new int[arr1.length+1][arr2.length+1];
        
        int ret = 0;
        for (int i = arr1.length-1; i >= 0; --i)
        {
            for (int j = arr2.length-1; j >= 0; --j)
            {
                if (arr1[i] == arr2[j])
                {
                    dp[i][j] = dp[i+1][j+1] + 1;
                    ret = Math.max(ret, dp[i][j]);
                }
                
            }
        }

        return ret;
    }
}
