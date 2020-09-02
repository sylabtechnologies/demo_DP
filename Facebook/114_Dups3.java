package dups3;
import java.util.*;

class Solution
{
    public boolean containsNearbyAlmostDuplicate(int[] arr, int timeDiff, int valDiff)
    {
        if (valDiff < 0) return false;
        TreeSet<Long> set = new TreeSet<>(); 
  
        for (int i = 0; i < arr.length; i++) 
        { 
            if (i > timeDiff)
                set.remove((long) arr[ i - timeDiff - 1]); 

            long lval = (long) arr[i];
            if (set.contains(lval))
                return true;
            
            Long up = set.ceiling(lval);
            if ( up != null && up - lval <= valDiff)
                return true;

            Long down = set.floor(lval);
            if (down != null && lval - down <= valDiff)
                return true;
            
            set.add(lval); 
        } 
        
        return false;         
    }
}

public class Permut
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().containsNearbyAlmostDuplicate(new int[] {-1,2147483647}, 1, 2147483647 )); 
    }
    
}

/*

[-1,2147483647]
1
2147483647
        ArrayList<Pair> sorted = new ArrayList<>();
        for (int i = 0; i < nums.length; i++)
            sorted.add(new Pair(nums[i], i));
        Collections.sort(sorted);
        
        System.out.println(sorted);
        int beg = 0, end = 1;
        while (end < sorted.size())
        {
            for (int i = beg; i <= end ; i++)
                System.out.print(sorted.get(i) + " ");
            System.out.println();
            
            if (sorted.get(end).val - sorted.get(beg).val <= valDiff)
            {
                
                
//                int dist = Math.abs(sorted.get(end).index - sorted.get(beg).index);
//                if (dist <= timeDiff) return true;
                end++;
            }
            else
            {
                beg++;
            }
            
            if (beg == end) end++;
            
        }

        return false;
    }

    private static class Pair implements Comparable<Pair>
    {
        final int val, index;
        public Pair(int val, int index) { this.val = val; this.index = index; }
        @Override
        public int compareTo(Pair p) { return this.val - p.val;};

        @Override
        public String toString() {
            return "(" + val + " @ " + index + ")";
        }
        
    }
*/
