// https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/
// *ERROR CLR* map events to each day, attend closing soonest
// clear the logic, conflict 1-4 and 2-2?

package eventsattended;
import java.util.*;

class Solution
{
    private static int testCase = 0;
    
    public int maxEvents(int[][] events)
    {
        if (events == null) return 0;
        int len = events.length;
        if (len == 0) return 0;

        MultiMap map = new MultiMap();
        for (int i = 0; i < len; i++)
            map.put(events[i][0], events[i][1]);
        
        List<Integer> days = map.getKeys();
        int res = 0;

        System.out.println("\ttest " + (++testCase));
        System.out.println(days);
        
        int current = 0;
        for (Integer d : days)
        {
            if (current == 0)
            {
                current = d;
            }
            else
            {
                if (d > current)
                    continue;
            }
            
            List<Integer> row = map.getRow(d);
            Collections.sort(row);
            System.out.println(row);
            
            for (Integer time : row)
            {
                if (current <= time)
                {
                    current++;
                    res++;
                }
            }
            
        }

        return res;
    }
}

public class EventsAttended
{

    public static void main(String[] args)
    {
        int[][] events = {{1,4},{4,4},{2,2},{3,4},{1,1}};
//        int[][] events = {{1,1},{1,2},{2,2}};
        Solution obj = new Solution();
        System.out.println(obj.maxEvents(events));
    }
}
