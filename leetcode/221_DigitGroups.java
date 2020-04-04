// https://leetcode.com/problems/count-largest-group/

package digitgroups;
import java.util.*;

class Solution
{
    public int countLargestGroup(int n)
    {
        HashMap<Integer, Integer> groups = new HashMap<>();
        
        int max = 0;
        for (int i = 1; i <= n; i++)
        {
            int key = sumDigits(i);
            int count = groups.getOrDefault(key, 0) + 1;
            groups.put(key, count);
            
            if (count > max) max = count;
        }
        
//        System.out.println(groups);
        
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : groups.entrySet())
        {
            if (entry.getValue() == max) ans++;
        }
        
        return ans;
    }

    private int sumDigits(int n)
    {
        int sum = 0;
        while (n > 0)
        {
            sum += n % 10; n /= 10;
            
        }
        
        return sum;
    }
}

public class DigitGroups
{
    public static void main(String[] args)
    {
        Solution sl = new Solution();
        System.out.println(sl.countLargestGroup(13));
    }

    
}
