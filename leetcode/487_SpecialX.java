// https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/
package goog5;
import java.util.*;

class Solution
{
    public int specialArray(int[] nums)
    {
        final int len = nums.length;
        if (len == 0) return -1;
        if (len == 0) return (nums[0] >= 1) ? 1 : -1;
        
        Arrays.sort(nums);
        for (int i = len - 1; i>=0; i--)
        {
            int count = len - i;
            int curval = nums[i];
            
            if (curval >= count)
            {
                if (i == 0) return count;
                // satisfy condition #2
                if (nums[i-1] < count) return count;
            }
            
        }
        
        return -1;
    }
}

public class Goog5
{
    public static void main(String[] args)
    {
        int arr[] = {3,6,7,7,0};
        System.out.println(new Solution().specialArray(arr));
    }
}

