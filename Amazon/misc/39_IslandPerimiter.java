// https://leetcode.com/problems/island-perimeter/
package islandperimiter;

// mod fllod fill
class Solution
{
    private int ref[][];
    private int nrows, ncols, colorFrom, colorTo, perim;    
    
    public int islandPerimeter(int[][] grid)
    {
        nrows = grid.length;
        ncols = grid[0].length;

        colorFrom = 1;
        colorTo = 2;
        ref = grid;
        perim = 0;
        
        for (int i = 0; i < nrows; i++)
        {
            for (int j = 0; j < ncols; j++)
            {
                if (grid[i][j] == 1)
                {
                    helper(i, j);
                    return perim;
                }
            }
        }

        return 0;
    }

    private void helper(int sr, int sc)
    {
        if (sr < 0 || sr >= nrows) return;
        if (sc < 0 || sc >= ncols) return;
        
        // System.out.println("at " + sr + " " + sc);
        if (ref[sr][sc] == colorFrom)
            ref[sr][sc] = colorTo;
        else return;
        
        if (sr == 0) perim++;
        if (sr == nrows - 1) perim++;
        if (sc == 0) perim++;
        if (sc == ncols - 1) perim++;
        
        int cells[][] = {{sr - 1, sc}, {sr + 1, sc}, {sr, sc-1},{sr, sc+1}};
        
        for (int[] cell : cells)
        {
            int r = cell[0], c = cell[1];
            if (r < 0 || r >= nrows || c < 0 || c >= ncols) continue;
            if (ref[r][c] == 0) perim++;
            helper(r, c);
        }
    }
}

public class IslandPerimiter
{
    public static void main(String[] args)
    {
//        int grid[][] = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0},{1,1,0,0}};
        int grid[][] = {{1, 1}};

        System.out.println(new Solution().islandPerimeter(grid));  
    }
}
