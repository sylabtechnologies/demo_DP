// https://leetcode.com/problems/product-of-array-except-self/

package arrayproduct;

class Solution
{
    public int[] productExceptSelf(int[] nums)
    {
        int len = nums.length;
        int zeroCount = 0;
        int[] zeros = new int[len];
        int[] ans = new int[nums.length];
        
        int prod = 1;
        for (int i = 0; i < len; i++)
        {
            if (nums[i] == 0)
            {
                zeros[i] = 1;
                zeroCount++;
            }
            else prod *= nums[i];
        }
        
        if (zeroCount > 1) return ans;

        if (zeroCount == 1)
        {
            for (int i = 0; i < nums.length; i++)
            {
                if (zeros[i] == 1)
                    ans[i] = prod;
            }
        }
        else
        {
            for (int i = 0; i < nums.length; i++)
                ans[i] = prod/nums[i];
        }

        return ans;
    }
}

public class ArrayProduct {

    public static void main(String[] args)
    {
        // TODO code application logic here
    }
    
}
