package goog27;
import java.util.Arrays;

// https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/
class Solution
{
    public int[] getSumAbsoluteDifferences(int[] nums)
    {
        final int len = nums.length;
        PrefixSum pfs = new PrefixSum(nums);
        
        int ans[] = new int[len];
        for (int i = 1; i < nums.length-1; i++)
        {
            int rgt = pfs.getSum(i+1, len-1);
            rgt -= nums[i]*(len-1-i);
            
            int lft = nums[i]*i;
            lft -= pfs.getSum(0, i-1);

            ans[i] = rgt + lft;
        }
        
        ans[0] = pfs.getSum(0, len-1) - nums[0]*len;
        ans[len-1] = nums[len-1]*(len-1) - pfs.getSum(0, len-2);
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
