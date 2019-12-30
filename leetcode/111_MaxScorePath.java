/**
 * https://leetcode.com/problems/number-of-paths-with-max-score/
 * 
 * make top to bottom path, go down, right or diagon alley
 * design DP waypoints
 * make DP max selector 
 * 
 */

package maxscorepath;

import java.util.*;

class Solution
{
    public static final int MAXWAYS = 7 + (int) Math.pow(10, 9);
    
    public int[] pathsWithMaxScore(List<String> board)
    {
        int len = board.size();
        if ( len != board.get(0).length())
            throw new IllegalArgumentException("fix square");

        int[][] grid = converttoInt(board);
        
        WayPoint[] dp = new WayPoint[len];
        dp[0] = new WayPoint(0, 1);
        
        for (int j = 1; j < len; j++)
        {
            if (grid[0][j] < 0) break;
            dp[j] = new WayPoint(dp[j-1].score + grid[0][j], dp[j-1].numPaths);
        }
        
        WayPoint diagonJump = null;

        for (int i = 1; i < len; i++)
        {
            boolean pathFound = false;
            for (int j = 0; j < len; j++)
            {
                int cell = grid[i][j];

                if (cell < 0)
                {
                    diagonJump = dp[j];
                    dp[j] = null;
                    continue;
                }
                
                if (j == 0)
                {
                    if (dp[0] != null)
                    {
                        dp[0].addScore(cell);
                        pathFound = true;
                    }

                    diagonJump = null;
                    continue;
                }

                if (dp[j] == null && diagonJump != null)
                {
                    dp[j] = new WayPoint(diagonJump.score, diagonJump.numPaths);
                    dp[j].addScore(cell);
                    pathFound = true;
                    diagonJump = null;
                    continue;
                }
                
                if (dp[j] == null)
                {
                    if (dp[j-1] != null)
                    {
                        dp[j] = new WayPoint(dp[j-1].score, dp[j-1].numPaths);
                        dp[j].addScore(cell);
                        pathFound = true;
                    }
                    continue;
                }
                
                if (dp[j - 1] == null)
                {
                    dp[j].addScore(cell);
                    diagonJump = null;
                    pathFound = true;
                    continue;
                }
                
                // go down and left
                pathFound = true;
                if (dp[j - 1].score > dp[j].score)
                {
                    dp[j].copy(dp[j-1]);
                    dp[j].addScore(cell);
                }
                else if (dp[j - 1].score < dp[j].score)
                {
                    dp[j].addScore(cell);
                }
                else
                {
                    dp[j].addScore(cell);
                    dp[j].combinePaths(dp[j-1]);
                }
            }
            
            if (!pathFound) return new int[]{0,0};
//            System.out.println(Arrays.toString(dp));
            
        }

        return new int[] {dp[len - 1].score, dp[len - 1].numPaths};
    }    

    // flip
    private int[][] converttoInt(List<String> board)
    {
        int len = board.size();
        int[][] result = new int[len][len];
        for (int i = len - 1; i >= 0; i--)
        {
            int row = len - 1 - i;
            result[row] = new int[len];
            
            for (int j = len - 1; j >= 0; j--)
            {
                char c = board.get(i).charAt(j);
                int ix = len - 1 - j;
                
                switch(c)
                {
                    case 'E':
                    case 'S':
                        result[row][ix] = 0;
                        break;

                    case 'X':
                        result[row][ix] = -1;
                        break;
                        
                    default:
                        result[row][ix] = c - '0';
                        if (result[row][ix] < 0 || result[row][ix] > 9)
                            throw new IllegalArgumentException("fix cells");
                }
            }
        }
        
        return result;
    }

    private void print2D(int[][] arr)
    {
        for (int[] row : arr)
            System.out.println(Arrays.toString(row));
    }
    
}

// pkg it
class WayPoint
{
    int score;
    int numPaths;

    public WayPoint(int score, int num)
    {
        this.score = score;
        this.numPaths = num;
    }

    public void copy(WayPoint pt)
    {
        this.score = pt.score;
        this.numPaths = pt.numPaths;
    }

    public void addScore(int incr) { this.score += incr; }
    public void setPath(int num) { this.numPaths = num; }
    
    public void combinePaths(WayPoint pt)
    {
        this.numPaths = (this.numPaths + pt.numPaths) % Solution.MAXWAYS;
    }
    
    @Override
    public String toString() { return "[" + score + ", " + numPaths + "]"; }
}
