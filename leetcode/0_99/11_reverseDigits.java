class Solution {
    public int reverse(int x)
    {
        if (x == 0) return x;
        
        boolean positive = true;
        
        if (x < 0)
        {
            positive = false;
            x = -x;
        }
        
        long res = 0;
        while (x > 0)
        {
            res *= 10;
            int d = x % 10;
            res += d;
            x = x / 10;            
        }
        
        long lim = 2147483647;
        if (positive)
        {
            if (res > lim) return 0;
            return (int) res;
        }
        else
        {
            if (res > lim + 1) return 0;
            return (int) -res;
            
        }
    }
}