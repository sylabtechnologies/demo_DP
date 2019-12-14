// https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
// do slice checking

package searchrotated;

public class Solution
{
    public static boolean search(int[] nums, int target)
    {
        printArray(nums);
        
        if (nums.length == 0) return false;
        
        int lo = 0, hi = nums.length - 1, mid = 0;
        
        while (lo <= hi)
        {
            if (nums[lo] < nums[hi]) return binarySearch(nums, lo, hi, target);

            if (lo == hi ) return nums[lo] == target;
            
            if ( lo + 1 == hi )
            {
                if (nums[lo] == target | nums[hi] == target)
                    return true;
                else 
                    return false;
            }
            
            mid = (lo + hi)/2;
            
            if (nums[mid] == target) return true;

            if (nums[lo] == nums[mid])
            {
                if (nums[mid] == target)
                    return true;
                
                while (nums[lo] == nums[mid] && lo <= mid)
                    lo++;
            }
            else if (nums[lo] < nums[mid])
            {
                if (binarySearch(nums, lo, mid, target))
                    return true;
                else
                    lo = mid + 1;
            }
            else
            {
                if (binarySearch(nums, mid, hi, target))
                    return true;
                else
                    hi = mid - 1;
            }
        }
        
        return true;
    }

    public static boolean binarySearch(int[] nums, int lo, int hi, int target)
    {
        while (lo <= hi)
        {
            int mid = (lo + hi)/2;

            if (nums[mid] == target)
                return true;
            else if (nums[mid] < target)
                lo = mid + 1;
            else
                hi = mid - 1;
        }

        return false;
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
