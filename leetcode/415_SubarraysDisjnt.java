// https://leetcode.com/problems/maximum-number-of-non-overlapping-subarrays-with-sum-equals-target/

package subarraysdisjnt;
import java.util.*;

class Solution
{
    public int maxNonOverlapping(int[] nums, int target)
    {
        int currSum = 0, res = 0;
        HashSet<Integer> prevSum = new HashSet<>();
        for (int i = 0; i < nums.length; i++)
        {
            currSum += nums[i];
            
            if (currSum == target || prevSum.contains(currSum - target))
            {
                res++;
                prevSum.clear();
                currSum = 0;
            }
            else
                prevSum.add(currSum);
        }
        
        return res;
    }
}

public class SubarraysDisjnt
{
    public static void main(String[] args)
    {
        int arr[] = {-5,5,-4,5,4};
        System.out.println(new Solution().maxNonOverlapping(arr, 5));
    }
    
}
