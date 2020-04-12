// https://leetcode.com/contest/weekly-contest-184

package task1;
import java.util.*;

class Solution
{
    public int[] processQueries(int[] queries, int m)
    {
        int result[] = new int[queries.length];
        int count = 0;
        
        int perm[] = new int[m];
        for (int i = 0; i < m; i++)
            perm[i] = i + 1;
        
        for (int qr : queries)
        {
//            System.out.println(Arrays.toString(perm));
            
            int inx = findPos(perm, qr);
            result[count++] = inx;
            
            for (int j = inx; j > 0; j--)
                perm[j] = perm[j-1];
            
            perm[0] = qr;
        }

        return result;
    }

    private int findPos(int[] perm, int qr)
    {
        int res = 0;
        for (int n : perm)
        {
            if (n == qr) break;
            res++;
        }
        
        return res;
    }
}

public class Task1
{
    public static void main(String[] args)
    {
        int qr[] = {3, 1, 2, 1};

        Solution sl = new Solution();
        System.out.println(Arrays.toString(sl.processQueries(qr, 5)));
    }
    
}
