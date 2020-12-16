package goog27;

// https://leetcode.com/problems/stone-game/
class Solution
{
    private Integer memo[][];
    
    public boolean stoneGame(int[] piles)
    {
        memo = new Integer[501][501];
        return dfsDifference(piles, 0, piles.length - 1) > 0;
    }

    private int dfsDifference(int[] piles, int i, int j)
    {
        if (memo[i][j] != null)
            return memo[i][j];
        
        if (i == j) return piles[i];
        
        int a = piles[i] - dfsDifference(piles, i+1, j);
        int b = piles[j] - dfsDifference(piles, i, j-1);

        memo[i][j] = Math.max(a, b);
        return memo[i][j];
    }
}

public class Goog27
{
    public static void main(String[] args)
    {
        int stones[] = {5,3,4,5};
        System.out.println(new Solution().stoneGame(stones));
    }
}
