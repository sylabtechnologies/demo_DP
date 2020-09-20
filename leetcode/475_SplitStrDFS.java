// https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings/
package w19a;
import java.util.*;

class Solution
{
    private HashSet<String> unik;
    
    public int maxUniqueSplit(String s)
    {
        unik = new HashSet<>();
        
        return help(s, 0);
    }

    private int help(String str, int start)
    {
        if (start >= str.length()) return 0;

        int ret = -1;
        for (int sz = 1; start + sz <= str.length(); sz++)
        {
            String next = str.substring(start, start + sz);
            
            if (!unik.contains(next))
            {
                unik.add(next);
                int nextRes = help(str, start + sz);
                if (nextRes >= 0)
                    ret = Math.max(ret, 1 + nextRes);
                unik.remove(next);
            }
        }
        
        return ret;
    }
}

public class W19A
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().maxUniqueSplit("ababccc"));
    }
}
