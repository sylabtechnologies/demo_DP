// https://leetcode.com/problems/find-the-minimum-number-of-fibonacci-numbers-whose-sum-is-k/

package minfibo;
import java.util.TreeSet;

class Solution
{
    private static TreeSet<Integer> fibo;
    private static final int max = 1000000000;
    static
    {
        int fb1 = 1, fb2 = 1;
        fibo = new TreeSet<>();
        
        while (fb2 <= max)
        {
            int temp = fb2;
            fb2 = fb2 + fb1;
            fb1 = temp;
            fibo.add(fb2);
        }
    }
    
    public int findMinFibonacciNumbers(int k)
    {
        int count = 0;
        
        while (k > 1)
        {
            int next = fibo.floor(k);
            
            if (k == next)
            {
                count++; return count;
            }
            
            k -= next; count++;
        }
        
        if (k == 1) count++;
        return count;
    }

    
}

public class MinFibo
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().findMinFibonacciNumbers(19));
    }
    
}
