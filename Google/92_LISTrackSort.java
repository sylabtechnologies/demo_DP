package goog43;
import java.util.*;

// https://leetcode.com/problems/increasing-subsequences/

class Solution 
{
    public List<List<Integer>> findSubsequences(int[] nums) 
    {
        List<List<Integer>> ret = new ArrayList<>();
        
        for (int i = 0; i < nums.length - 1; i++) 
        {
            bktrack(ret, nums, new ArrayList<Integer>(), i);
        }
        
        if (ret.size() < 2) return ret;
        
        Comparator<List<Integer>> comp = new IntListComparator();
        Collections.sort(ret, comp);
        
        List<List<Integer>> uniq = new ArrayList<>();
            
        uniq.add(ret.get(0));
        int prev = 0;
        
        for (int i = 1; i < ret.size(); i++) 
        {
            List<Integer> cur = ret.get(i);
            
            if (comp.compare(uniq.get(prev), cur) != 0) 
            {
                uniq.add(cur); prev++;
            }
        }
        
        return uniq;
    }

    private void bktrack(List<List<Integer>> ret, int[] nums, ArrayList<Integer> temp, int curInd)
    {
        int curVal = nums[curInd];
        temp.add(curVal);
        
        if (temp.size() > 1) 
            ret.add(new ArrayList<>(temp));
        
        ArrayList<Integer> select = new ArrayList<>();
        for (int i = curInd+1; i < nums.length; i++)
        {
            if (curVal <= nums[i]) 
                select.add(i);
        }

        for (Integer ind : select) 
            bktrack(ret, nums, temp, ind);

        temp.remove(temp.size() - 1);
    }

    private static class IntListComparator implements Comparator<List<Integer>>
    {
        @Override
        public int compare(List<Integer> l1, List<Integer> l2) 
        {
            if (l1.size() != l2.size())
                return Integer.compare(l1.size(), l2.size());

            for (int i = 0; i < l1.size(); i++) 
            {
                if (l1.get(i) != l2.get(i))
                    return Integer.compare(l1.get(i), l2.get(i));
            }

            return 0;                
        }
    }
}

public class Goog43
{
    public static void main(String[] args)
    {
        int arr[] = {4, 3, 2, 1};
        System.out.println(new Solution().findSubsequences(arr));
    }
}

