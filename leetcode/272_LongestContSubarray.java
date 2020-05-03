// https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/

package longestcontsubarray;
import java.util.*;

/// #TR - 2 ptr optimization
class Solution
{
    public int longestSubarray(int[] nums, int limit)
    {
        LinkedList<SubArr> lst = new LinkedList<>();

        int i = 0, prev = -1;
        while (i < nums.length)
        {
            int n = nums[i];
            
            SubArr elem;
            if (n == prev)
            {
                elem = lst.getLast();
                elem.length++;                
            }
            else
                elem = new SubArr(n, i);
            
            lst.add(elem);
            
            prev = n;
            i++;
        }
        
        int maxsize = 0;
        while (!lst.isEmpty())
        {
            Iterator<SubArr> iter = lst.iterator();
            while (iter.hasNext())
            {
                SubArr next = iter.next();
                
                if (maxsize < next.length) maxsize = next.length;
                
                int ix = next.startIndex + next.length;
                if (ix > nums.length - 1)
                {
                    iter.remove();
                    continue;
                }
                
                if (next.canAdvance(nums[ix], limit))
                    next.advance(nums[ix]);
                else
                    iter.remove();
            }
            
        }

        return maxsize;
    }

    private static class SubArr
    {
        int startIndex;
        int min, max;
        int length;
       
        public SubArr(int n, int location)
        {
            min = n; max = n;
            startIndex = location;
            length = 0;
        }

        private boolean canAdvance(int n, int limit)
        {
            return Math.abs(min - n) <= limit && Math.abs(max - n) <= limit;
        }

        private void advance(int n)
        {
            min = Math.min(min, n);
            max = Math.max(max, n);
            length++;
        }
    }
}

public class LongestContSubarray
{
    public static void main(String[] args)
    {
//        int test[] = {8,2,4,7};
//        int test[] = {4,2,2,2,4,4,2,2};

        int test[] = {9,10,1,7,9,3,9,9};
        System.out.println(new Solution().longestSubarray(test, 7));
    }
    
}
