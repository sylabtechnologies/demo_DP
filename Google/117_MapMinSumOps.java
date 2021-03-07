package goog51;
import java.util.*;

// https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
// #S - prefix hash map. or slide-window to find max array S - X

class Solution 
{
    public int minOperations(int[] nums, int x) 
    {
        final int len = nums.length;
        if (len == 1) return nums[0] == x ? 1 : -1;
        if (nums[0] == x || nums[len-1] == x) return 1;
        
        HashMap<Integer, Integer> sumMap = new HashMap<>();

        int s = 0;
        int ret = Integer.MAX_VALUE;
        boolean found = false;
        for (int i = 0; i < len; i++) 
        {
            s += nums[i];
            sumMap.put(s, i+1);

            if (s == x && !found)
            {
                ret = i + 1;
                found = true;
            }
        }
        
        s = 0;
        int cnt = 0;
        for (int i = len-1; i >= 0; i--) 
        {
            s += nums[i];
            cnt++;

            if (s == x)
            {
                ret = Math.min(ret, cnt);
                found = true;
            }
            
            Integer test = sumMap.get(x - s);
            if (test != null && test < i)
            {
                ret = Math.min(ret, cnt + test);
                found = true;
            }
        }

        return (found) ? ret : -1;
    }
}

public class Goog51
{
    public static void main(String[] args)
    {
        int arr[] = {5,1,4,2,3};
        System.out.println(new Solution().minOperations(arr, 6));
    }
}

/*

convert to base check it is 1 1 1

try bin search from 2 to N : SEARCH MAX 61 DIGITS W/ RADIX 2

https://leetcode.com/problems/smallest-good-base/discuss/936793/C%2B%2B-or-Binary-Search-Solution-with-explanation
 
 */
