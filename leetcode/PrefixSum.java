package goog27;

public class PrefixSum
{
    private final int[] sum;

    public PrefixSum(int arr[])
    {
        sum = new int[arr.length];
        sum[0] = arr[0];
        for (int i = 1; i < sum.length; i++)
            sum[i] = sum[i-1] + arr[i];
    }
    
    public int getSum(int from, int to)
    {
        int ret = sum[to];
        if (from > 0) ret-= sum[from - 1];
        return ret;
    }
}
