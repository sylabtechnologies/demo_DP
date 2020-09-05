// https://leetcode.com/problems/number-of-ways-to-split-a-string/
package binsplit;

import java.util.*;

class Solution
{
    public int numWays(String s)
    {
        char[] arr = s.toCharArray();
        int len = arr.length, count = 0;
        for (char c : arr)
            if (c == '1') count++;
        
        if (count % 3 != 0) return 0;

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
        
        int target = count / 3, target2 = target*2;
        int ways = 0, more = 0;
        count = 0;
        for (char c : arr)
        {
            if (c == '1') count++;

            if (count == target) ways++;
            
            if (count == target2)
                more++;
            
            if (count > target2) break;
        }
        
        long ans = ways * (long )more;
        return (int) (ans % 1_000_000_007);
    }
}

public class BinSplit
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().numWays("100100010100110"));
    }
}

