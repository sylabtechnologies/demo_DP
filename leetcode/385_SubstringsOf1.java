// https://leetcode.com/problems/number-of-substrings-with-only-1s/

package con2;
import java.util.*;

class Solution
{
    private final static int MODL = 1_000_000_007;
    
    public int numSub(String s)
    {
        boolean allOnes = false;
        int curlen = 0;
        ArrayList<Integer> lens = new ArrayList<>();

        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == '1')
            {
                allOnes = true;
                curlen++;
            }
            else
            {
                if (curlen > 0) lens.add(curlen);
                curlen = 0;
                allOnes = false;
            }
        }
        if (curlen > 0) lens.add(curlen);

        long result = 0;
        for (Integer len : lens)
            result += arithProgr(len);

        return (int) (result % MODL);
    }

    private long arithProgr(long curlen)
    {
        long  res = curlen*(curlen+1);
        return (res / 2);
    }
}

public class Con2
{
    public static void main(String[] args)
    {
        String test = "1110001010101111000000001001";
        System.out.println(new Solution().numSub(test));
    }
}
