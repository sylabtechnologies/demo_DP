package goog12;
import java.util.*;

// https://leetcode.com/problems/next-permutation/
class Solution
{
    public void nextPermutation(int[] nums)
    {
        final int len = nums.length;
        if (len == 1) return;
        
        // find 1st decreasing num
        int dec = len - 2;
        while (dec >= 0)
        {
            if (nums[dec] < nums[dec+1]) break;
            dec--;
        }
        
        if (dec < 0)
        {
            reverse(nums, 0);
            return;
        }
        
        int larger = 0, i = dec + 1;
        while (i < len)
        {
            if (nums[dec] < nums[i])
                larger = i;
            else break;
            
            i++;
        }
        
        swap(nums, dec, larger); // n-reverse all sorted:
        reverse(nums, dec + 1);
        return;
    }

    private void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start)
    {
        int i = start;
        int j = nums.length - 1;
        while (i < j)
            swap(nums, i++, j--);
    }
}
