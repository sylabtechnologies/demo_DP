package bulbs;
import java.util.*;

class Solution
{
    public int bulbs(ArrayList<Integer> target)
    {
        if (target.isEmpty()) return 0;
            
        int count = target.get(0) == 1 ? 0 : 1;
        
        for (int i = 1; i < target.size(); i++)
        {
            if (target.get(i) != target.get(i-1))
                count ++;
        }

        return count ;
    }
}

public class Bulbs
{
    public static void main(String[] args)
    {
        ArrayList<Integer> tar = new ArrayList<>(Arrays.asList( 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1));
        System.out.println(new Solution().bulbs(tar));
    }
    
}
