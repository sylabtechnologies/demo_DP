// https://leetcode.com/problems/combination-sum-iv/
package combo3;
import java.util.*;

// knapsack
class Solution
{
    public int combinationSum4(int[] nums, int target)
    {
        Arrays.sort(nums);
        int dp[] = new int[target+1];
        
        for (int current = 1; current < dp.length; current++)
        {
            for (int n : nums)
            {
                if (n > current)
                    break;

                if (current == n)
                {
                    dp[current]++;
                    break;
                }
                
                if (dp[current - n] > 0)
                    dp[current] += dp[current - n];
            }
        }

        return dp[target];
    }
}

public class Combo
{
    public static void main(String[] args)
    {
        int candidates[] = {1,2,3};
        System.out.println(new Solution().combinationSum4(candidates, 4));
    }
}
