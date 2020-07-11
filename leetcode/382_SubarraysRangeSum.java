// https://leetcode.com/problems/range-sum-of-sorted-subarray-sums/

package con2;
import java.util.*;

class Solution
{
    int modl = 1_000_000_007;
    public int rangeSum(int[] nums, final int n, final int left, final int right)
    {
        ArrayList<Long> results = new ArrayList<>();
        for (int i = 0; i < n; i++)
        {
            for (int j = i + 1; j <= n; j++)
            {
                long sum = getSum(nums, i, j);
                results.add(sum);
            }
        }
        Collections.sort(results);
        
        long res = 0;
        for (int i = left - 1; i < right; i++)
        {
            res += results.get(i);
            if (res >= modl) res -= modl;
        }
        
        return (int) res;
    }
    
    long getSum(int arr[], int fro, int to)
    {
        long sum = 0;
        for (int i = fro; i < to; i++)
            sum += arr[i];
        return sum;
    }
}

public class Con2
{
    public static void main(String[] args)
    {
        int arr[]= {1,2,3,4};
        System.out.println(new Solution().rangeSum(arr, 4, 1, 5));
    }
}
