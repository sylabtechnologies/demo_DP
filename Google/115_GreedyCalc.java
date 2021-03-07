package goog52;
import java.util.*;

// greedy x2 jump 
class Solution 
{
    public int brokenCalc(int x, int y) 
    {
        int ops = 0;
        while (x != y)
        {
            if (x > y) 
                y++;
            else
            {
                if (y % 2 == 0) 
                    y = y / 2;
                else
                    y++;
            }
            
            ops++;
        }
        
        return ops;
    }
}

public class Goog52
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().brokenCalc(1024, 1));
    }
}
