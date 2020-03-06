package removeintervals;
import java.util.*;

public class IntervalTree
{
    TreeMap<Integer, Interval> map = new TreeMap<>();
    
    public void overwriteCovered(Interval ii)
    {
        NavigableMap<Integer, Interval> range
            = map.subMap(ii.start, true, ii.end, true);

        ArrayList<Integer> deleteList = new ArrayList<>();
        if (range != null)
        {
            for (Map.Entry<Integer, Interval> entry : range.entrySet())
            {
                Interval iv = entry.getValue();
                
                if (iv.isEnd(entry.getKey())) continue;
                
                if (iv.end <= ii.end)
                {
                    deleteList.add(iv.start);
                    deleteList.add(iv.end);
                }
            }
        }
        
        for (Integer id : deleteList)
            map.remove(id);
        
        map.put(ii.start, ii);
        map.put(ii.end, ii);
    }

    public int size()
    {
        return map.size()/2;
    }
    
    public static class Interval implements Comparable<Interval>
    {
        public final int start;
        public final int end;
        public final int length;

        public Interval(int a, int b)
        {
            if (a >= b)
                throw new IllegalArgumentException("bad interval");

            start = a;
            end = b;
            length = b - a;
        }

        public boolean isStart(int x) { return x == start; }
        public boolean isEnd(int x) { return x ==end; }

        @Override
        public int compareTo(Interval iv)
        {
            if (this.length < iv.length)
                return -1;
            else if (this.length > iv.length)
                return 1;
            else return 0;
        }
    }
    
}
