// https://leetcode.com/problems/non-overlapping-intervals/
package nonoverlapping;
import java.util.*;

class Solution
{
    // google max disjoint intervals
    public int eraseOverlapIntervals(int[][] intervals)
    {
        if (intervals.length == 0) return 0;
        
        ArrayList<Interval> sortIvals = new ArrayList<>();
        for (int[] iv : intervals)
            sortIvals.add(new Interval(iv[0], iv[1]));
        
        Collections.sort(sortIvals);
        Interval curr = sortIvals.get(0);
        int result = 0;
        for (int i = 1; i < sortIvals.size(); i++)
        {
            Interval next = sortIvals.get(i);
            if (next.beg < curr.end)
                result++;
            else
                curr = next;
        }
        
        return result;
    }

    private static class Interval implements Comparable<Interval>
    {
        int beg, end;

        private Interval(int x, int y)
        {
            this.beg = x;
            this.end = y;
        }

        @Override
        public String toString()
        {
            return "[" + beg + ", " + end + "]";
        }

        @Override
        public int compareTo(Interval ir)
        {
            if (this.end == ir.end)
                return this.beg - ir.beg;
            else
                return this.end - ir.end;
        }
    }
}

public class Nonoverlapping
{
    public static void main(String[] args)
    {
        int iv[][] = {{1,2}}; //, {2,3}, {3,4}, {1,3}};
        System.out.println(new Solution().eraseOverlapIntervals(iv));
    }
    
}
