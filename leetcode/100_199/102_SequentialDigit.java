// https://leetcode.com/problems/sequential-digits/

package sequentialdigit;

import java.util.*;

interface Mathfunc
{
    long doIt(long arg);
}

class Solution
{
    public List<Integer> sequentialDigits(long low, long high)
    {
        if (low < 10 || high > 1000000000L)
            throw new IllegalArgumentException("bad param");
        
        Mathfunc numlen = (long num) ->
        {
            int count = 0;
            while (num > 0) { num /= 10; count ++; }
            return count;
        };

        Mathfunc starter = (long size) ->
        {
            long ans = 1; int cnt = 1;
            while (size > 1) { ans *= 10; cnt++; ans += cnt; size--; }
            return ans;
        };

        Mathfunc increment = (long size) ->
        {
            long ans = 1;
            while (size > 1) { ans *= 10; ans += 1; size--; }
            return ans;
        };
        
        int  size = (int) numlen.doIt(low);
        long curr = starter.doIt(size);
        long incr = increment.doIt(size);
        long limit = (long) Math.pow(10, size);
        
        List<Integer> ans = new ArrayList<>();
        while (curr <= high)
        {
            if (curr >= low) ans.add((int)curr);

            if (curr % 10 == 9)
            {
                limit *= 10;
                size++;
                curr = starter.doIt(size);
                incr = increment.doIt(size);
            }
            else
                curr += incr;
        }
        
        return ans;
    }

}

public class SequentialDigit
{
    public static void main(String[] args)
    {
        Solution obj = new Solution();
//        System.out.println(obj.sequentialDigits(100, 10000));
        System.out.println(obj.sequentialDigits(8511, 23553));
    }
    
}
