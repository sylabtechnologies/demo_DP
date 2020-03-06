package finddouble;
import java.util.*;

class Solution {
    public static boolean checkIfExist(int[] arr)
    {
        HashSet<Integer> set = new HashSet<>();
        int zeroCnt = 0;
        for (int i : arr)
        {
            if (i != 0)
                set.add(i);
            else
                zeroCnt++;
        }
        
        if (zeroCnt > 1) return true;
        
        for (int i : set)
        {
            if (set.contains(2*i))
                return true;
            
            if (i % 2 == 0)
            {
                if (set.contains(i/2))
                    return true;
            }
            
        }
        
        return false;
    }
}

public class FindDouble
{

    public static void main(String[] args)
    {
        int[] arr = {-2,0,10,-19,4,6,-8};
        System.out.println(Solution.checkIfExist(arr));
    }
    
}
