// https://leetcode.com/problems/contains-duplicate-ii/

package containsdup;
import java.util.*;

class Solution
{
    public boolean containsNearbyDuplicate(int[] nums, int k)
    {
        if (nums.length < 2) return false;
        
        MultiMap<Integer, Integer> map = new MultiMap<>();
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], i);

        boolean found = false;
        List<Integer> keys = map.getKeys(false);
        for (Integer key : keys)
        {
            List<Integer> row = map.getRow(key);
            
            for (int i = 1; i < row.size(); i++)
            {
                int delta = row.get(i) - row.get(i-1);

                if (delta <= k)
                {
                    found = true;
                    return found;
                }
            }
        }

        return found;
    }
}

public class ContainsDup
{

    public static void main(String[] args)
    {
        Solution sl = new Solution();
        int arr[] = {1,0,1,1};
        System.out.println(sl.containsNearbyDuplicate(arr, 1));
    }
    
}
