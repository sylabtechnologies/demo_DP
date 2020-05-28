// https://leetcode.com/problems/contiguous-array/

package contig1;
import java.util.HashMap;

// find all equal prefix sums
class Solution
{
    public int findMaxLength(int[] nums)
    {
        int len = nums.length;
        for (int i = 0; i < len; i++)
        {
            if (nums[i] == 0) nums[i] = -1;
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        int prefixSum = 0, max = 0;
        for (int i = 0; i < len; i++)
        {
            prefixSum += nums[i];
            
            if (!map.containsKey(prefixSum))
                map.put(prefixSum, i);
            else
            {
                int start = map.get(prefixSum);
                max = Math.max(max, i - start);
            }
        }

        return max;
    }
}

public class Contig1
{
    public static void main(String[] args)
    {
        int arr[] = {0,1,0};
        System.out.println(new Solution().findMaxLength(arr));
    }
}
