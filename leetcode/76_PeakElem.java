/*
 * https://leetcode.com/problems/find-peak-element/
 */

package peakelem;

class Solution
{
    // peak exists:
    public static int findPeakElement(int[] nums)
    {
        if (nums.length == 0) return -1;

        if (nums.length == 1) return 0;

        if (nums.length == 2)
        {
            if (nums[0] > nums[1])
                return 0;
            else if (nums[0] < nums[1])
                return 1;
            else return -11;
        }
        
        if (nums[0] > nums[1]) return 0;
            
        if (nums[nums.length - 2] < nums[nums.length - 1]) return nums.length - 1;
        
        // naive search
        for (int i = 1; i < nums.length - 1; i++)
        {
            if ( (nums[i - 1] < nums[i]) && (nums[i] > nums[i + 1]) )
                return i;
        }
        
        return -1;
    }
}

/*
*/
