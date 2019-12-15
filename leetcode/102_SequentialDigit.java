/*
An integer has sequential digits if and only if each digit in the number
is one more than the previous digit.

Return a sorted list of all the integers in the range [low, high]
inclusive that have sequential digits.

##DESIGN ##DRY
*/

package sequentialdigit;
import java.util.*;

class Solution
{
    public List<Integer> sequentialDigits(long low, long high)
    {
        if (low < 10 || high > 1000000000L)
            throw new IllegalArgumentException("bad param");

        int  size = getLength(low);
        long curr = getStart(size);
        long incr = getInrement(size);
        long limit = (long) Math.pow(10, size);
        
        List<Integer> ans = new ArrayList<>();
        while (curr <= high)
        {
            if (curr >= low) ans.add((int)curr);

            if (curr % 10 == 9)
            {
                limit *= 10;
                size++;
                curr = getStart(size);
                incr = getInrement(size);
            }
            else
                curr += incr;
        }
        
        return ans;
    }

    private int getLength(long num)
    {
        int count = 0;
        
        while (num > 0)
        {
            num /= 10;
            count ++;
        }
        
        return count;
    }
    
    private long getStart(int size)
    {
        long ans = 1;
        int count = 1;
        
        while (size > 1)
        {
            ans *= 10; count++;
            ans += count; size--;
        }
        
        return ans;
    }

    private long getInrement(int size)
    {
        long ans = 1;
        
        while (size > 1)
        {
            ans *= 10; ans += 1; size--;
        }
        
        return ans;
    }
}


public class SequentialDigit
{

    public static void main(String[] args)
    {
        Solution obj = new Solution();
//        System.out.println(obj.sequentialDigits(100, 10000));
        System.out.println(obj.sequentialDigits(8511, 23553));
    }
    
}
