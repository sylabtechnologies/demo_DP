package goog3;
import java.util.*;

/*
You have k servers numbered from 0 to k-1 that are being used to handle multiple
requests simultaneously. Each server has infinite computational capacity but cannot handle more than one request at a time. The requests are assigned to servers according to a specific algorithm:
*/

class Solution
{
    private int mySize;
    private int served[];
    private boolean busy[];
    private Buckets buck;
    
    public List<Integer> busiestServers(int k, int[] arrival, int[] load)
    {
        buck = new Buckets(k);
        mySize = k;
        served = new int[buck.size()*Buckets.BUCKSIZE];
        busy = new boolean[buck.size()*Buckets.BUCKSIZE];
        buck.link(busy);
        
        int max = 0;
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Event> unload = new PriorityQueue<>();
        
        for (int i = 0; i < arrival.length; i++)
        {
            int curStart = arrival[i];
            int curFin   = curStart + load[i];
            
            while (!unload.isEmpty() && unload.peek().time <= curStart)
            {
                Event ev = unload.poll();
                busy[ev.server] = false;
                System.out.println("free " + ev);
                buck.free(ev.server);
            }
            
            int index = i % mySize;
            index = buck.nextFree(index);
            if (index < 0) continue;
        
            busy[index] = true;
            served[index]++;
            buck.load(index);

            unload.add(new Event(curFin, index));
            
            if (served[index] > max)
            {
                res.clear();;
                res.add(index);
                max = served[index];
            }
            else if (served[index] == max)
                res.add(index);
            
            System.out.println(unload);
            int cc = 0;
            for (boolean b : busy)
            {
                if (b) System.out.print(cc + " ");
                cc++;
            }
            
            System.out.println(" busy");
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

public class Goog3
{
    public static void main(String[] args)
    {
//        int str[] = {1,2,3,4,8,9,10}, load[] = {5,2,10,3,1,2,2};
        int str[] = {1,3,4,5,6,11,12,13,15,19,20,21,23,25,31,32},
        load[] = {9,16,14,1,5,15,6,10,1,1,7,5,11,4,4,6}; // = 0
        System.out.println(new Solution().busiestServers(7, str, load));
    }
    
}

class Buckets
{
    public final static int BUCKSIZE = 20;
    private final int mySize;
    private final int total;
    private final int lastCnt;
    private int count[];
    private boolean busy[];

    void link(boolean[] busy)
    {
        this.busy = busy;
    }
    
    public Buckets(int k)
    {
        total = k;
        mySize = total/BUCKSIZE + 1;
        count  = new int[mySize];
        lastCnt = total - (mySize-1)*BUCKSIZE;
    }

    public int size() { return mySize; }

    int nextFree(int i)
    {
        int bucket = i / BUCKSIZE;
        if (!busy[i]) return i;

        int bk = -1;
        boolean found = false;
        for (bk = bucket; bk < mySize; bk++)
        {
            if (count[bk] != BUCKSIZE)
            {
                found = true;
                break;
            }

            bk++;
        }
        
        if (found)
        {
            int start = bk*(BUCKSIZE-1);
            int ix = linear(start, start + BUCKSIZE);
            if (ix >= 0)
                return ix;
            else found = false;
        }

        for (bk = 0; bk < bucket; bk++)
        {
            if (count[bk] != BUCKSIZE)
            {
                found = true;
                break;
            }            
        }

        if (!found) return -1;
        
        int start = bk*(BUCKSIZE-1);
        return linear(bk*(BUCKSIZE-1), start + BUCKSIZE);
    }

    void free(int i)
    {
        int bucket = i / BUCKSIZE;
        count[bucket]--;
    }
    
    void load(int i)
    {
        int bucket = i / BUCKSIZE;
        count[bucket]++;
    }

    private int linear(int i, int stop)
    {
        for (int j = i + 1; j < stop && j < total; j++)
            if (!busy[j]) return j;

        return -1;
    }
}
