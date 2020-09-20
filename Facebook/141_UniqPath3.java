package robopaths;

// https://leetcode.com/problems/unique-paths-iii/
class Solution
{
    public int uniquePaths3(int[][] grid)
    {
        int startX = 0, startY = 0;
        int zeroCnt = 0;
        
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(grid[i][j] == 0)
                    zeroCnt += 1;
                else if(grid[i][j] == 1)
                {
                    startX = i;
                    startY = j;
                }
            }
        }
        
        return dfsPaths(grid, startX, startY, zeroCnt);
    }
    
    private int dfsPaths(int[][] grid, int x, int y, int zeroCnt)
    {
        if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == -1) 
            return 0;
        
        if(grid[x][y] == 2) 
            return zeroCnt == -1 ? 1 : 0; // we filled all steps
        
        // 2. we marked
        grid[x][y] = -1;
        zeroCnt -= 1;
        
        int pathCount = dfsPaths(grid, x + 1, y, zeroCnt)
            + dfsPaths(grid, x, y + 1, zeroCnt)
            + dfsPaths(grid, x - 1, y, zeroCnt)
            + dfsPaths(grid, x, y - 1, zeroCnt); 
        
        // + backtracked
        grid[x][y] = 0;
        zeroCnt += 1;
        
        return pathCount;
    }
}

public class RoboPaths
{
    public static void main(String[] args)
    {
        int grid[][] =  {{1,0,0,0}, {0,0,0,0}, {0,0,2,-1}};
        System.out.println(new Solution().uniquePaths3(grid));
    }
    
}
