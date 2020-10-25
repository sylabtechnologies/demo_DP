package pathmineffort;
import java.util.*;

// https://leetcode.com/problems/path-with-minimum-effort/
/// binsearch w/ dfs

class Solution
{
    int minEff, m, n;
    final int dirs[][] = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    
    public int minimumEffortPath(int[][] heights)
    {
        m = heights.length;
        n = heights[0].length;
        
        int lo = 0, hi = Integer.MIN_VALUE;
        for (int[] height : heights)
        {
            for (int x : height)
                hi = Math.max(x,hi);
        }
        
        while (lo < hi)
        {
            minEff = lo + (hi-lo)/2;
            
            int test[][] = new int[m][n];
            floodfill(test, heights, minEff, heights[0][0], 0, 0);
            if (test[m-1][n-1] == 1)
                hi = minEff;
            else
                lo = minEff + 1;
        }
        
        return hi;
    }

    private void floodfill(int[][] test, int[][] heights, int limit, int prevVal, int Y, int X)
    {
        if (Y < 0 || Y >= m) return;
        if (X < 0 || X >= n) return;
        if (test[Y][X] == 1) return;
        if (Math.abs(heights[Y][X] - prevVal) > limit) return;
        
        test[Y][X] = 1;
        for (int[] d : dirs)
        {
            int nY = Y + d[0];
            int nX = X + d[1];
            floodfill(test, heights, limit, heights[Y][X], nY, nX);
        }
    }
}

public class PathMinEffort
{
    public static void main(String[] args)
    {
        int hh[][] = //  {{1,2,2}, {3,8,2}, {5,3,5}};
        {{8,3,2,5,2,10,7,1,8,9},
        {1,4,9,1,10,2,4,10,3,5},
        {4,10,10,3,6,1,3,9,8,8},
        {4,4,6,10,10,10,2,10,8,8},
        {9,10,2,4,1,2,2,6,5,7},
        {2,9,2,6,1,4,7,6,10,9},
        {8,8,2,10,8,2,3,9,5,3},
        {2,10,9,3,5,1,7,4,5,6},
        {2,3,9,2,5,10,2,7,1,8},
        {9,10,4,10,7,4,9,3,1,6}};
        
        System.out.println(new Solution().minimumEffortPath(hh));
    }
    
}
