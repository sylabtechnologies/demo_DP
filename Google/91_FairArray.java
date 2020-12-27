package goog25;
import java.util.*;

// https://leetcode.com/problems/ways-to-make-a-fair-array/
// #S = current even

class Solution
{
    public int waysToMakeFair(int[] nums)
    {
        final int len = nums.length;
        if (len == 1) return 1;
        if (len < 3) return 0;
        
        int sums[] = new int[len];
        sums[0] = nums[0];
        sums[1]  = nums[1];
        
        int lastEven = 0, lastOdd = 1, total = nums[0] + nums[1];
        for (int i = 2; i < len; i++)
        {
            sums[i] = sums[i-2] + nums[i];
            total += nums[i];
            
            if (i % 2 == 0)
                lastEven = i;
            else
                lastOdd  = i;
            
        }
        
        int cnt = 0, evn = -1;

        // @0
        evn = sums[lastOdd];
        if ( evn == total - evn - nums[0]) cnt++;
        // @len-1
        evn = sums[len - 2];
        if ( evn == total - evn - nums[len-1]) cnt++;
        
        for (int i = 1; i < len-1; i++)
        {
            if (i % 2 == 0)
                evn = sums[lastOdd] - sums[i-1] + sums[i-2];
            else
                evn = sums[lastEven] - sums[i-1] + ((i > 1) ? sums[i-2] : 0);
            
            if ( evn == total - evn - nums[i]) cnt++;
        }
        
        return cnt;
    }
}

public class Goog25
{
    public static void main(String[] args)
    {
        int arr[]= {1, 1, 1, 1, 1};
        System.out.println(new Solution().waysToMakeFair(arr));
    }
}
