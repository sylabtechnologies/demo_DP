package goog9;
import java.util.*;

// https://leetcode.com/problems/coin-path/ cmp #198
class Solution
{
    public List<Integer> cheapestJump(int[] coins, int maxJump)
    {
        int dp[] = new int[coins.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = coins[0];
        
        HashMap<Integer, List<Integer>> paths = new HashMap<>();
        List<Integer> tmp = new ArrayList<>();
        tmp.add(1);
        paths.put(0, tmp);
        
        for (int i = 1; i < dp.length; i++)
        {
            if (coins[i] < 0) continue;

            List<Integer> best = null;
            for (int j = 1; j <= maxJump; j++)
            {
                int jumpFrom = i - j;
                if (i - j < 0 || coins[jumpFrom] < 0) continue;
                
                int dpnext = coins[i] + dp[i-j];
                if (dpnext < dp[i])
                {
                    dp[i] = dpnext;
                    best = paths.get(jumpFrom);
                }
                else if (dpnext == dp[i])
                {
                    List<Integer> cmp = paths.get(jumpFrom);
                    if (best == null || greaterThan(best, cmp)) best = cmp;
                }
            }
            
            if (best == null) continue;
            List<Integer> next = new ArrayList<>(best);
            next.add(i+1);
            paths.put(i, next);
        }
        
        List<Integer> ret = paths.get(coins.length-1);
        if (ret == null) ret = new ArrayList<>();
        return ret;
    }

    private boolean greaterThan(List<Integer> best, List<Integer> cmp)
    {
        int len = Math.min(best.size(), cmp.size());
        
        for (int i = 0; i < len; i++)
        {
            if (best.get(i) > cmp.get(i)) return true;
        }
        
        return best.size() < cmp.size();
    }
}
