// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

package sortedtarget;

public class Solution
{
    // modify bin search
    public static int[] searchRange(int[] nums, int target)
    {
        int[] ans = {-1, -1};
        if (nums.length < 1) return ans;
        
        int lo = 0;
        int hi = nums.length - 1;
        int mid = 0;
        
        // find left
        while (lo < hi)
        {
            mid = lo + (hi - lo) / 2;

            if (nums[mid] < target)
                lo = mid + 1;
            else
                hi = mid;
        }
        
        if (nums[lo] != target) return ans;
        
        ans[0] = lo;
        hi = nums.length - 1;
        
        while (lo < hi)
        {
            mid = 1 + lo + (hi - lo) / 2;

            if (nums[mid] > target)
                hi = mid - 1;
            else
                lo = mid;
        }

        ans[1] = hi; return ans;
    }
    
    public static void printArray(int[] nums)
    {
        for (int i = 0; i < nums.length; i++)
        {
            System.out.print(nums[i] + " ");
        }
        System.out.println(";");
    }
    
}
