// https://leetcode.com/problems/non-decreasing-array/ 
// just A or B
package goog7;
import java.util.*;

class Solution
{
    public boolean checkPossibility(int[] nums)
    {
        int hit = findNondecr(nums, -1);
        if (hit < 0) return true;

        int res1 = findNondecr(nums, hit);
        if (res1 < 0) return true;

        int res2 = findNondecr(nums, hit-1);
        if (res2 < 0) return true;
        
        return false;
    }

    private int findNondecr(int arr[], int skip)
    {
        int i = 0, j = 1;
        
        if (skip == 0)
        {
            i++; j++;            
        }
        
        boolean skipped = false;
        while (j < arr.length)
        {
            if (j == skip)
            {
                skipped = true;
                j++;
                continue;
            }
            
            if (arr[i] > arr[j]) return j;
            
            if (skipped)
            {
                skipped = false;
                i++;
            }
            
            i++; j++;            
        }

        return -1;
    }
}
