package goog38;
import java.util.*;

// https://leetcode.com/problems/maximum-number-of-eaten-apples/
// S# convert queue sim to treemap
class Solution 
{
    public int eatenApples(int[] apples, int[] days) 
    {
        int eat = 0;
        TreeMap<Integer, Integer> queue = new TreeMap<>();
        
        int day = 0; 
        while (day < days.length || !queue.isEmpty()) 
        {
            if (day < days.length)
            {
                int numApples = apples[day];
                int good4 = day + days[day] - 1;
                queue.put(good4, numApples);
            }
            
            clearDay(queue, day);
                
            if (!queue.isEmpty())
            {
                eat++;
                getOne(queue);
            }
            
            day++;
        }

        return eat;
    }

    private void clearDay(TreeMap<Integer, Integer> queue, int day) 
    {
        while (!queue.isEmpty())
        {
            int key = queue.firstKey();
            if (key < day) 
                queue.remove(key);
            else break;
        }
    }

    private void getOne(TreeMap<Integer, Integer> queue) 
    {
        int key = queue.firstKey();
        int val = queue.get(key);
        if (val == 1) 
            queue.remove(key);
        else
            queue.put(key, val - 1);
    }
}

public class Goog38
{
    public static void main(String[] args)
    {
         int[] apples = {1,2,3,5,2}, days = {3,2,1,4,2};
//        int[] apples = {3,0,0,0,0,2}, days = {3,0,0,0,0,2};
        System.out.println(new Solution().eatenApples(apples, days));
    }
}
