package maxproduct;

class Solution
{
    public int maxProduct(int[] nums)
    {
        int[] localMax = new int[nums.length];
        int[] localMin = new int[nums.length];
        
        localMax[0] = localMin[0] = nums[0];
        int result = nums[0];
        
        for(int i = 1; i < nums.length; i++)
        {
            if (nums[i] > 0)
            {
                localMax[i]=Math.max(nums[i], localMax[i-1]*nums[i]);
                localMin[i]=Math.min(nums[i], localMin[i-1]*nums[i]);
            }
            else
            {
                localMax[i]=Math.max(nums[i], localMin[i-1]*nums[i]);
                localMin[i]=Math.min(nums[i], localMax[i-1]*nums[i]);
            }
            
            result = Math.max(result, localMax[i]);
        }
        
        return result;
    }
}

public class MaxProduct
{

    public static void main(String[] args)
    {
        int arr[] = {2, 3, -2, 4};
        System.out.println(new Solution().maxProduct(arr));
    }
    
}
