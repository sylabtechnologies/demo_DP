// https://leetcode.com/problems/reducing-dishes/

package deducedishes;

import java.util.Arrays;

class Solution
{
    public int maxSatisfaction(int[] satisfaction)
    {
        Arrays.sort(satisfaction);
        
        // count from top
        int topSum = 0, curr = 0, result = 0;
        int i = satisfaction.length - 1;
        while (i >= 0)
        {
            topSum += satisfaction[i];
            curr += topSum;
            result = Math.max(result, curr);
            
            i--;
        }
        
        return result;
    }
}

public class DeduceDishes
{
    public static void main(String[] args)
    {
        int satisfaction[] = {-1,-8,0,5,-9};
        Solution sl = new Solution();
        System.out.println(sl.maxSatisfaction(satisfaction));
    }
    
}
