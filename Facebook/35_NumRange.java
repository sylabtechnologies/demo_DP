// https://leetcode.com/articles/a-recursive-approach-to-segment-trees-range-sum-queries-lazy-propagation/

package numrange;
import java.util.*;

class Solution
{
    private int minRange;
    private int maxRange;
    
    public int numRange(ArrayList<Integer> A, int B, int C)
    {
        int len = A.size();
        minRange = B;
        maxRange = C;
        System.out.println(A);
        
        if (len == 1)
        {
            return (A.get(0) >= minRange) && (A.get(0) <= maxRange) ? 1 : 0;
        }
        
        int beg = 0, end = 1, sum = A.get(0), count = 0;
        while (end <= len)
        {
            if (sum < minRange)
            {
                sum += A.get(end);
                end++;
            }
            else if (sum > maxRange)
            {
                sum -= A.get(beg);
                beg++;
                
                if (beg == end)
                {
                    if (end == len) break;
                    sum = A.get(end);
                    end++;
                }
            }
            else
            {
                count++;
                if (end == len) break;

                sum += A.get(end);
                end++;
            }
        }
        
        return count;
    }
}

public class NumRange
{
    public static void main(String[] args)
    {
        ArrayList<Integer> test = new ArrayList<>(Arrays.asList(1));
        System.out.println(new Solution().numRange(test, 0, 0));
    }
}
