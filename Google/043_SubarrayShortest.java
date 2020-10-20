package goog12;
import java.util.*;

// https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
class Solution
{
    public int findUnsortedSubarray(int[] nums)
    {
        final int len = nums.length;
        if (len == 1) return 0;
        if (len == 2)
            return nums[0] <= nums[1] ? 0 : 2;
        
        int copy[] = Arrays.copyOf(nums, len);
        Arrays.sort(copy);
        
        int start = 0;
        while (start < len)
        {
            if (copy[start] != nums[start]) break;
            start++;
        }
        
        if (start == len) return 0;
        
        int end = len - 1;
        while (end > start)
        {
            if (copy[end] != nums[end]) break;
            end--;
        }
        
        return end - start + 1;
    }
}
