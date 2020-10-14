package goog9;
import java.util.*;

class Solution
{
    public List<String> generateParenthesis(int n)
    {
        List<String> ret = new ArrayList();
        backtrack(ret, "", 0, 0, n);
        return ret;
    }

    private void backtrack(List<String> ret, String curr, int open, int close, final int max)
    {
        if (curr.length() == max*2)
        {
            ret.add(curr); return;
        }
        
        if (open < max )
            backtrack(ret, curr + "(", open + 1, close, max);

        // we match all versions
        if (close < open)
            backtrack(ret, curr + ")", open, close + 1, max);
    }
}

public class Goog9
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().generateParenthesis(4));
    }

    private static List<Integer> int2lst(int[] row)
    {
        List<Integer> ret = new ArrayList<>(row.length);
        for (int x : row) ret.add(x);
        return ret;
    }
    
}
