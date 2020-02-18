// https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/
// from Gordon: multimap wont fit all & conflict 3-3
// clear the logic and redefine as busy intervals

package eventsattended;
import java.util.*;

class Solution
{
    public int maxEvents(int[][] events)
    {
        if (events == null) return 0;
        int len = events.length;
        if (len == 0) return 0;

        MultiMap map = new MultiMap();
        for (int i = 0; i < len; i++)
            map.put(events[i][0], events[i][1]);
        
        List<Integer> days = map.getKeys(true);
        int res = 0;

//        System.out.println("test " + (++testCase));
        System.out.println(days);
        
        int dayNo = 0;
        for (Integer d : days)
        {
            List<Integer> row = map.getRow(d);
            Collections.sort(row);
            System.out.println(row);
            
            boolean startRow = true;
            for (Integer time : row)
            {
                if (startRow)
                {
                    startRow = false;
                    if (dayNo < d) dayNo = d;
                }

                if (dayNo <= time)
                {
                    res++;
                    dayNo++;
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
//        int[][] events = {{1,4},{4,4},{2,2},{3,4},{1,1}};
//        int[][] events = {{1,1},{1,2},{2,2}};

        int[][] events = {{1,2},{1,2},{3,3},{1,5},{1,5}};
        Solution obj = new Solution();
        System.out.println(obj.maxEvents(events));
    }
}
