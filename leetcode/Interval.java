package mergeintervals;

public class Interval implements Comparable<Interval>
{
    private int start;
    private int end;
    private int length;
    private boolean deleted;

    public Interval(int a, int b)
    {
        if (a >= b)
            throw new IllegalArgumentException("bad interval");

        start = a;
        end = b;
        length = b - a;
        deleted = false;
    }

    public boolean isDeleted()
    {
        return deleted;
    }

    public void reset(int a, int b)
    {
        if (a >= b)
            throw new IllegalArgumentException("bad interval");

        start = a;
        end = b;
        length = b - a;
    }
    
    public void delete() { this.deleted = true; }
    public int getStart()  { return start; }
    public int getEnd()    { return end; }
    public int getLength()    { return length; }
    
    @Override
    public int compareTo(Interval ii)
    {
        if (this.start < ii.start) return -1;
        if (this.start > ii.start) return +1;
        if (this.end < ii.end) return -1;
        if (this.end > ii.end) return +1;
        return  0;    
    }

    public boolean overlaps(Interval b)
    {
        if (this.end >= b.start) return true;
        if (b.end <= this.start) return true;
        return false;
    }

    @Override
    public int hashCode() { return start + length; }

    @Override
    public boolean equals(Object arg)
    {
        if ((arg != null) && (arg instanceof Interval))
        {
            Interval iv = (Interval) arg;
            return (iv.start == this.start && iv.end == this.end);
        }
        else
            return false;
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
