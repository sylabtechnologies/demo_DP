package goog10;
import java.util.*;

// https://leetcode.com/problems/best-meeting-point/ R/D X & Y
class Solution
{
    public int minTotalDistance(int[][] grid)
    {
        int projX[] = new int[grid[0].length];
        for (int j = 0; j < projX.length; j++)
        {
            int sum = 0;
            for (int i = 0; i < grid.length; i++)
                sum += grid[i][j];
            
            projX[j] = sum;
        }

        int minX = Integer.MAX_VALUE, xInd = -1;
        for (int j = 0; j < projX.length; j++)
        {
            int dist = 0;
            for (int k = 0; k < projX.length; k++)
            {
                if (j == k) continue;
                
                int weight = projX[k];
                if (weight > 0)
                    dist += weight*Math.abs(j - k);                
            }

            if (minX > dist)
            {
                minX = dist;
                xInd = j;
            }
        }
        
        int projY[] = new int[grid.length];
        for (int i = 0; i < projY.length; i++)
        {
            int sum = 0;
            for (int j = 0; j < grid[0].length; j++)
                sum += grid[i][j];
            
            projY[i] = sum;
        }

        int minY = Integer.MAX_VALUE, yInd = -1;
        for (int i = 0; i < projY.length; i++)
        {
            int dist = 0;
            for (int k = 0; k < projY.length; k++)
            {
                if (i == k) continue;
                
                int weight = projY[k];
                if (weight > 0)
                    dist += weight*Math.abs(i - k);
            }

            if (minY > dist)
            {
                minY = dist;
                yInd = i;
            }
        }

        int ret = 0;
        for (int i = 0; i < grid.length; i++)
        {
            int[] row = grid[i];
            for (int j = 0; j < row.length; j++)
            {
                if (row[j] > 0)
                    ret += Math.abs(i - yInd) + Math.abs(j - xInd);
            }
        }
        
        return ret;
    }
}

public class Goog10
{
    public static void main(String[] args)
    {
        int grid[][] = {
            {1,0,0,0,1},
            {0,0,0,0,0},
            {0,0,1,0,0},
        };
        System.out.println(new Solution().minTotalDistance(grid));
    }

    private static List<Integer> int2lst(int[] row)
    {
        List<Integer> ret = new ArrayList<>(row.length);
        for (int x : row) ret.add(x);
        return ret;
    }    
}


