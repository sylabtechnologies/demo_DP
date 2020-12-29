package goog43;
import java.util.*;

/**
 * https://leetcode.com/problems/maximum-length-of-pair-chain/
 */

class Solution 
{
    public int findLongestChain(int[][] pairs) 
    {
        final int len = pairs.length;
        if (len == 1) return 1;
        
        Arrays.sort(pairs, new Comparator<int[]>() 
        {
            @Override
            public int compare(int[] a, int[] b) 
            {
                if (a[1] != b[1])
                    return Integer.compare(a[1], b[1]);
                else
                    return Integer.compare(a[0], b[0]);
            }
        } );
        
        int dp[] = new int[len], max = 1;
        Arrays.fill(dp, 1);
        
        for (int i = 1; i < dp.length; i++)
        {
            int beg = pairs[i][0];
            int end = pairs[i][1];
            
            int j = i - 1; boolean found = false;
            while (j >= 0)
            {
                if (pairs[j][1] < beg)
                {
                    found = true;
                    break;
                }
                
                j--;
            }
            
            if (!found) continue;
            
            while (j >= 0)
            {
                dp[i] = Math.max(dp[i], dp[j--] + 1);
                max = Math.max(max, dp[i]);
            }
        }
        
        return max;
    }
}

public class Goog43
{
    public static void main(String[] args)
    {
//        int pairs[][] = {{1,2},{2,3},{3,4}} ;

        int pairs[][] = {{7,9},{4,5},{7,9},{-7,-1},{0,10},{3,10},{3,6},{2,3}};
        System.out.println(new Solution().findLongestChain(pairs));
    }
}

