// https://leetcode.com/problems/unique-binary-search-trees/
// 

package binmountain;
import java.util.Arrays;

class Solution
{
    public static int peakIndexInMountainArray(int[] arr)
    {
        printArray(arr);
        
        int lo = 0;
        int hi = arr.length - 1;
        int ans = -1;
        
        while (hi - lo > 1)
        {
            int mid = (lo + hi) / 2;

            if (arr[mid] > arr[mid - 1])     // discard all to the left
            {
                lo = mid;
                ans = mid;
            }
            else
            {
                hi = mid;
                ans = mid - 1;
            }
        }
        
        return ans;
    }
    
    private static void printArray(int[] nums)
    {
        for (int i = 0; i < nums.length; i++)
            System.out.print(nums[i] + " ");
        
        System.out.println(";");
    }
    
}