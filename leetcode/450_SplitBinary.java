// https://leetcode.com/problems/number-of-ways-to-split-a-string/
package binsplit;
import java.util.*;

class Solution
{
    public int numWays(String s)
    {
        int count = 0, i = 0, len = s.length();
        int oneCount[] = new int[len];
        for (char c : s.toCharArray())
        {
            if (c == '1') count++;
            oneCount[i++] = count;
        }
        
        if (count % 3 != 0) return 0;
        int ans = 0, target = count / 3;

        if (count == 0)
        {
            if (len < 4) return 0;

            long tmp = 0;
            for (int j = 1; j <= len-2; j++)
            {
                int rest = len - j;
                tmp += rest - 1;
                if (tmp >= 1_000_000_007) tmp -= 1_000_000_007;
            }
        
            return (int) tmp;
        }
        
        int start = 0;
        while (oneCount[start] != target)
            start++;

        int stop3 = start + 1, stop1 = -1, stop2 = -1;
        while (oneCount[stop3] <= 2*target)
        {
            if (oneCount[stop3] != target && stop1 < 0)
                stop1 = stop3;
            
            if (oneCount[stop3] == 2*target && stop2 < 0)
                stop2 = stop3;

            stop3++;
        }
        
        int ways = stop3 - stop2;
        for (i = start; i < stop1; i++)
        {
             ans += ways;
             if (ans >= 1_000_000_007) ans = ans - 1_000_000_007;
       }
 
        return ans;
    }
}

public class BinSplit
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().numWays("10101"));
    }
}

