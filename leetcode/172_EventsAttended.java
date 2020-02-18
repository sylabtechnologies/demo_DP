// https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/
/// Gordon: multimap by last day, sort by first day
/// Jesse:  mark attended days w hashset

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
            map.put(events[i][1], events[i][0]);
        
        List<Integer> days = map.getKeys(true);
        HashSet<Integer> busy = new HashSet<>();

        for (Integer lastDay : days)
        {
            List<Integer> row = map.getRow(lastDay);
            Collections.sort(row);
            
            for (Integer time : row)
            {
                for (int i = time; i <= lastDay; i++)
                    if (busy.add(i)) break;
            }
            
        }

        return busy.size();
    }
}

public class EventsAttended
{
    public static void main(String[] args)
    {
//        int[][] events = {{1,4},{4,4},{2,2},{3,4},{1,1}};
//        int[][] events = {{1,1},{1,2},{2,2}};
//        int[][] events = {{1,2},{2,3},{3,4},{1,2}};
        
        int[][] events = {{1,2},{1,2},{3,3},{1,5},{1,5}};
        Solution obj = new Solution();
        System.out.println(obj.maxEvents(events));
    }
    
}
