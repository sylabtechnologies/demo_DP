// https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/
package conseqnumbers;

import java.util.*;

// try 2 stack way?

class Solution
{
    public boolean isPossibleDivide(int[] nums, int k)
    {
        if (k < 1) return false;
        
        if (nums.length % k != 0) return false;
        
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> skip  = new Stack<>();
        for (int i = copy.length - 1; i >= 0; i--)
            stack.push(copy[i]);

        int curr = stack.pop();
        int mysize = 1;
        
        while (!stack.isEmpty())
        {
            int next = stack.pop();
            
            if (next == curr + 1)
            {
                mysize++;
                curr = next;
            }
            else if (next != curr)
                return false;
            else
                skip.push(next);
            
            if (mysize == k)
            {
                while (!skip.isEmpty())
                {
                    Integer i = skip.pop();
                    stack.push(i);
                }

                if (stack.isEmpty()) return true;
                
                curr = stack.pop();
                mysize = 1;
            }
        }
        
        return false;
    }
       
}