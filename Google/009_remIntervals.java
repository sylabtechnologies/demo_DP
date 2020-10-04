// https://leetcode.com/problems/remove-covered-intervals/
package goog4;
import java.util.*;

class Solution {
    public int removeCoveredIntervals(int[][] intervals)
    {
        ArrayList<Interval> lst = new ArrayList<>();
        for (int[] iv : intervals)
        {
            Interval ii = new Interval(iv[0], iv[1]);
            lst.add(ii);
        }
        
        int count = 0;
        Collections.sort(lst);
        for (int i = 0; i < lst.size(); i++)
        {
            Interval top = lst.get(i);
            if (top.isDeleted()) continue;
            
            for (int j = i + 1; j < lst.size(); j++)
            {
                Interval curr = lst.get(j);
                if (curr.isDeleted()) continue;
                if (curr.end > top.end) break;
                
                if (top.start <= curr.start)
                {
                    curr.delete();
                    count++;
                }
                
            }
        }
            
        return intervals.length - count;
    }    
}

class Interval implements Comparable<Interval>
{
    public final int start;
    public final int end;
    private boolean deleted;

    public Interval(int a, int b)
    {
        if (a >= b)
            throw new IllegalArgumentException(a + " vs " + b);

        start = a;
        end = b;
        deleted = false;
    }

    public boolean isDeleted()
    {
        return deleted;
    }

    public void delete() { this.deleted = true; }
    
    @Override
    public int compareTo(Interval iv)
    {
        if (this.start != iv.start)
            return Integer.compare(this.start, iv.start);
        
        return Integer.compare(iv.end, this.end);
    }

    @Override
    public int hashCode()
    {
        return start * 31 + end;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null) return false; 
        if (getClass() != obj.getClass()) return false;
        
        final Interval other = (Interval) obj;
        if (this.start != other.start)
            return false;
        
        if (this.end != other.end)
            return false;
        
        return true;
    }

    @Override
    public String toString()
    {
        if (deleted)
            return "[" +start + ", " + end + "] deleted";
        else
            return "[" +start + ", " + end + "]";
    }
}    
