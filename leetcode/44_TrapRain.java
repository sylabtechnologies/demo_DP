/* https://leetcode.com/problems/trapping-rain-water/
 * Given n non-negative integers representing an elevation map where the
 * width of each bar is 1, compute how much water it is able
 * to trap after raining.
 */

package traprain;

import java.util.*;

class RainInterval
{
    private int start;
    private int end;        // implement noninclusive

    public RainInterval(int begins)
    {
        start = begins;
        end  = begins + 1;
    }

    public int starts()
    {
        return start;
    }

    public int upto()
    {
        return end;
    }

    public void setEnd(int end)
    {
        this.end = end + 1;
    }

    public void setStart(int start)
    {
        this.start = start;
    }
}

class Solution
{
    public int trap(int[] height)
    {
        if (height.length < 3) return 0; // never?

        // calc total volume
        int wallsIntegral = 0;
        int min = Integer.MAX_VALUE;
        int max = height[0];
        int count = 0;
        
        HashMap<Integer, RainInterval> thisLevel = new HashMap<>();
        
        for (int i = 0; i < height.length; i++)
        {
            int h = height[i];
            if (h == 0) continue;

            wallsIntegral += h;
            if (h < min) min = h;
            if (h > max) max = h;
            
            RainInterval level = thisLevel.get(h);
            if (level == null)
            {
                RainInterval elem = new RainInterval(i);
                thisLevel.put(h, elem);
            }
            else
            {
                level.setEnd(i);
            }
            
            count++;
        }
        
        if (count == 0) return 0;
        
        // calc volume w/ water
        int waterIntegral = 0;
        RainInterval maxInterval = null;
        for (int i = max; i >= min; i--)
        {
            RainInterval level = thisLevel.get(i);
            if (level == null) continue;
            
            if (maxInterval == null)
            {
                maxInterval = level;
                waterIntegral += i*(maxInterval.upto()- maxInterval.starts());
            }
            else
            {
                int delta = maxInterval.starts() - level.starts();
                if (delta > 0)
                {
                    waterIntegral += i*delta;
                    maxInterval.setStart(level.starts());
                }
                
                delta = level.upto()- maxInterval.upto();
                if (delta > 0)
                {
                    waterIntegral += i*delta;
                    maxInterval.setEnd(level.upto() - 1);
                }
            }
        }
        
        return waterIntegral - wallsIntegral;
    }
}

public class TrapRain
{

    public static void main(String[] args)
    {
        // int[] elev = {0,1,0,2,1,0,1,3,2,1,2,1};
        
        int[] elev = {2,0, 2};
        Solution sol = new Solution();
        System.out.println("trapped " + sol.trap(elev));
    }
    
}

