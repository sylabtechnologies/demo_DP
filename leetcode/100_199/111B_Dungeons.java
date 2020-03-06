/**
 * https://leetcode.com/problems/dungeon-game/
 * 
 * do DP BACKWARDS
 * 
 */

package dungeongame;

import java.util.Arrays;

class Solution
{
    public int calculateMinimumHP(int[][] grid)
    {
        int numRows = grid.length;
        if (numRows == 0) return 0;
        int len  = grid[0].length;
        int[][] health = new int[numRows][len];

        health[numRows - 1][len - 1] = Math.max(1, 1 - grid[numRows - 1][len - 1]);
        for (int j = len - 2; j >= 0; j--)
            health[numRows - 1][j] = Math.max(1, health[numRows - 1][j + 1] - grid[numRows - 1][j]);
        
        for (int i = numRows - 2; i >= 0; i--)
        {
            health[i][len - 1] = Math.max(1, health[i + 1][len - 1] - grid[i][len - 1]);

            for (int j = len - 2; j >= 0; j--)
                health[i][j] = Math.max(1, Math.min(health[i + 1][j], health[i][j + 1]) - grid[i][j]);                
        }    

        return health[0][0];
    }
        
}
