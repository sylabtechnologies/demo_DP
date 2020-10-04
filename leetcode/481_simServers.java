// https://leetcode.com/problems/find-servers-that-handled-most-number-of-requests/

package goog3;
import java.util.*;

class Solution
{
    private int mySize;
    private int served[];
    private TreeSet<Integer> free;
    
    public List<Integer> busiestServers(int k, int[] arrival, int[] load)
    {
        mySize = k;
        served = new int[mySize];
        free = new TreeSet<>();
        for (int i = 0; i < mySize; i++)
            free.add(i);
        
        PriorityQueue<Event> unload = new PriorityQueue<>();
        
        for (int i = 0; i < arrival.length; i++)
        {
            int curStart = arrival[i];
            int curFin   = curStart + load[i];
            
            while (!unload.isEmpty() && unload.peek().time <= curStart)
            {
                Event ev = unload.poll();
                free.add(ev.server);
            }
            
            int index = i % mySize;
            
            if (free.isEmpty()) continue;
            
            if (!free.contains(index))
            {
                Integer nxt = free.ceiling(index + 1);
                
                if (nxt == null)
                    nxt = free.first();
                
                if (nxt == null)
                    throw new IllegalStateException();
                
                index = nxt;                
            }
        
            free.remove(index);
            served[index]++;
            unload.add(new Event(curFin, index));
            
//            System.out.println(free);
//            System.out.println(unload);
        }
        
        List<Integer> res = new ArrayList<>();
        int max = 0;
        for (int index = 0; index < served.length; index++)
        {
            if (served[index] > max)
            {
                res.clear();;
                res.add(index);
                max = served[index];
            }
            else if (served[index] == max)
                res.add(index);
        }
   
        return res;
    }

    private static class Event implements Comparable<Event>
    {
        int time, server;

        public Event(int time, int delta)
        {
            this.time = time;
            this.server = delta;
        }

        @Override
        public String toString() {
            return "@" + time + " # " + server;
        }

        @Override
        public int compareTo(Event ev)
        { 
            if (ev.time != this.time) return Integer.compare(this.time, ev.time);
            return Integer.compare(this.server, ev.server);
        }
    }
}
