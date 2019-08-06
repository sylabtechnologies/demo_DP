/*
greedy
https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/

*/

package maxsubarray;

public class MaxSubarray
{
    public static int maxSubArray(int[] nums)
    {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        
        int arrMax = Integer.MIN_VALUE;
        int maxHere = 0;
        int curr = 0;
       
        while (curr < nums.length)
        {
            maxHere += nums[curr];

            if (arrMax < maxHere)
                arrMax = maxHere;
            
            if (maxHere  < 0)
                maxHere = 0;

            curr++;
        }
        
        return arrMax;
        
    }
    
    public static void main(String[] args)
    {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        
        System.out.println(maxSubArray(arr));
        
    }
    
}
