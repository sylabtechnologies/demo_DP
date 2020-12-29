package goog38;
import java.util.*;

/**
 * https://leetcode.com/problems/where-will-the-ball-fall/
 */

class Solution 
{
    public int[] findBall(int[][] grid) 
    {

        final int nr = grid.length;
        final int nc = grid[0].length;
        int ret[] = new int[nc];
        if (nc == 1) { ret[0] = -1; return ret; }
                
        for (int start = 0; start < nc; start++)
        {
            int row = 0, col = start, dir = 0;

            while (row < nr) 
            {
                dir = grid[row][col];
                
                // find 2 identical dirs
                if (col + dir < 0 || col + dir >= nc) break;
                if (grid[row][col+dir] != dir) break;
                
                col += dir;
                row++;
            }
            
            ret[start] = (row == nr) ? col : -1;
        }
        
        return ret;
    }
}

public class Goog38
{
    public static void main(String[] args)
    {
        System.out.println(new Solution());
    }
}
