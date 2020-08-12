// https://leetcode.com/problems/maximum-subarray/
package maxsumcontiguous;

class Solution
{
    public int maxSubArray(final int[] numbers)
    {
        int bestSum = Integer.MIN_VALUE;
        int currSum = 0;
        
        for (int i = 0; i < numbers.length; i++)
        {
            if (currSum <= 0)
                currSum = numbers[i];
            else
                currSum += numbers[i];
            
            bestSum = Math.max(bestSum, currSum);
        }
            
        return bestSum;
    }
}

public class MaxSumContiguous
{
    public static void main(String[] args)
    {
        int arr[] = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new Solution().maxSubArray(arr));
    }
    
}

