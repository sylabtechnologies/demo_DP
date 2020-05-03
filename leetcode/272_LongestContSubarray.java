// https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/

package longestcontsubarray;
import java.util.*;

/// #TR= 2 ptr optimization BUT 2HEAP IS PERFECT
class Solution
{
    public int longestSubarray(int[] nums, final int limit)
    {
        int start = 0, len = 1, maxLen = 1;
        int localMax = nums[start], localMin = nums[start];
        boolean reset = false;
        
        while (start + len < nums.length)
        {
            // go
            int next = nums[start + len];
            if (next < localMin)
            {
                if (localMax - next > limit)
                    reset = true;
                else
                    localMin = next;
            }
            else if (next > localMax)
            {
                if (next - localMin > limit)
                    reset = true;
                else
                    localMax = next;
            }

            if (reset)
            {
                start = start + 1; len = 1; reset = false;
                localMax = nums[start]; localMin = nums[start];
            }
            else
            {
                len++;
                maxLen = Math.max(maxLen, len);
            }
        }
        
        return maxLen;
    }
}

public class LongestContSubarray
{
    public static void main(String[] args)
    {
//        int test[] = {8,2,4,7};
//        int test[] = {4,2,2,2,4,4,2,2};
//        int test[] = {9,10,1,7,9,3,9,9};

        int test[] = {10,1,2,4,7,2};
        System.out.println(new Solution().longestSubarray(test, 5));
    }
    
}
