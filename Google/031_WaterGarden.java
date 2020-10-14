/*
https://leetcode.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/
- we tap all overlappings and being greedy
*/

package buddy;
import java.util.*;

class Solution
{
    public int minTaps(int n, int[] ranges)
    {
        LinkedList<Interval> taps = new LinkedList<>();
        for (int location = 0; location < ranges.length; location++)
        {
            int lft = location - ranges[location];
            int rgh = location + ranges[location];
            if (lft < 0) lft = 0;
            if (rgh > n) rgh = n;
            
            taps.add(new Interval(lft, rgh));
        }
        Collections.sort(taps);
        
       // System.out.println(taps);
        
        int cover = 0, count = 0;
        int max = -1;
        while (!taps.isEmpty())
        {
            boolean delete = false;
            while (!taps.isEmpty())
            {
                Interval curr = taps.getFirst();
                if (curr.start > cover) break;
                
                taps.removeFirst();
                delete = true;
                max = Math.max(max, curr.fin);
            }

            if (max == cover && max < n) return -1;
            if (delete && max > cover) count++;
            cover = Math.max(max, cover);
        }
        
        return count;
    }

    private static class Interval implements Comparable<Interval>
    {
        int start, fin;

        public Interval(int beg, int end)
        {
            this.start = beg;
            this.fin = end;
        }

        @Override
        public String toString() {
            return "(" + start + ", " + fin + ")";
        }

        @Override
        public int compareTo(Interval iv)
        { 
            if (iv.start != this.start)
                return Integer.compare(this.start, iv.start);
            
            return Integer.compare(iv.fin, this.fin);
        }
    }
}
  

public class Buddy
{
    public static void main(String[] args)
    {
        int taps[] =
//        {0,5,0,3,3,3,1,4,0,4};
        {1,2,1,0,2,1,0,1};
//        {3,4,1,1,0,0};
        System.out.println(new Solution().minTaps(7, taps));
    }
}

