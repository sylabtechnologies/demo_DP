// https://leetcode.com/problems/combination-sum-iii/
package combo3;
import java.util.*;

class Solution
{
    static final int digits[] = {1,2,3,4,5,6,7,8,9};
    private int target;
    private int comboSize;
            
    public List<List<Integer>> combinationSum3(int k, int n)
    {
        comboSize = k; target = n;
        
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtrack(0, 0, temp, ret);
        
        return ret;
    }

    private void backtrack(int start, int sum, List<Integer> temp, List<List<Integer>> res)
    {
        if (temp.size() == comboSize)
        {
            if (sum == target) res.add(new ArrayList<>(temp));
            return;
        }
        
        for (int i = start; i < digits.length; i++)
        {
            sum += digits[i];
            if (sum > target) break;
            
            temp.add(digits[i]);
            backtrack(i + 1, sum, temp, res);
            temp.remove(temp.size() - 1);
            sum -= digits[i];
        }
    }
}

public class Combo
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().combinationSum3(3, 9));
    }
}
