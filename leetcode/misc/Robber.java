// https://leetcode.com/problems/house-robber/
// deduce from dp[i-1]

package robber;

class Solution
{
    public static int rob(int[] nums)
    {
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0];
        
        int dp[] = new int[len];
        
        // take one or another
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        // continue
        for (int i = 2; i < len; i++)
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);

        return dp[len - 1];
    }
}


public class Robber
{
    public static void main(String[] args)
    {
        int[] test = {2,7,9,3,1}; 
        System.out.println(Solution.rob(test));
    }
    
}
