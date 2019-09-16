package amazonpackages;

// 1st try
// try window from both ends
// modify the problem: find max combo to fit into truck minus reserve
// (solve the original w/ hash table of differences)

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
        int delta = truckSpace*10;
        
        while (i < j)
        {
            int current  = packages.get(i) + packages.get(j);
            int curDelta = truckSpace - current;
            
            if (curDelta < 0)
            {
                j--;
                continue;
            }
            
            if (curDelta < delta)
            {
                delta = curDelta;
                ans.clear();
                ans.add(i);
                ans.add(j);
                if (delta == 0) break;
                i++;
                continue;
            }
            else if (curDelta == delta)
            {
                j--;
                continue;
            }
            
        }

        if (ans.isEmpty()) throw new IllegalArgumentException("no solution");
        return ans;
    }

}
