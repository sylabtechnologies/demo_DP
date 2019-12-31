/**
 * https://leetcode.com/problems/dungeon-game/
 * 
 * move only right or down
 * 
 * wrap start&curr  = waypt
 * 
 * wrap health required
 * 
 */

package dungeongame;

import java.util.Arrays;

class Solution
{
    public int calculateMinimumHP(int[][] grid)
        {
            int len  = grid[0].length;
            int numRows = grid.length;

            HealhPoint[] h = new HealhPoint[len];

            if (grid[0][0] >= 0)
                h[0] = new HealhPoint(1, 1 + grid[0][0]);
            else
                h[0] = new HealhPoint(-grid[0][0] + 1, 1);

            for (int j = 1; j < len; j++)
            {
                int cell = grid[0][j];
                int req = h[j-1].healthReq(cell);

                if (req < 0)
                    h[j] = new HealhPoint(h[j-1].start, h[j-1].current + cell);
                else
                    h[j] = new HealhPoint(req,  1);
            }

    //        System.out.println(Arrays.toString(h));

            for (int i = 1; i < numRows; i++)
            {
                for (int j = 0; j < len; j++)
                {
                    int prev;
                    if (j == 0)
                        prev = 0;
                    else
                    {
                        if (i == numRows - 1 && j == len - 1)
                        {
                            if (h[j-1].start < h[j].start)
                                prev = j - 1;
                            else
                                prev = j;
                        }
                        else
                        {
                            if (h[j-1].current > h[j].current)
                                prev = j - 1;
                            else if (h[j-1].current < h[j].current)
                                prev = j;
                            else
                            {
                                if (h[j-1].start < h[j].start)
                                    prev = j - 1;
                                else
                                    prev = j;
                            }
                        }
                    }

                    int cell = grid[i][j];
                    int req = h[prev].healthReq(cell);

                    if (req < 0)
                        h[j].set(h[prev].start, h[prev].current + cell);
                    else
                        h[j].set(req,  1);
                }

    //            System.out.println(Arrays.toString(h));
            }

            return h[len - 1].start;
        }    

    private static class HealhPoint
    {
        int start;
        int current;

        public HealhPoint(int start, int current)
        {
            this.start = start;
            this.current = current;
        }
        
        public void set(int start, int current)
        {
            this.start = start;
            this.current = current;
        }

        public int healthReq(int cell)
        {
            if (current + cell >= 1)
                return -1;
            else
                return start + 1 - current - cell;
        }
        
        
        @Override
        public String toString() { return "[" + start + ", " + current + "]";}
    }
}
