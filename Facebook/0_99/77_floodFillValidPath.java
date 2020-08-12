// https://www.interviewbit.com/problems/valid-path/
package validpath;
import java.util.Arrays;

class Solution
{
    private int mat[][];
    
    public String solve(int endX, int endY, int numCircles, int radius, int[] cX, int[] cY)
    {
        mat = new int[endY + 1][];
        for (int i = 0; i < mat.length; i++)
            mat[i] = new int[endX + 1];
        
        // draw circles
        for (int i = 0; i < numCircles; i++)
        {
            int centX = cX[i];
            int centY = cY[i];
            
            for (int x = centX - radius; x <= centX + radius; x++)
            {
                if (x < 0 || x > endX) continue;
                
                for (int y = centY - radius; y <= centY + radius; y++)
                {
                    if (y < 0 || y > endY) continue;
                    
                    int d1 = centX - x, d2 = centY - y;
                    double rad = Math.sqrt(d1*d1 + d2*d2);
                    if (rad <= radius)
                        mat[y][x] = 1;
                }
            }
        }

        floodFill(0, 0);
        return mat[endY][endX] == 2 ? "YES" : "NO";
    }

   private void floodFill(int sr, int sc)
    {
        if (sr < 0 || sr >= mat.length) return;
        if (sc < 0 || sc >= mat[0].length) return;
        
        if (mat[sr][sc] == 0)
            mat[sr][sc] = 2;
        else
            return;
        
        floodFill(sr-1, sc);
        floodFill(sr+1, sc);
        floodFill(sr, sc-1);
        floodFill(sr, sc+1);
        
        floodFill(sr-1, sc-1);
        floodFill(sr+1, sc+1);
        floodFill(sr+1, sc-1);
        floodFill(sr-1, sc+1);
    }

    private void print2D(int[][] mat)
    {
        for (int[] row : mat)
            System.out.println(Arrays.toString(row));
    }
}

public class ValidPath
{
    public static void main(String[] args)
    {
        int x[] = {2}, y[] = {3};
        System.out.println(new Solution().solve(2, 3, 1, 1, x, y));
    }
    
}
