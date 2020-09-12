// https://leetcode.com/problems/combination-sum-iii/
package combo3;
import java.util.*;

class Solution
{
    private int candidates[];
    private int target;
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target)
    {
        this.target = target;
        this.candidates = Arrays.copyOf(candidates, candidates.length);
        Arrays.sort(this.candidates);
        
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtrack(0, 0, temp, ret);
        
        return ret;
    }
    
    private void backtrack(int start, int sum, List<Integer> temp, List<List<Integer>> res)
    {
        if (sum == target)
        {
            if (!rowExists(res, temp))
                res.add(new ArrayList<>(temp));
            return;
        }
        
        for (int i = start; i < candidates.length; i++)
        {
            sum += candidates[i];
            if (sum > target) break;
            
            temp.add(candidates[i]);
            backtrack(i + 1, sum, temp, res);
            temp.remove(temp.size() - 1);
            sum -= candidates[i];
        }
    }

    private boolean rowExists(List<List<Integer>> mat, List<Integer> test)
    {
        for (List<Integer> row : mat)
        {
            if (row.equals(test)) return true;
        }
        
        return false;
    }
}

public class Combo
{
    public static void main(String[] args)
    {
        int candidates[] = {10,1,2,7,6,1,5};
        System.out.println(new Solution().combinationSum2(candidates, 8));
        
        int cand2[] = {2,5,1,2,2};
        System.out.println(new Solution().combinationSum2(cand2, 5));
        
    }
}
