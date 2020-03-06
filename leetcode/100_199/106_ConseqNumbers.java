/*
Given an array of integers nums and a positive integer k,
find whether it's possible to divide this array into sets
of k consecutive numbers
Return True if its possible otherwise return False.
*/

package conseqnumbers;

import java.util.*;

public class Solution
{
    private int subsetSize;
    
    public boolean isPossibleDivide(int[] nums, int k)
    {
        if (k < 1) return false;
        
        if (nums.length % k != 0) return false;
        
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        
        LinkedList<Integer> test = new LinkedList<>();
        for (int n : copy)
            test.add(n);

        subsetSize = k;
        return myhelper(test);
        
    }

    private boolean myhelper(LinkedList<Integer> test)
    {
        if (test.isEmpty()) return false;
        
        Iterator<Integer> iter = test.iterator();
        int curr = iter.next();
        iter.remove();
        int mysize = 1;
        
        while (mysize < subsetSize)
        {
            // System.out.println(test);
            int next = iter.next();
            
            if (next == curr + 1)
            {
                iter.remove();
                curr = next;
                mysize++;
            }
            else if (next != curr) return false;
            
            if (!iter.hasNext())
            {
                if (mysize == subsetSize) return true;
                return false;
            }
            
        }
        
        return myhelper(test);
    }
    
}
