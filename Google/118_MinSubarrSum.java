package goog53;
import java.util.*;

// https://leetcode.com/submissions/detail/443118930/
class Solution 
{
    public int minSubArrayLen(int sum, int[] nums) 
    {
        final int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0] >= sum ? 1 : 0;
        
        int ret = Integer.MAX_VALUE;
        boolean found = false;
     
        int s = nums[0], lf = 0, rg = 0;
        if (s >= sum) return 1;
        
        while (rg < len && lf < len)
        {
            if (lf > rg)
            {
                s = nums[lf];
                rg = lf;
            }
            else
            {
                if (s < sum)
                {
                    if (rg == len - 1) break;
                    s += nums[++rg];
                }
                else
                    s -= nums[lf++];
            }

            if (s >= sum)
            {
                ret = Math.min(ret, rg - lf + 1);
                found = true;
            }
        }

        return (found) ? ret : 0;
    }
}

public class Goog53
{
    public static void main(String[] args)
    {
        int arr[] = {1,4,4};
        System.out.println(new Solution().minSubArrayLen(4, arr));
    }
}
