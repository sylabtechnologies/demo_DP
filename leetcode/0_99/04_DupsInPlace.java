/*

Given a sorted array nums, remove the duplicates in-place such that each element
appear only once and return the new length.

*/

package dupsinplace;
import java.util.*;

public class DupsInPlace
{
    public static int removeDuplicates(int[] nums)
    {
        if (nums.length < 2) return nums.length;

        int nondup = 0;
        int current = 1;
        
        while (current < nums.length)
        {
            if (nums[nondup] == nums[current])
            {
                current++;
                continue;
            }
            
            nondup++;
            nums[nondup] = nums[current];
            current++;
        }

        return nondup + 1;
    }
    
    public static void main(String[] args)
    {
        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        
        int len = removeDuplicates(arr);
        int[] ans = new int[len];
        System.arraycopy(arr, 0, ans, 0, len);
        System.out.println(Arrays.toString(ans));
        
    }
    
}
