// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

package disapp;
import java.util.*;

class Solution
{
    public List<Integer> findDisappearedNumbers (int[] nums)
    {
        for (int i = 0; i < nums.length; i++)
        {
            int pos = Math.abs (nums[i]) - 1;
            if (nums[pos] > 0)
                nums[pos] *= -1;
        }
        
        List<Integer> ans = new ArrayList <>();
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] > 0)
                ans.add(i + 1);
        }
        
        return ans;
    }
}

public class Disapp
{
    public static void main(String[] args)
    {
        int arr[] = {4,3,2,7,8,2,3,1};
                   //1 2 3 4 5 6 7 8
        System.out.println(new Solution().findDisappearedNumbers(arr));
    }
    
}
