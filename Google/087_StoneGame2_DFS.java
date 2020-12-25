package goog29;
import java.util.*;

// https://leetcode.com/problems/stone-game-ii/
// $S : p1 + p2 = total ; diff = p1 - p2 ; t + d = 2*p1
class Solution
{
    private Integer memo[][];
    private PrefixSum pfs;

    public int stoneGameII(int[] piles)
    {
        memo = new Integer[101][101];
        pfs = new PrefixSum(piles);
        
        int diff = dfs(piles, 0, 1);
        return (pfs.getSum(0, piles.length-1) + diff) / 2;
    }

    private int dfs(int[] piles, int start, int theM)
    {
        if (start == piles.length) return 0;
        if (start == piles.length-1) return piles[piles.length-1];
        
        if (memo[start][theM] != null)
            return memo[start][theM];

        int AliceBobDiff = Integer.MIN_VALUE;
        for (int take = 1; take <= theM*2 && start + take <= piles.length; take++)
        {
            int sum = pfs.getSum(start, start + take - 1);
            AliceBobDiff = Math.max(AliceBobDiff, sum - dfs(piles, start+take, Math.max(theM,take)));
        }
        
        memo[start][theM] = AliceBobDiff;
        return memo[start][theM];
    }
}

public class Goog29
{
    public static void main(String[] args)
    {
        int p[] = {6,4,2,8,1,8,6,6,2};
        System.out.println(new Solution().stoneGameII(p));
    }
}
