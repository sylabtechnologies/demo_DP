package subarrlessk;
import java.util.*;

// R/D ZHardy-OR
class Solution
{
    int currProd;
    int currLimit;
    
    public int numSubarrayProductLessThanK(int[] nums, int k)
    {
        int len = nums.length;
        if (len == 0 || k < 2) return 0;
        
        // slide the window
        boolean restart = true;
        currProd = 1;
        int dp[] = new int[len];
        for (int i = 0; i < len; i++)
        {
            if (nums[i] >= k)
            {
                restart = true;
                continue;
            }
            
            if (restart)
            {
                restart = false;
                currProd = nums[i];
                dp[i] = 1;
                dp[i] += advance2limit(nums, i, k);
            }
            else
            {
                dp[i] = dp[i - 1] - 1;
                currProd /= nums[i - 1];
                dp[i] += advance2limit(nums, currLimit, k);
            }
        }
        
        int sum = 0;
        for (int n : dp) sum += n;
        return sum;
    }

    private int advance2limit(int[] nums, int i, int k)
    {
        int incr = 0;
        
        currLimit = i;
        while (currLimit < nums.length - 1)
        {
            int nextProd = currProd * nums[currLimit + 1];
            if (nextProd < k)
            {
                incr += 1;
                currProd = nextProd;
            }
            else break;

            currLimit++;
        }
        
        return incr;
    }
    
}

public class SubarrLessK
{
    public static void main(String[] args)
    {
         int arr[] = {10, 5, 2, 6};
         System.out.println(new Solution().numSubarrayProductLessThanK(arr, 100));
         
//        int arr[] = {1, 1, 1};
        
//        int arr[] = {6,8,6,6,10,8,10,3,7,7,4,9,3,1};
//        System.out.println(new Solution().numSubarrayProductLessThanK(arr, 121));
//        
//        int arr2[] = {3,10,10,7,6,3,10,1,4,10,8,10};
//        System.out.println(new Solution().numSubarrayProductLessThanK(arr2, 260));
        
    }
    
}