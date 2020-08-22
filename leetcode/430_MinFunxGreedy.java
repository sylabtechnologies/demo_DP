// https://leetcode.com/problems/minimum-numbers-of-function-calls-to-make-target-array/
package bbwk1;
import java.util.*;

class Solution
{
    public int minOperations(int[] nums)
    {
        int opCount = 0;
        boolean unsolved = true;
        
        while (unsolved)
        {
            int numOdd = 0;
            int numPos = 0;
            for (int i = 0; i < nums.length; i++)
            {
                int num = nums[i];
                if (num > 0)
                {
                    numPos++;
                    if (num % 2 == 1)
                    {
                        numOdd++;
                        opCount++;
                        nums[i]--;
                    }
                }
            }
            
            if (numPos == 0)
                unsolved = false;
            else
            {
                if (numOdd == 0)
                {
                    opCount++;
                    for (int i = 0; i < nums.length; i++)
                        nums[i] /= 2;
                }
            }
        }

        return opCount;
    }
}

public class BBwk1
{
    public static void main(String[] args)
    {
        int nums[] = {1, 5 };
        
        System.out.println(new Solution().minOperations(nums));  
    }
    
}
