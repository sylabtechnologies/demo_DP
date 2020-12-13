package goog27;
import java.util.*;

// https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/
class Solution
{
    public int[] getSumAbsoluteDifferences(int[] nums)
    {
        final int len = nums.length;
        int prefixSum[]  = new int[len];
        prefixSum[0] = nums[0];
        for (int i = 1; i < len; i++)
            prefixSum[i] = prefixSum[i-1] + nums[i];
            
        int ans[] = new int[len];
        for (int i = 1; i < nums.length-1; i++)
        {
            int rgt = prefixSum[len-1] - prefixSum[i];
            rgt -= nums[i]*(len-1-i);
            
            int lft = nums[i]*(i+1);
            lft -= prefixSum[i];

            ans[i] = rgt + lft;
        }
        
        ans[0] = prefixSum[len-1] - nums[0]*len;
        ans[len-1] = nums[len-1]*(len-1) - prefixSum[len-2];
        return ans;
    }
}

public class Goog27
{
    public static void main(String[] args)
    {
        int arr[] = {1,4,6,8,10};
        System.out.println(Arrays.toString(new Solution().getSumAbsoluteDifferences(arr)));
    }
}
