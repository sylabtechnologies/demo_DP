// https://leetcode.com/problems/make-sum-divisible-by-p/
package bw19a;
import java.util.*;

class Solution
{
    public int minSubarray(int[] arr, int m)
    {
        int correction = 0, lln = arr.length;
        for (int i = 0; i < lln; i++)
        {
            correction += arr[i];
            correction = correction % m;
        }

        Map<Integer, Integer> lastIndex = new HashMap<>();
        lastIndex.put(0, -1);
        int curr = 0, minLen = Integer.MAX_VALUE;
        for (int i = 0; i < lln; i++)
        {
            curr += arr[i];
            curr = curr % m;
            lastIndex.put(curr, i);
            
            int find = (curr + m - correction) % m;
            minLen = Math.min(minLen, i - lastIndex.getOrDefault(find, - lln));
        }
        
        return (minLen < lln) ? minLen : -1;
    }
}

public class BW19A
{
    public static void main(String[] args)
    {
//        int arr[] = {3, 1, 4, 2};
//        int arr[] = {6,3,5,2};
        int arr[] = {4, 4, 2 };
        System.out.println(new Solution().minSubarray(arr, 7));
    }
    
}
