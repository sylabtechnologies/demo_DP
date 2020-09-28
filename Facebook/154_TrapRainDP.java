// https://leetcode.com/problems/trapping-rain-water/
package rainwaterdp;

class Solution
{
    public int trap(int[] height)
    {
        int hll = height.length;
        if (hll == 0) return 0;
        
        int lmax[] = new int[hll], rmax[] = new int[hll];
        lmax[0] = height[0];
        for (int i = 1; i < hll; i++)
            lmax[i] = Math.max(lmax[i-1], height[i]);

        rmax[hll - 1] = height[hll - 1];
        for (int i = hll - 2; i >= 0; i--)
            rmax[i] = Math.max(rmax[i+1], height[i]);

        int res = 0;
        for (int i = 0; i < hll; i++)
            res += Math.min(lmax[i], rmax[i]) - height[i];
        
        return res;
    }
}

public class RainWaterDP
{
    public static void main(String[] args)
    {
        int levs[] = {0,2,0}; // {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(new Solution().trap(levs));
    }
}
