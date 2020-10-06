// https://leetcode.com/problems/meeting-rooms-ii/
package goog7;
import java.util.*;

class Solution
{
    public int minMeetingRooms(int[][] intervals)
    {
        PriorityQueue<Event> events = new PriorityQueue<>();
        
        for (int[] iv : intervals)
        {
            events.add(new Event(iv[0], 1));
            events.add(new Event(iv[1], -1));
        }
        
        int rooms = 0, max = 0;
        while (!events.isEmpty())
        {
            Event ev = events.poll();
            rooms += ev.action;
            max = Math.max(max, rooms);
        }

        return max;
    }

    private static class Event implements Comparable<Event>
    {
        int time, action;

        public Event(int time, int delta)
        {
            this.time = time;
            this.action = delta;
        }

        @Override
        public String toString() {
            return "@" + time + " > " + action;
        }

        @Override
        public int compareTo(Event ev)
        { 
            if (ev.time != this.time) return Integer.compare(this.time, ev.time);
            return Integer.compare(this.action, ev.action);
        }
    }

}
