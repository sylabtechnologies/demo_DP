package goog51;
import java.util.*;

class Solution 
{
    public int maxEqualFreq(int[] nums) 
    {
        if (nums.length == 2) return 2;
        
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int x : nums) 
        {
            int fr = freq.getOrDefault(x, 0);
            freq.put(x, fr+1);
        }
        
        TreeMap<Integer, Integer> frfrq = new TreeMap<>();
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) 
        {
            int elem = entry.getKey();
            int fr   = entry.getValue();
            
            int occur  = frfrq.getOrDefault(fr, 0);
            frfrq.put(fr, occur+1);
        }
        
        for (int i = nums.length - 1; i>= 0; i--) 
        {
//            System.out.println(frfrq);
//            System.out.println(freq);
            
            if (valid(frfrq, freq)) return i + 1;
            
            int x = nums[i];
            int oldfr = freq.get(x);
            if (oldfr == 1) 
                freq.remove(x);
            else
                freq.put(x, oldfr - 1);
            
            int occur  = frfrq.get(oldfr);
            if (occur == 1) 
                frfrq.remove(oldfr);
            else
                frfrq.put(oldfr, occur-1);
            
            int newfr = oldfr - 1;
            if (newfr > 0) 
            {
                occur  = frfrq.getOrDefault(newfr, 0);
                frfrq.put(newfr, occur+1);
            }
        }

        return 0;
    }

    private boolean valid(TreeMap<Integer, Integer> frfreq, HashMap<Integer, Integer> freq) 
    {
        if (frfreq.size() > 2) return false;
        
        if (frfreq.size() == 1)
            return frfreq.firstKey() == 1 || freq.size() == 1;
        else
        {
            int one = frfreq.firstKey(), two = frfreq.lastKey();
            int min = Math.min(one, two);
            
            if (min == 1 && frfreq.get(min) == 1) return true;
            
            if (Math.abs(one - two) == 1 && frfreq.get(two) == 1)
                return true;
        }
        
        return false;
    }
}

