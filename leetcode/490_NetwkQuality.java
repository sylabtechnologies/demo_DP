package goog11;
import java.util.*;

// https://leetcode.com/problems/coordinate-with-maximum-network-quality/
class Solution
{
    public int[] bestCoordinate(int[][] towers, int radius)
    {
        double max = Integer.MIN_VALUE;
        int maxarr[] = null;
        for (int i = 0; i < towers.length; i++)
        {
            int x = towers[i][0];
            int y = towers[i][1];
            
            int qsum = 0;
            for (int j = 0; j < towers.length; j++)
            {
                int[] tower = towers[j];
                double dx = Math.abs(tower[0] - x);
                if (dx > radius) continue;
                double dy = Math.abs(tower[1] - y);
                if (dx > radius) continue;
                
                dx = dx*dx;
                dy = dy*dy;
                
                double dist = Math.sqrt(dx + dy);
                if (dist <= radius)
                    qsum += (int) (tower[2]/(dist + 1));
            }
        
            if (qsum > max)
            {
                max = qsum;
                maxarr = Arrays.copyOf(towers[i], 2);
            }
            else if (qsum == max)
            {
                if (towers[i][0] < maxarr[0])
                    maxarr = Arrays.copyOf(towers[i], 2);
                else if (towers[i][0] == maxarr[0] && towers[i][1] < maxarr[1])
                    maxarr = Arrays.copyOf(towers[i], 2);
            }
        }
        
        return maxarr;
    }
}