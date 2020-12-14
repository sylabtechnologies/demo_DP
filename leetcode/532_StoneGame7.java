package goog27;
import java.util.*;

// https://leetcode.com/problems/stone-game-vii/
// full bin dfs

class Solution
{
    private int dp[][];
        
    public int stoneGameVII(int[] stones)
    {
        int sum = 0;
        for (int stone : stones) sum += stone;
        
        dp = new int[1001][1001];
        return dfs(stones, 0, stones.length - 1, sum);
    }

    private int dfs(int[] s, int i, int j, int sum)
    {
        if (i == j) return 0;
        if (dp[i][j] == 0)
            dp[i][j] = Math.max(sum - s[i] - dfs(s, i+1, j, sum - s[i]),
                sum - s[j] - dfs(s, i, j-1, sum - s[j]));
        
        return dp[i][j];
    }
}

public class Goog27
{
    public static void main(String[] args)
    {
        int arr[] = {7,90,5,1,100,10,10,2};
        System.out.println(new Solution().stoneGameVII(arr));
    }
}
