// https://leetcode.com/problems/minimum-subsequence-in-non-increasing-order/

package minsubseq;
import java.util.*;

class Solution
{
    public List<Integer> minSubsequence(int[] nums)
    {
        Arrays.sort(nums);
        
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
            sum += nums[i];

        List<Integer> ans = new ArrayList<>();
        int subseqSum = 0;
        for (int i = nums.length - 1; i >= 0; i--)
        {
            ans.add(nums[i]);
            subseqSum += nums[i];
            
            if (subseqSum > sum - subseqSum) break;
        }

        return ans;
    }
}

public class MinSubseq
{

    public static void main(String[] args)
    {
        int nums[] = {4,3,10,9,8};
        Solution sl = new Solution();
        System.out.println(sl.minSubsequence(nums));
    }    
}
