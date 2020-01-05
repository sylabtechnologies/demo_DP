/**
 * Given the array arr of positive integers and the array queries where queries[i] = [Li, Ri],
 * for each query i compute the XOR of elements from Li to Ri (that is, arr[Li]
 * xor arr[Li+1] xor ... xor arr[Ri] ).
 * 
 * Optimize treeset to map by interval?
 */

package xorqueries;
import java.util.*;

class Solution
{
    public int[] xorQueries(int[] arr, int[][] queries)
    {
        Map<Integer, TreeSet<Interval>> map = new TreeMap<>();
        
        // bst
        for (int[] q : queries)
        {
            Interval iv = new Interval(q[0], q[1]);
            
            int key = iv.start;
            TreeSet<Interval> set = map.get(key);
            
            if (set != null)
                set.add(iv);
            else
            {
                set = new TreeSet<>();
                set.add(iv);
                map.put(key, set);
            }
        }
        
        // System.out.println(map);
        
        // do memoization
        for (Map.Entry<Integer, TreeSet<Interval>> el : map.entrySet())
        {
            TreeSet<Interval> set = el.getValue();

            Interval prev = null;
            
            for (Interval curr : set)
            {
                if (prev == null)
                {
                    prev = curr;
                    prev.xor = getXor(arr, prev.start, prev.end);
                    continue;
                }

                int nextXor = getXor(arr, prev.end+1, curr.end);
                curr.xor = prev.xor  ^ nextXor;
                prev = curr;
            }
        }

        int[] res = new int[queries.length];
        
        for (int i = 0; i < res.length; i++)
        {
            Interval iv = new Interval(queries[i][0], queries[i][1]);
            
            Iterator<Interval> iter = map.get(queries[i][0]).iterator();
            while (iter.hasNext())
            {
                Interval next = iter.next();
                
                if (next.start == queries[i][0] && next.end == queries[i][1])
                {
                    res[i] = next.xor;
                    break;
                }
            }
        }
        
        return res;
    }

    private int getXor(int[] arr, int start, int end)
    {
        if (start == end) return arr[start];
        
        int ans = 0;
        for (int i = start; i <= end; i++)
            ans = ans ^ arr[i];

        return ans;
    }
    
    class Interval implements Comparable<Interval>
    {
        int start;
        int end;
        int length;
        int xor;
        
        public Interval(int a, int b)
        {
            if (a > b)
                throw new IllegalArgumentException("bad interval " + a + b);

            start = a;
            end = b;
            length = b - a;
        }
        
        @Override
        public int compareTo(Interval ii)
        {
            if (this.start < ii.start) return -1;
            if (this.start > ii.start) return +1;
            if (this.length < ii.length) return -1;
            if (this.length > ii.length) return +1;
            return  0;    
        }        
 
        @Override
        public String toString()
        {
            return "[" +start + ", " + end + "]";
        }        

        // check null then cast
        @Override
        public boolean equals(Object o)
        {
            if (o == null) return false;
            if (o instanceof Interval)
            {
                Interval other = (Interval) o;
                
                if (start == other.start && end == other.end)
                    return true;
                else
                    return false;
            }
            else return false;
        }
        
    }
    
}
