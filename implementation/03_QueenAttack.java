/**
 * https://www.hackerrank.com/challenges/queens-attack-2/problem
 * 
 * encap direction and set to null in invalid
 * 
 */
package queenattack;
import java.util.ArrayList;

class Direction
{
    String name = null;
    int deltaX;
    int deltaY;
    Direction(String n, int x, int y)
    {
        name = n;
        deltaX = x;
        deltaY = y;
    }
}

public class QueenAttack
{
    
    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles)
    {
        int[][] board = new int[n][n];
        
        // placing obstacles, get all to zero base
        for (int i = 0; i < k; i++)
        {
            int row = obstacles[i][0] - 1;
            int col = obstacles[i][1] - 1;
            board[row][col] = 1;
        }

        ArrayList<Direction> dir = new ArrayList<>();
        dir.add(new Direction("up", 0, 1));
        dir.add(new Direction("upright", 1, 1));
        dir.add(new Direction("right", 1, 0));
        dir.add(new Direction("downright", 1, -1));
        dir.add(new Direction("down", 0, -1));
        dir.add(new Direction("downleft", -1, -1));
        dir.add(new Direction("left", -1, 0));
        dir.add(new Direction("upleft", -1, 1));
        
        int count = 0;
        r_q--;
        c_q--;
        
        for (int delta = 1; delta < n + 1; delta++)
        {
            for (Direction d : dir)
            {
                if (d.name == null) continue;

                int x = c_q + delta*d.deltaX;
                if (x < 0 || x >= n)
                {
                    d.name = null;
                    continue;
                }
                
                int y = r_q + delta*d.deltaY;
                if (y < 0 || y >= n)
                {
                    d.name = null;
                    continue;
                }
                
                if (board != null)
                {
                    if (board[y][x] == 1)
                    {
                        d.name = null;
                        continue;
                    }
                }
                
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args)
    {
        int ans = queensAttack(4, 0, 4, 4, null);
        
        System.out.println(ans);
    }
    
}
