// https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/

package ranknumbers;
import java.util.*;

class Solution
{
    public static int[] smallerNumbersThanCurrent(int[] nums)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        
        int i = 1, rank = 0;
        int curr = copy[0];
        map.put(curr, rank);
        
        while (i < copy.length)
        {
            if (copy[i] == curr)
            {
                i++; continue;
            }
            
            curr = copy[i];
            rank = i;
            map.put(curr, rank);
        }
        
//        System.out.println(map);
        
        int[] res = new int[nums.length];
        int count = 0;
        for (int n : nums)
            res[count++] = map.get(n);
               
        return res;
    }
}

public class RankNumbers
{

    public static void main(String[] args)
    {
        int [] arr = {8,1,2,2,3};
        System.out.println(Arrays.toString(Solution.smallerNumbersThanCurrent(arr)));
    }
    
}
