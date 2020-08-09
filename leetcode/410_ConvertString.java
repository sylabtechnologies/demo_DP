// https://leetcode.com/problems/can-convert-string-in-k-moves/

package convertstring;
import java.util.*;

class Solution
{
    public boolean canConvertString(String s, String t, int k)
    {
        if (s.length() != t.length()) return false;
        
        TreeMap<Integer, Integer> delta = new TreeMap<>();
        for (int i = 0; i < s.length(); i++)
        {
            int d;
            if (t.charAt(i) >= s.charAt(i))
                d = t.charAt(i) - s.charAt(i);
            else
                d = 1 + t.charAt(i) - 'a' + 'z' - s.charAt(i);

            if (d > 0)
            {
                int freq = delta.getOrDefault(d, 0);
                delta.put(d, freq + 1);
            }
        }
        
        int step = 0;
        while (!delta.isEmpty())
        {
            ArrayList<Integer> cleanup = new ArrayList<>();
            
            for (Map.Entry<Integer, Integer> entry : delta.entrySet())
            {
                int move = entry.getKey();
                if (step + move > k) return false;
                
                int val = entry.getValue();
                delta.put(move, val - 1);
                
                if (val == 1) cleanup.add(entry.getKey());
            }
            
            step += 26;
            
            for (Integer rem : cleanup)
                delta.remove(rem);
        }

        return true;
    }
}

public class ConvertString
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().canConvertString("atmtxzjkz", "tvbtjhvjd", 35));
    }
}