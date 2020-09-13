// https://leetcode.com/problems/insert-interval/
class Solution
{
    public int[][] insert(int[][] intervals, int[] newInterval)
    {
        ArrayList<Interval> all = new ArrayList<>();
        all.add(new Interval(newInterval[0], newInterval[1]));
        for (int[] iv : intervals)
            all.add(new Interval(iv[0], iv[1]));
        
        Collections.sort(all);
        
        int start = -1;
        for (int i = 0; i < all.size() - 1; i++)
        {
            Interval curr = all.get(i);
            Interval next = all.get(i+1);
            
            if ( curr.end >= next.start)
            {
                start = i;
                break;
            }
        }
        
        if (start < 0) return copy(all);
        
        Interval tmp = all.get(start);
        int mergeStart = tmp.start;
        int mergeEnd = tmp.end;
        int cnt = 0;
        for (Iterator<Interval> iter = all.iterator(); iter.hasNext();)
        {
            Interval next = iter.next();
            
            if (cnt == start)
                iter.remove();
            else if (cnt > start)
            {
                if (mergeEnd < next.start) break;
                mergeEnd = Math.max(mergeEnd, next.end);
                iter.remove();
            }
            
            cnt++;
        }
        
        all.add(new Interval(mergeStart, mergeEnd));
        Collections.sort(all);
        return copy(all);
    }

    private int[][] copy(ArrayList<Interval> all)
    {
        int ret[][] = new int[all.size()][2];
        for (int i = 0; i < all.size(); i++)
        {
            ret[i][0] = all.get(i).start;
            ret[i][1] = all.get(i).end;
        }
        
        return ret;
    }

    private static class Interval implements Comparable<Interval>
    {
        public final int start;
        public final int end;
        public final int length;

        public Interval(int a, int b)
        {
            if (a > b)
                throw new IllegalArgumentException("bad interval");

            start = a;
            end = b;
            length = b - a + 1;
        }

        @Override
        public int compareTo(Interval iv)
        {
            if (this.start == iv.start)
                return Integer.compare(this.length, iv.length);
            else
                return Integer.compare(this.start, iv.start);
        }

        @Override
        public String toString() { return "(" + start + ", " + end + ")"; }
    }
}
