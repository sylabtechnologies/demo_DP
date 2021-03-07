package goog72;
import java.util.*;

/**
 * https://leetcode.com/problems/maximum-erasure-value/
 * #erase uniq subarray
 * #S  - 2 ptr
 */

class Solution 
{
    public int maximumUniqueSubarray(int[] nums) 
    {
        final int len = nums.length;
        if (len == 1) return nums[0];
        
        int hi = 0, lo = 0,  cnt = 0, max = Integer.MIN_VALUE;
        HashSet<Integer> uniq = new HashSet<>();
        
        while (hi < len)
        {
            int val = nums[hi++];

            while (uniq.contains(val))
            {
                uniq.remove(nums[lo]);
                cnt -= nums[lo];
                lo++;
            }
            
            if (!uniq.contains(val))
            {
                cnt += val;
                uniq.add(val);
                max = Math.max(max, cnt);
            }
        }
        
        return max;
    }
}

public class Goog72
{
    public static void main(String[] args)
    {
        int arr[] = {4,2,4,5,6};
        System.out.println(new Solution().maximumUniqueSubarray(arr));
    }
}
