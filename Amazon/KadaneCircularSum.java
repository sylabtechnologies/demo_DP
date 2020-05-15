// https://leetcode.com/problems/maximum-sum-circular-subarray/
package circularsum;

class Solution
{
    public int maxSubarraySumCircular(int[] arr)
    {
        int normal = kadane(arr);
        int totalSum = total(arr);
        
        // flip it
        for (int i = 0; i < arr.length; i++)
            arr[i] = - arr[i];
        int flipped = kadane(arr);
        
        if (flipped + totalSum <= 0)
            return normal;
        else
            return Math.max(normal, totalSum + flipped);
    }
  
    // reset on neg
    private int kadane(int arr[])
    {
        int maxSoFar = Integer.MIN_VALUE;
        int maxHere = 0;
        
        for (int x : arr)
        {
            maxHere += x;
            if (maxSoFar < maxHere) maxSoFar = maxHere;
            if (maxHere < 0) maxHere = 0;
        }
        
        return maxSoFar;
    }

    private int total(int arr[])
    {
        int ans = 0;
        for (int x : arr)
            ans += x;
        
        return ans;
    }
}

public class CircularSum
{
    public static void main(String[] args)
    {
        int arr[] = {-2, -3, -1};
        System.out.println(new Solution().maxSubarraySumCircular(arr));
    }
    
}
