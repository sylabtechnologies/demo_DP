package goog25;
import java.util.*;

public class Goog25
{
    public static void main(String[] args)
    {
        
    }
}

/*
//        int arr[]= {6, 1, 7, 2, 1 };
//        System.out.println(new Solution().waysToMakeFair(arr));

class Solution
{
    public int waysToMakeFair(int[] nums)
    {
        final int mylen = nums.length;
        if (mylen < 3) return 0;
        
        int sums[] = new int[mylen];
        sums[0] = nums[0];
        sums[1] = nums[1];
        
        for (int i = 2; i < sums.length; i += 2)
        {
            sums[i] = sums[i-2] + nums[i];
            
            if (i < sums.length - 1)
                sums[i+1] = sums[i-1] + nums[i+1];
        }
        
        int lastEven =0, lastOdd = 0;
        if (mylen % 2 == 0)
        {
            lastEven = sums[mylen-2];
            lastOdd = sums[mylen-1];
        }
        else
        {
            lastEven = sums[mylen-1];
            lastOdd = sums[mylen-2];
        }
/*
     [6, 1, 7, 2, 1] fair to remove #1
      6     13    14
         1      3
        
      6  1  2  1    re 7
        
      6     8  
         1      2
        
        
        int count = 0;
        for (int i = 0; i < sums.length; i++)
        {
            int odd = 0, even = 0;
            
            int remove = nums[i];
                        
            if (i % 2 == 0)
            {
                even = lastOdd - sums[i];
                odd = sums[i] + lastOdd - remove;
            }
            else
            {
                even = sums[i-1] + lastOdd - remove;
                odd = lastEven - sums[i-1];
            }
            
            if (odd == even) count++;
                    
        }
     
        return count;
    }
}


    remove 1,
    6 7 2 1 is fair
    6   8    plus even
      7   8  minus even

*/