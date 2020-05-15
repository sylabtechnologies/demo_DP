// https://leetcode.com/problems/number-of-longest-increasing-subsequence/

package longcont;
import java.util.*;

class Solution
{
    public int findNumberOfLIS(int[] nums)
    {
        int len = nums.length;
        if (len == 0) return 0;

        int dp[]  = new int[len]; Arrays.fill(dp, 1);
        int seqLength[]  = new int[len]; Arrays.fill(seqLength, 1);
        
        /// grow from 0:
        for (int i = 0; i < len; i++)
        {
            for (int j = 0; j < i; j++)
            {
                if (nums[i] > nums[j])
                {
                    if (dp[i] > dp[j] + 1)
                        continue;
                    else if (dp[i] == dp[j] + 1)
                        seqLength[i] += seqLength[j];
                    else
                    {
                        dp[i] = dp[j] + 1;
                        seqLength[i] = seqLength[j];
                    }
                }
            }
        }
        
        int max = 0;
        for (int n : dp)
            max = Math.max(max, n);
        
        int ans = 0;
        for (int i = 0; i < len; i++)
        {
            if (dp[i] == max)
                ans += seqLength[i];
        }
        
        return ans;
    }
}

public class LongCont
{
    public static void main(String[] args)
    {
        int arr[] = {1,3,5,4,7}; 
        System.out.println(new Solution().findNumberOfLIS(arr));
    }
    
}
