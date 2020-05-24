// https://leetcode.com/problems/maximum-frequency-stack
package maxfreqstack;
import java.util.*;

/// #D = fragging the stack 2SPEX
class FreqStack
{
    List<LinkedList<Integer>> stacks;
    HashMap<Integer, Integer> freq;
    
    public FreqStack()
    {
        stacks = new ArrayList<>();
        freq = new HashMap<>();
    }

    public void push(int x)
    {
        Integer fr = freq.get(x);
        
        fr = (fr == null) ? 1 : fr + 1;
        freq.put(x, fr);
        
        if (stacks.size() < fr)
            stacks.add(new LinkedList<>());

        stacks.get(fr - 1).add(x);
    }
    
    public int pop()
    {
        if (stacks.isEmpty()) return Integer.MIN_VALUE;
            
        int top = stacks.size() - 1;
        int val = stacks.get(top).removeLast();
        
        if (stacks.get(top).isEmpty())
            stacks.remove(top);
        
        Integer fr = freq.get(val);
        if (fr == 1)
            freq.remove(val);
        else
            freq.put(val, fr - 1);
        
         return val;
   }
    
}
