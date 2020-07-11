// https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/

package con3;
import java.util.*;

class Solution  // 1&2
{
    public int minDifference(int[] nums)
    {
        int len = nums.length;
        if (len < 5) return 0;
        
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= 3; i++)
        {
            int diff = nums[len - (4 - i)] - nums[i];
            min = Math.min(min, diff);
        }
        
        return min;
    }
}

public class Con3
{
    public static void main(String[] args)
    {
        int arr[]=  {0, 1, 5, 10, 14}; // {6,6,0,1,1,4,6};
        System.out.println(new Solution().minDifference(arr));
    }
}
