package buddy;
import java.util.*;

class Solution
{
    public boolean buddyStrings(String a, String b)
    {
        if (a.length() != b.length() || a.length() < 2) return false;
        if (a.equals(b))
        {
            int fr[] = getFreq(a);
            for (int currFreq : fr)
            {
                if (currFreq > 1)
                    return true;
            }
            
            return false;
        }
        
        HashMap<Integer, Character> diff = new HashMap<>();
        int difcnt = 0;
        int keys[] = new int[2];
        for (int i = 0; i < a.length(); i++)
        {
            if (a.charAt(i) == b.charAt(i)) continue;
            
            if (difcnt >= 2) return false;
            keys[difcnt++] = i;
            
            diff.put(i, b.charAt(i));
        }
        
        if (diff.get(keys[0]) != a.charAt(keys[1]) || diff.get(keys[1]) != a.charAt(keys[0]))
            return false;
        else
            return true;
    }

    private int[] getFreq(String str)
    {
        int ret[] = new int[26];
        for (int i = 0; i < str.length(); i++)
        {
            char ch = str.charAt(i);
            ret[ch - 'a'] += 1;
        }
            
        return ret;
    }
}

public class Buddy
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().buddyStrings("abcd", "abcd"));
    }
}
