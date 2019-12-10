// https://leetcode.com/problems/search-in-rotated-sorted-array/

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

    private static int testPair(int[] nums, int lo, int hi, int target)
    {
        if (lo + 1 != hi) throw new IllegalArgumentException("pair test");
        
        if (nums[lo] == target)
            return lo;
        else if (nums[hi] == target)
            return hi;
        else
            return -1;
    }
    
    // **** if right < left = we are rotated
    public static int search(int[] nums, int target)
    {
        printArray(nums);
        
        if (nums.length == 0) return -1;
        if (nums.length == 1) return (nums[0] == target) ? 0 : -1;
        
        if (nums.length == 2) 
            return testPair(nums, 0, 1, target);
        
        int lo = 0, hi = nums.length - 1;
        
        while (lo <= hi)
        {
            if (lo + 1 == hi) return testPair(nums, lo, hi, target);
            
            if (nums[lo] <= nums[hi])
                return binarySearch(nums, lo, hi, target);
            
            int mid = (lo + hi)/2;

            if (nums[mid] == target)
                return mid;
            else if (nums[lo] < nums[mid])
            {
                if (target < nums[lo] || target > nums[mid])
                    lo = mid + 1;
                else
                    hi = mid;
            }
            else
            {
                if (target < nums[mid] || target > nums[hi])
                    hi = mid-1;
                else
                    lo = mid;
            }
        }
        
        return -1;
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
