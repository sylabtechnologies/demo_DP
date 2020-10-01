// https://leetcode.com/problems/moving-average-from-data-stream/
package goog1;

class MovingAverage
{
    final int size;
    int buf[];
    int curr;
    boolean isFull;
    double sum;
    
    public MovingAverage(int size)
    {
        this.size = size;
        buf = new int[size];
        isFull = false;
        curr = 0;
        sum = 0;
    }
    
    public double next(int val)
    {
        double ret = 0.0;
        sum += val;
        if (!isFull)
        {
            buf[curr++] = val;
            ret = sum / curr;
            if (curr == size)
            {
                isFull = true;
                curr = 0;
            }
        }
        else
        {
            int temp = buf[curr];
            buf[curr++] = val;
            if (curr == size) curr = 0;
            sum -= temp;
            ret = sum / size;
        }
        
        return ret;
    }
}
