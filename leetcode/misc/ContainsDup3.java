// https://leetcode.com/problems/contains-duplicate-iii/
package containsdup3;
import java.util.*;

class Solution
{
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t)
    {
        if (t < 0) return false;
        
        if (nums.length < 2) return false;
        
        MultiMap<Integer, Integer> map = new MultiMap<>();
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], i);

        List<Integer> keys = map.getKeys(true);
        boolean found = false;
        
        for (int i = 0; i < keys.size(); i++)
        {
            List<Integer> row = map.getRow(keys.get(i));
            
            for (int j = i + 1; j < keys.size(); j++)
            {
                long ky = keys.get(j); ky -= keys.get(i);
                long ky2 = t;
                if (ky > ky2) break;
                List<Integer> nextrow = map.getRow(keys.get(j));
                row.addAll(nextrow);
            }
            
            Collections.sort(row);

            for (int j = 1; j < row.size(); j++)
            {
                int delta = row.get(j) - row.get(j-1);

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

public class ContainsDup3
{

    public static void main(String[] args)
    {
        // TODO code application logic here
    }
    
}
