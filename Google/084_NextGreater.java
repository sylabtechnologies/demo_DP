package goog31;

// https://leetcode.com/problems/next-greater-element-iii/discuss/983076/Python-O(m)-solution-explained
import java.util.*;

class Solution
{
    public int nextGreaterElement(int n)
    {
        if (n <= 9) return -1;
        
        ArrayList<Integer> digs = splitDigits(n);
        
        // break
        int prev = digs.get(0), stop = -1;
        for (int i = 1; i < digs.size(); i++)
        {
            if (digs.get(i) < prev)
            {
                stop = i; break;
            }
            
            prev = digs.get(i);
        }
        
        if (stop == -1) return stop;
        
        
        ArrayList<Integer> next = new ArrayList<>();
        for (int i = 0; i <= stop; i++)
            next.add(digs.get(i));
        
        // swap
        int target = digs.get(stop), min = Integer.MAX_VALUE, mini = -1;
        for (int i = 0; i < stop; i++)
        {
            if (next.get(i) <= target) continue;
            
            if (next.get(i) < min)
            {
                mini = i;
                min = next.get(i);
            }
        }
        
        // glue
        Collections.swap(next, stop, mini);
        digs.set(stop, min);
        next.remove(stop);
        Collections.sort(next);
        Collections.reverse(next);

        for (int i = 0; i < stop; i++)
            digs.set(i, next.get(i));
            
        Collections.reverse(digs);
        return (int) comboDigits(digs);
    }

    private long comboDigits(ArrayList<Integer> digs)
    {
        long ret = 0;
        for (Integer d : digs)
        {
            ret *= 10;
            ret += d;
            
            if (ret > Integer.MAX_VALUE) return -1;
        }
        
        return ret;
    }

    private ArrayList<Integer> splitDigits(int n)
    {
        ArrayList<Integer> ret = new ArrayList<>();
        while (n > 0)
        {
            ret.add(n % 10);
            n = n / 10;
        }
        
        return ret;
    }
}

public class Goog31
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().nextGreaterElement(1999999999));
    }
    
}
