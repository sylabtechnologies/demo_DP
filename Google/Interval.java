package goog17;

public class Interval implements Comparable<Interval>
{
    public final int beg;
    public final int end;
    public int height;

    public Interval(int a, int b)
    {
        if (a >= b)
            throw new IllegalArgumentException("bad interval");

        beg = a;
        end = b;
        height = 0;
    }

    public Interval(int a, int b, int h)
    {
        this(a,b);
        height = h;
    }
    
    @Override
    public int compareTo(Interval ii)
    {
        if (this.beg < ii.beg) return -1;
        if (this.beg > ii.beg) return +1;
        if (this.end < ii.end) return -1;
        if (this.end > ii.end) return +1;
        return 0;    
    }

    public boolean overlaps(Interval next)
    {
        if (this.end < next.beg) return false;
        if (this.beg > next.end) return false;
        return true;
    }

    @Override
    public int hashCode() { return beg + 31*(end - beg); }

    @Override
    public boolean equals(Object arg)
    {
        if ((arg != null) && (arg instanceof Interval))
        {
            Interval iv = (Interval) arg;
            return (iv.beg == this.beg && iv.end == this.end);
        }
        else
            return false;
    }

    boolean contains(Interval iv)
    {
        if (this.beg <= iv.beg && iv.end <= this.end)
            return true;
        else
            return false;
    }

    Interval merge(Interval next)
    {
        int nbeg = Math.min(this.beg, next.beg);
        int nend = Math.max(this.end, next.end);
        return new Interval(nbeg, nend, this.height);
    }


    @Override
    public String toString()
    {
        return "[" + beg + ", " + end + "]";
    }
}

