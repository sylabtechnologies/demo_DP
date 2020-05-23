// https://leetcode.com/problems/merge-intervals/

package merge;
import java.util.*;

class Solution
{
    public int[][] merge(int[][] ivals)
    {
        if (ivals.length == 0) return new int[0][];
        if (ivals.length == 1) return ivals;

        LinkedList<Interval> list = new LinkedList<>();
        for (int i = 0; i < ivals.length; i++)
            list.add(new Interval(ivals[i][0], ivals[i][1]));
        Collections.sort(list);

        LinkedList<Interval> res = new LinkedList<>();
        while (!list.isEmpty())
        {
            Interval curr = list.removeFirst();
            
            if (!list.isEmpty())
            {
                for (Iterator<Interval> iter = list.iterator(); iter.hasNext();)
                {
                    Interval next = iter.next();
                    if (curr.overlaps(next))
                    {
                        curr.merge(next);
                        iter.remove();
                    }
                }
            }
            
            res.add(curr);
        }
        
        int ans[][] = new int[res.size()][];
        int count = 0;
        for (Interval i : res)
        {
            ans[count] = new int[2];
            ans[count][0] = i.beg;
            ans[count][1] = i.end;
            count++;
        }
        
        return ans;
    }
    
    class Interval implements Comparable<Interval>
    {
        int beg, end;

        public Interval(int beg, int end)
        {
            this.beg = beg;
            this.end = end;
        }

        @Override
        public String toString() { return "[" + beg + ", " + end + ']';}

        private boolean overlaps(Interval next)
        {
            if (this.end < next.beg) return false;
            if (this.beg > next.end) return false;
            return true;
        }

        private void merge(Interval next)
        {
            this.beg = Math.min(this.beg, next.beg);
            this.end = Math.max(this.end, next.end);
        }

        @Override
        public int compareTo(Interval next)
        {
            if (this.beg != next.beg)
                return this.beg - next.beg;
            else
                return next.end - this.end;
        }
    }
}

public class Merge
{
    public static void main(String[] args)
    {
//        int arr[][] = {{1,3},{2,6},{8,10},{15,18}};
//        int arr[][] = {{1,4},{4,5}};
        int arr[][] = {{2,3},{4, 5}, {6, 7},{8,9},{1,10}};
        int x[][] = new Solution().merge(arr);
        for (int[] i : x)
            System.out.println(i[0] + " " + i[1]);
        
    }
    
}

