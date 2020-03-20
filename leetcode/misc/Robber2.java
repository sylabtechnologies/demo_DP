// https://leetcode.com/problems/house-robber-ii/
package robber2;
import java.util.Arrays;

class Solution
{
    public int rob(int[] nums)
    {
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0];
        if (len == 2) return robHelper(nums);
        
        int arr1[] = Arrays.copyOfRange(nums, 0, len - 1);
        int arr2[] = Arrays.copyOfRange(nums, 1, len);
        
        return Math.max(robHelper(arr1), robHelper(arr2));
    }
    
    public int robHelper(int[] nums)
    {
        int len = nums.length;
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

public class Robber2
{
    public static void main(String[] args)
    {
        int[] test = {1, 2, 3, 1}; 
        Solution sol = new Solution();
        System.out.println(sol.rob(test));
    }    
}

