package meetings;
import java.util.*;

class Solution
{
    public int solve(int[][] meetings)
    {
        ArrayList<Event> timer = new ArrayList<Event>();
        for (int[] m : meetings)
        {
            timer.add(new Event(m[0], 1));
            timer.add(new Event(m[1], -1));
        }
        Collections.sort(timer);
        
        int level = 0, max = Integer.MIN_VALUE, prev = max;
        // group by
        for (int i = 0; i < timer.size(); i++)
        {
            Event ev = timer.get(i);
            level += ev.value;
            
            while (i != timer.size() - 1 && timer.get(i + 1).time == ev.time)
            {
                level += timer.get(i + 1).value;
                i++;
            }
            
            max = Math.max(max, level);
        }
        
        return max;
    }

    private static class Event implements Comparable<Event>
    {
        int time;
        int value;

        public Event(int t, int val)
        {
            time = t;
            value = val;
        }

        @Override
        public int compareTo(Event ev)
        {
            return time - ev.time;
        }

        @Override
        public String toString() { return value + "@ " + time;}
    }
}

public class Meetings
{
    public static void main(String[] args)
    {
        int meetings[][] =
        {
            {17, 26},
            {14, 22},
            {7, 29},
            {2, 29},
            {11, 14},
            {5, 24},
            {1, 14},
            {13, 14} };

          System.out.println(new Solution().solve(meetings));

  
    }
}

//     int meetings[][] = {{ 0, 30}, { 5, 10}, { 15, 20}};
