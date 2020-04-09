// https://leetcode.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/

package reducebinto1;
import java.util.*;

class Solution
{
    public int numSteps(String s)
    {
        LinkedList<Integer> bin = new LinkedList<>();
        
        for (char c : s.toCharArray())
        {
            if (c == '0')
                bin.add(0);
            else
                bin.add(1);
        }
        
        int steps = 0;
        while (bin.size() > 1) 
        {
//            System.out.println(bin);
            
            if (bin.getLast() == 0)
                bin.removeLast();
            else
                addOne(bin);
            
            steps++;
        }
        
        return steps++;
    }

    private void addOne(LinkedList<Integer> bin)
    {
        int carry = 0, i = bin.size() - 1;
        int lastElem = bin.getLast() + 1;
        bin.set(i, lastElem);
        
        while (i >= 0)
        {
            int r = bin.get(i);
            switch(r)
            {
                case 0:
                    r += carry; carry = 0; break;
                case 1:
                    if (carry == 0)
                    {
                        r += carry; carry = 0;
                    }
                    else
                    {
                        r = 0;
                    }
                    break;
                case 2:
                    if (carry == 0)
                    {
                        r = 0; carry = 1;
                    }
                    else
                    {
                        r = carry; r = 1;
                    }
                    break;
                default:
                    throw new IllegalArgumentException("bad binary");                
            }
            
            bin.set(i, r);
            i--;
        }
        
        if (carry != 0)
        {
            bin.addFirst(carry);
        }
    }
}

public class ReduceBinTo1
{
    public static void main(String[] args)
    {
        Solution sl = new Solution();
        System.out.println(sl.numSteps("10"));
    }
    
}
