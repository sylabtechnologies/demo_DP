package amazonpackages;

// the original = store all in hash table and seek the difference

// in-place 1st try:
// try window from both ends
// 

import java.util.ArrayList;
import java.util.Collections;

public class Solution
{
    public final static int RESERVE = 30;

    public ArrayList<Integer> IDsOfPackages(int truckSpace, ArrayList<Integer> packages)
    {
        System.out.println(packages);
        
        if (packages.size() <= 2) throw new IllegalArgumentException("small packages");
        
        truckSpace -= RESERVE;
        if (truckSpace <= 0) throw new IllegalArgumentException("small truck");

        ArrayList<Integer> ans = new ArrayList<Integer>();
               
        int i = 0; 
        int j = packages.size() - 1;
        
        while (i < j)
        {
            int current = packages.get(i) + packages.get(j);

            if (current == truckSpace)
            {
                ans.add(i);
                ans.add(j);
                return ans;
            }
            else if (current < truckSpace)
            {
                i++;
            }
            else if (current > truckSpace)
            {
                j--;
            }
        }

        throw new IllegalArgumentException("no solution");
    }

}
