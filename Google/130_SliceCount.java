package goog78;
import java.util.*;

class Solution 
{
    public int numberOfArithmeticSlices(int[] a) 
    {
        final int len = a.length;
        if (len < 3) return 0;
        
        int cnt = 0, sliceCnt = 0;
        int i = 0, j = 1, delta = a[j] - a[i];
        while (j + 1 < len)
        {
            if (a[j + 1] - a[j] == delta) 
            {
                sliceCnt++;
                cnt += sliceCnt;
            }
            else
            {
                i = j;
                delta = a[i + 1] - a[i];
                sliceCnt = 0;
            }

            j++;
        }
        
        return cnt;
    }
}

public class Goog78
{
    public static void main(String[] args)
    {
        int a[] = {1,2,3,4,8,9,10};  // {1,2,3,8,9,10};
        System.out.println(new Solution().numberOfArithmeticSlices(a));
    }
}
