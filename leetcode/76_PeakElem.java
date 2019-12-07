/*
 * https://leetcode.com/problems/find-peak-element/, peak exists
 */

package peakelem;

class Solution
{
    public static int findPeakElement(int[] nums)
    {
        int lo = 0;
        int hi = nums.length - 1;
        int mid = 0;
        
        while (lo < hi)
        {
            mid = lo + (hi - lo + 1) / 2;

            if (mid > 0 && nums[mid] > nums[mid - 1])   // discard left
                lo = mid;
            else
                hi = mid - 1;
        }
        
        return lo;
    }
}

