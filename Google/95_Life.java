// https://leetcode.com/problems/game-of-life/
package goog45;
import java.util.*;

class Solution 
{
    public void gameOfLife(int[][] board) 
    {
        final int m = board.length;
        final int n = board[0].length;
        int count[][] = new int[m][n];
        int dirs[] = {-1,0,1};
        
        for (int y = 0; y < m; y++) 
        {
            for (int x = 0; x < n; x++) 
            {
                for (int dy : dirs)
                {
                    for (int dx : dirs) 
                    {
                        if (dy == 0 && dx == 0) continue;
                        
                        int x1 = x + dx;                            
                        if (x1 < 0 || x1 > n - 1) continue;
                        
                        int y1 = y + dy;
                        if (y1 < 0 || y1 > m - 1) continue;
                        
                        count[y][x] += board[y1][x1];
                    }
                }
            }
        }

        for (int y = 0; y < m; y++) 
        {
            for (int x = 0; x < n; x++) 
            {
                // live
                if (board[y][x] == 1) 
                {
                    if (count[y][x] < 2) 
                        board[y][x] = 0;
                    else if (count[y][x] > 3) 
                        board[y][x] = 0;
                }
                else
                {
                    if (count[y][x] == 3) 
                        board[y][x] = 1;
                }
                
            }
        }
    }
}

public class Goog45
{
    public static void main(String[] args)
    {
        int board[][] = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        Solution sl = new Solution();
        
        sl.gameOfLife(board);
        for (int[] row : board) 
            System.out.println(Arrays.toString(row));
    }
}

/**
 * @author F. Ulstack
 */
