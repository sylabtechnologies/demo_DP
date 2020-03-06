// https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/

package weakrows;
import java.util.*;

class Solution
{
    public static int[] kWeakestRows(int[][] mat, int k)
    {
        MultiMap freq = new MultiMap();
        
        int count = 0;
        for (int[] row : mat)
        {
            int next = 0;
            for (int i : row)
            {
                if (i == 1)
                    next++;
                else
                    break;
            }
            
            freq.put(next, count);
            count++;
        }
        
        List<Integer> ans = new ArrayList<>();
        List<Integer> iterSet = freq.getKeys();
        
        for (Integer key : iterSet)
        {
            if (k < 1) break;
            
            List<Integer> row = freq.getRow(key);
            
            int curr = 0;
            while (k >= 1 && curr < row.size())
            {
                ans.add(row.get(curr));
                k--;
                curr++;
            }
            
        }
        
        return MultiMap.listToInt(ans);
    }
}

public class WeakRows
{

    public static void main(String[] args)
    {
        int[][] mat = 
        {
            {1, 1, 0, 0, 0},
            {1, 1, 1, 1, 0},
            {1, 0, 0, 0, 0},
            {1, 1, 0, 0, 0},
            {1, 1, 1, 1, 1},
        };
        
        System.out.println(Arrays.toString(Solution.kWeakestRows(mat, 3)));
        
    }
    
}
