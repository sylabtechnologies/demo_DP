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
