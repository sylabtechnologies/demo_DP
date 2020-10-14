package goog10;
import java.util.*;

// https://leetcode.com/problems/missing-ranges/ ##SSTOK
class Solution
{
    public List<String> findMissingRanges(int[] nums, int lower, int upper)
    {
        ArrayList<Integer> diff = new ArrayList<>();
        if (nums.length == 0)
        {
            diff.add(lower);
            diff.add(upper);
            return print(diff);
        }
        
        int left = lower;
        for (int n : nums)
        {
            if (n > left)
            {
                diff.add(left);
                diff.add(n - 1);
            }
            
            left = n + 1;
        }
        
        if (left <= upper)
        {
            diff.add(left);
            diff.add(upper);
        }

        return print(diff);
    }

    private List<String> print(ArrayList<Integer> diff)
    {
        List<String> ret = new ArrayList<>();
        for (int i = 0; i < diff.size(); i += 2)
        {
            int beg = diff.get(i);
            int end = diff.get(i+1);
            
            if (beg == end)
                ret.add(Integer.toString(beg));
            else
                ret.add(Integer.toString(beg) + "->" + Integer.toString(end));
        }
        
        return ret;
    }
}
