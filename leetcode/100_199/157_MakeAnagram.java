package makeanagram;
import java.util.*;

class Solution
{
    public static int minSteps(String s, String t)
    {
        HashMap<Character, Integer> freq1 = new HashMap<>();
        for (char c : s.toCharArray())
        {
            int f = freq1.getOrDefault(c, 0);
            freq1.put(c, f + 1);
        }            

        int count = 0;
        for (char c : t.toCharArray())
        {
            Integer fS = freq1.get(c);
            
            if (fS != null && fS > 0)
            {
                freq1.put(c, fS - 1);
                continue;
            }
            else count++;
        }
        
        return count;
    }
}


public class MakeAnagram
{

    public static void main(String[] args)
    {
        System.out.println(Solution.minSteps("xxyyzz", "xxyyzz"));
        System.out.println(Solution.minSteps("bab", "aab"));
        
    }
    
}
