// https://leetcode.com/problems/can-convert-string-in-k-moves/

package convert;
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
        
//        System.out.println(delta);

        int step = 0;
        while (!delta.isEmpty())
        {
            TreeSet<Integer> cleanup = new TreeSet<>();
            
            for (Map.Entry<Integer, Integer> entry : delta.entrySet())
            {
                int move = entry.getKey();
                if (step + move > k) return false;
                
                int val = entry.getValue();
                delta.put(move, val - 1);
                
                if (val == 1) cleanup.add(entry.getKey());
            }
            
            step += 26;
            
            for (Integer cl : cleanup)
                delta.remove(cl);
        }

        return true;
    }
}

public class Convert
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().canConvertString("atmtxzjkz", "tvbtjhvjd", 35));
    }
    
}
