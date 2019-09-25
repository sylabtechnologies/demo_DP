// https://leetcode.com/problems/minimum-path-sum/

// do DP on each row

package minpathsum;

public class MinPathSum
{
    public static void main(String[] args)
    {
        
        int[][] grid = { {1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        
        Solution obj = new Solution();
        System.out.println(obj.minPathSum(grid));
        
    }
    
}

class Solution
{
    public int minPathSum(int[][] grid)
    {
        if (grid == null) return 0;
        
        int m = grid.length;
        if (m == 0) return 0;
        
        int n = grid[0].length;
        if (n == 0) return 0;
        
        int[] dp = new int[n];
        dp[0] = grid[0][0];
        for (int i = 1; i < n; i++)
            dp[i] = dp[i-1] + grid[0][i];
        
        for (int i = 1; i < m; i++)
        {
            // compare 2 paths for next row cells
            dp[0] = dp[0] + grid[i][0];
            for (int j = 1; j < n; j++)
            {
                if (dp[j-1] + grid[i][j] < dp[j] + grid[i][j])
                    dp[j] = dp[j-1] + grid[i][j];
                else
                    dp[j] = dp[j] + grid[i][j];
            }
            
        }
        
        return dp[n-1];
    }
}
