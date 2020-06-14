// https://leetcode.com/problems/largest-divisible-subset/
package divisiblesubset;
import java.util.*;

class Solution
{
    public List<Integer> largestDivisibleSubset(int[] nums)
    {
        LinkedList<Integer> ans = new LinkedList<>();
        int len = nums.length;
        if (len == 0) return ans;
        Arrays.sort(nums);
        
        // subset @ i
        int dp[]= new int[len];
        Arrays.fill(dp, 1);
        
        int prevIndex[]= new int[len];
        Arrays.fill(prevIndex, -1);

        int maxSubsetInd = 0;
        
        for (int i = 1; i < len; i++)
        {
            for (int j = 0; j < i; j++)
            {
                if (nums[i] % nums[j] == 0)
                {
                    if (dp[i] < dp[j] + 1)
                    {
                        dp[i] = dp[j] + 1;
                        prevIndex[i] = j;
                    }
                }
            }

            if (dp[i] > dp[maxSubsetInd])
                maxSubsetInd = i;
        }
        
        while (maxSubsetInd >= 0)
        {
            ans.addFirst(nums[maxSubsetInd]);
            maxSubsetInd = prevIndex[maxSubsetInd];
        }
        
        return ans;
    }
}

public class DivisibleSubset
{
    public static void main(String[] args)
    {
        int nums[] = {1,2,4,8};
        System.out.println(new Solution().largestDivisibleSubset(nums));
    }
    
}
