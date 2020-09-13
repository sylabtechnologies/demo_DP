// https://leetcode.com/problems/range-addition-ii/
package xmat;
import java.util.*;

class Solution
{
    public int maxCount(int m, int n, int[][] ops)
    {
        int horiz[] = new int[n];
        int vertl[] = new int[m];
        
        int max = 0;
        for (int[] op : ops)
        {
            for (int i = 0; i < op[0]; i++)
            {
                vertl[i]++;
                if (vertl[i] > max) max = vertl[i];
            }
            
            for (int i = 0; i < op[1]; i++)
                horiz[i]++;
        }
        
        int cnt1 = 0, cnt2 = 0;
        for (int v : vertl)
            if (v == max) cnt1++;
        for (int h : horiz)
            if (h == max) cnt2++;
        
        return cnt1*cnt2;
    }
}

public class Xmat
{
    public static void main(String[] args)
    {
        int ops[][] = {{2,2}, {3,3}};
        System.out.println(new Solution().maxCount(3, 3, ops));
    }
    
}
