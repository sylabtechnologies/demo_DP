package goog8;
import java.util.*;

// https://leetcode.com/problems/paint-fence/
class Solution
{
    private int result = 0, dim = 0;
            
    public int numWays(int n, int k)
    {
        if (n == 0 || k == 0) return 0;
        
        dim = n;
        int colors[] = new int[k];
        for (int i = 0; i < colors.length; i++)
            colors[i] = i;
        
        backtrack(new LinkedList<Integer>(), colors);
        return result;
    }

    private void backtrack(LinkedList<Integer> temp, int[] colors)
    {
        if (temp.size() == dim)
        {
            System.out.println(temp);

            boolean row = false;
            int adjCnt = 0, prev = temp.get(0);
            for (int i = 1; i < temp.size(); i++)
            {
                Integer clr = temp.get(i);
                if (clr == prev)
                    adjCnt++;
                else
                    adjCnt = 0;
                
                if (adjCnt >= 2) row = true;
                prev = clr;
            }
            
            if (!row)
                result++;
            
            return;
        }
        
        for (int i = 0; i < colors.length; i++)
        {
            int nextc = colors[i];
            
            temp.addLast(nextc);
            backtrack(temp, colors);
            temp.removeLast();
        }
    }
}

public class Goog8
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().numWays(4, 2));
    }
    
}

