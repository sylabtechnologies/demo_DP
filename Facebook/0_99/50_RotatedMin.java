// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/

package rotatedmin;
import java.util.*;

class Solution
{
    public int findMin(int[] nums)
    {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.min(nums[0], nums[1]);

        int curr = 0;
        for (int i = 1; i < nums.length; i++)
        {
            int n = nums[i];
            
            if (n != nums[curr])
                nums[++curr] = n;
        }
        
        System.out.println(Arrays.toString(nums));
        
        int len = curr + 1;
        if (len == 1) return nums[0];
        if (len == 2)
            return Math.min(nums[0], nums[1]);
        
        return binSearch(nums, curr);
    }
    
    // no dups
    public int binSearch(int[] nums, int hi)
    {
        int lo = 0, mid = 0;        
        if (nums[lo] < nums[hi]) return nums[lo];

        while (lo <= hi)
        {
            mid = lo + (hi - lo) / 2;

            if (nums[mid] > nums[mid + 1]) return nums[mid + 1];
            
            if (nums[lo] < nums[mid])
                lo = mid;
            else 
                hi = mid;            
        }
        
        return nums[mid];
    }
}

public class RotatedMin
{
    public static void main(String[] args)
    {
        int arr[] = {1,1,1,0};
        System.out.println(new Solution().findMin(arr)); 
    }
    
}
