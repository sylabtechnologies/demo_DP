/** 166W
 * Given an integer number n, return the difference between the product of its digits and the sum of its digits.
 */
package productsum;

import java.util.ArrayList;

class Solution
{
    public int subtractProductAndSum(int n)
    {
        int[] digits = getDigits(n);
        
        int sum = 0;
        int prod = 1;
        for (int i = 0; i < digits.length; i++)
        {
            sum += digits[i];
            prod *= digits[i];
        }
        
        return prod - sum;
    }
    
    // 1 <= n <= 10^5
    private int[] getDigits(int n)
    {
        int[] buffer = new int[10];
        
        int count = 0;
        
        while (n > 0)
        {
            int dig = n % 10;
            buffer[count] = dig;
            n = n/10;
            count++;
        }
        
        int[] ans = new int[count];
        for (int i = 0; i < count; i++)
            ans[count - 1 - i] = buffer[i];
                
        return ans;
    }
}

public class ProductSum
{

    public static void main(String[] args)
    {
        Solution obj = new Solution();
        
        System.out.println(obj.subtractProductAndSum(4421));
        
    }
    
}
