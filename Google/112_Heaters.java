package heaters;
import java.util.*;

/// #S - walk each house
class Solution 
{
    public int findRadius(int[] houses, int[] heaters) 
    {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        
        TreeSet<Integer> heat = new TreeSet<>();
        for (int h : heaters) heat.add(h);
        
        final int lo = heaters[0];
        final int hi = heaters[heaters.length-1];
        
        int max = 0;
        for (int i = 0; i < houses.length; i++) 
        {
            int h = houses[i];
            if (heat.contains(h)) continue;
            
            int d1 = Integer.MAX_VALUE, d2 = Integer.MAX_VALUE;
            if (h < hi) d1 = heat.ceiling(h) - h;
            if (h > lo) d2 = h - heat.floor(h);
            
            max = Math.max(Math.min(d1, d2), max);
        }

        return max;
    }
}

public class Heaters
{
    public static void main(String[] args)
    {
        int h[] = {282475249,622650073,984943658,144108930,470211272,101027544,457850878,458777923},
            ht[] = {823564440,115438165,784484492,74243042,114807987,137522503,441282327,16531729,823378840,143542612};
        System.out.println(new Solution().findRadius(h, ht));
    }
}

