// https://leetcode.com/problems/find-pivot-index/

package PivotIndex;
import java.util.*;

class Solution
{
    public int pivotIndex(int[] nums)
    {
        int sums[] = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
        {
            sum += nums[i];
            sums[i] = sum;
        }

        for (int i = 0; i < nums.length; i++)
        {
            int curr = nums[i];
            int leftsum = sums[i] - curr;
            int rightsum = sum - sums[i];
            
            if (leftsum == rightsum) return i;
        }
        
        return -1;
    }
}

public class PivotIndex
{
    public static void main(String[] args)
    {
        int arr[] = {-1,-1,-1,0,1,1};
        System.out.println(new Solution().pivotIndex(arr));
    }
    
}
