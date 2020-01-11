/**
 * adjacent pair of elements [a, b] = [nums[2*i], nums[2*i+1]] (with i >= 0). 
 * For each such pair, there are a elements with value b in the decompressed list
 */

package decompress;
import java.util.*;

class Solution
{
    public static int[] decompressRLElist(int[] nums)
    {
        int len = 0;
        for (int i = 0; i < nums.length; i+=2)
            len += nums[i];

        int[] res = new int[len];

        int start = 0;
        for (int i = 0; i < nums.length; i+=2)
        {
            for (int j = 0; j < nums[i]; j++)
            {
                res[start + j] = nums[i+1];
            }
            start += nums[i];
        }
        
        return res;
    }
}


public class Decompress
{

    public static void main(String[] args)
    {
        int [] nums = {1,2,3,4};
        
        System.out.println(Arrays.toString(Solution.decompressRLElist(nums)));
    }
   
}
