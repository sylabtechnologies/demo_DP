package cheapflights;

/// D# w/ totalPrice and simple hash
class Weight
{
    int node;
    int totalPrice;
    int myStops;

    public Weight(int n, int w)
    {
        node = n;
        totalPrice = w;
        myStops = 0;
    }

    @Override
    public boolean equals(Object o)
    {
        if(o==this) return true;
        if(!(o instanceof Weight)) return false;
        Weight w = (Weight)o;
        return (this.node == w.node && this.totalPrice == w.totalPrice);
    }

    @Override
    public int hashCode()  // return same code for .eq.
    {
        int res = 5;
        res = res*31 + node;
        res = res*31 + totalPrice;
        return res;
    }

    @Override
    public String toString()
    {
        return " to " + node + " for $" + totalPrice;
    }
}
