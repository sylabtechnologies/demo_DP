/*
    boolean solve(Node n) {
        if n is a goal node, return true

        foreach option O possible from n {
            if solve(O) succeeds, return true
        }
        return false
    }

For every element, you have 2 options. You may either include the element in
your subset or you will not include the element in your subset.
Make the call for both the cases.

*/

package testsubset;
import java.util.*;

class Solution
{
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> nums)
    {
        Collections.sort(nums);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<Integer>(), nums, 0);
        return result;
    }

    private void backtrack(ArrayList<ArrayList<Integer>> list, ArrayList<Integer> temp, ArrayList<Integer> nums, int start)
    {
        list.add(new ArrayList<>(temp));
        for (int i = start; i < nums.size(); i++)
        {
            temp.add(nums.get(i));
            backtrack(list, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
        }
        
    }
}

public class TestSubset
{
    public static void main(String[] args)
    {
        ArrayList<Integer> test = new ArrayList<>();
        test.addAll(Arrays.asList(1,2,3));
        System.out.println(new Solution().subsets(test));
    }
    
}
