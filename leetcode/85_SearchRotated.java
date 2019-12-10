// https://leetcode.com/problems/search-in-rotated-sorted-array/
// clean up

package searchrotated;

public class Solution
{
    public static int binarySearch(int[] nums, int lo, int hi, int target)
    {
        while (lo <= hi)
        {
            int mid = (lo + hi)/2;

            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                lo = mid + 1;
            else
                hi = mid - 1;
        }

        return -1;
    }

    // find rotation R = A[r] > A[r+1]
    public static int search(int[] nums, int target)
    {
        printArray(nums);
        
        if (nums.length  < 2) return binarySearch(nums, 0, nums.length - 1, target);
        
        int lo = 0, hi = nums.length - 1, mid = 0;
        if (nums[lo] < nums[hi]) return binarySearch(nums, lo, hi, target);
        
        // find R
        while (lo <= hi)
        {
            mid = (lo + hi)/2;

            if (nums[mid] > nums[mid + 1]) break;
            
            if (nums[lo] < nums[mid])
                lo = mid;
            else 
                hi = mid;
        }
        
        int ans = binarySearch(nums, 0, mid, target);
        
        if (ans >= 0)
            return ans;
        else
            return binarySearch(nums, mid + 1, nums.length - 1, target);
    }

    private static void printArray(int[] nums)
    {
        for (int i = 0; i < nums.length; i++)
        {
            System.out.print(nums[i] + " ");
        }
        System.out.println(";");
    }
   
}
