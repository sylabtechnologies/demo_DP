// https://leetcode.com/problems/create-target-array-in-the-given-order/
/// // TO MAINTAIN:

package givenorder;
import java.util.*;

class Solution
{
    public int[] createTargetArray(int[] nums, int[] index)
    {
        LinkedList<Integer> target = new LinkedList<>();
        
        for (int i = 0; i < nums.length; i++)
        {
            int ind = index[i];
            target.add(ind, nums[i]);
        }
        
        System.out.println(target);
        
        int[] res = new int[target.size()];
        int count = 0;
        for (int i : target)
            res[count++] = i;
        
        prna(res);
        
        return res;
    }

    private void prna(int[] nums)
    {
        System.out.println(Arrays.toString(nums));
    }
    
}

public class GivenOrder
{

    public static void main(String[] args)
    {
        Solution sl = new Solution();
        
        int[] nums = {0, 1, 2, 3, 4};
        int[] ind  = {0, 1, 2, 2, 1};
        sl.createTargetArray(nums, ind);
    }
    
}
