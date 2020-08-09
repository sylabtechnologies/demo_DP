// https://leetcode.com/problems/maximum-number-of-non-overlapping-subarrays-with-sum-equals-target/

package subarraysdisjnt;
import java.util.*;

class Solution
{
    public int maxNonOverlapping(int[] nums, int target)
    {
        int currSum = 0;
        
        MultiMap<Integer, Interval> prevSum = new MultiMap<>();
        HashSet<Integer> prevKey = new HashSet<>();
        ArrayList<Interval> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++)
        {
            currSum += nums[i];
            
            if (currSum == target)
            {
                Interval ir = new Interval(0, i, target);
                res.add(ir);
            }
            
            if (prevKey.contains(currSum - target))
            {
                ArrayList<Interval> row = prevSum.getRow(currSum - target);
                for (Interval ir : row)
                {
                    Interval xsect = new Interval(ir.end + 1, i, target);
                    res.add(xsect);
                }
            }
            
            prevKey.add(currSum);
            prevSum.put(currSum, new Interval(0, i, currSum));
        }

        Collections.sort(res);
//        System.out.println(res);
        
        // http://www.csc.kth.se/utbildning/kth/kurser/DD2458/popup08/anteckningar/lecnotes01/lecnotes01.pdf
        int count = 0;
        boolean visited[] = new boolean[res.size()];
        for (int i = 0; i < res.size(); i++)
        {
            if (visited[i]) continue;
            
            Interval ir = res.get(i);
            visited[i] = true;
            
            count++;
            int minLen = ir.end - ir.beg + 1;
            int myEnd = ir.end, minIx = i;
            for (int j = i + 1; j < res.size(); j++)
            {
                if (visited[j]) continue;

                Interval cmp = res.get(j);
                if (cmp.end != myEnd) break;
                
                visited[j] = true;
                if (cmp.end - cmp.beg + 1 < minLen)
                {
                    minIx = j; minLen = cmp.end - cmp.beg + 1;
                }
            }
            
            for (int j = i + 1; j < res.size(); j++)
            {
                if (visited[j]) continue;
                if (res.get(j).beg <= myEnd)
                    visited[j] = true;
            }
        }
        
        return count;
    }
    
    private static class Interval implements Comparable<Interval>
    {
        int beg, end;
        int val;

        private Interval(int x, int y, int val)
        {
            this.beg = x;
            this.end = y;
            this.val = val;
        }

        @Override
        public String toString()
        {
            return "[" + beg + ", " + end + "] =" + val ;
        }

        @Override
        public int compareTo(Interval ir)
        {
            if (this.end == ir.end)
                return this.beg - ir.beg;
            else
                return this.end - ir.end;
        }
    }
}

public class SubarraysDisjnt
{
    public static void main(String[] args)
    {
        int arr[] = {-1,3,5,1,4,2,-9};
        System.out.println(new Solution().maxNonOverlapping(arr, 6));
    }
    
}
