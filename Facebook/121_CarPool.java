// https://leetcode.com/problems/car-pooling/ = events
package carpool;
import java.util.*;

class Solution
{
    public boolean carPooling(int[][] trips, int capacity)
    {
        ArrayList<Event> events = new ArrayList<>();
        for (int[] trip : trips)
        {
            events.add(new Event(trip[1], trip[0]));
            events.add(new Event(trip[2], -trip[0]));
        }

        Collections.sort(events);
        int psngr = 0, curr = 0;
        
        while (curr < events.size())
        {
            Event ev = events.get(curr);
            System.out.println(ev + " @ " + psngr);
            
            int curtime = ev.time;
            psngr += ev.delta;
            
            if (curr < events.size() - 1)
            {
                Event next = events.get(curr + 1);
                while (next != null && next.time == curtime)
                {
                    System.out.println(next);
                    psngr += next.delta;
                    curr++;
                    if (curr >= events.size() - 1) break;
                    next = events.get(curr + 1);
                }
            }
            
            if (psngr > capacity)
                return false;
            
            curr++;
        }
     
        return true;
    }

    private static class Event implements Comparable<Event>
    {
        int time, delta;

        public Event(int time, int delta)
        {
            this.time = time;
            this.delta = delta;
        }

        @Override
        public int compareTo(Event ev)
        {
            if (this.time != ev.time)
                return Integer.compare(this.time, ev.time);
            else
                return Integer.compare(this.delta, ev.delta);
        }

        @Override
        public String toString() {
            return "@ " + time + " = " + delta;
        }
        
        
        
    }
}

public class CarPool
{
    public static void main(String[] args)
    {
        int tr[][] = { {3,2,7},{3,7,9},{8,3,9}};
        System.out.println(new Solution().carPooling(tr, 11));
    }
}
