/** 166W
 * There are n people whose IDs go from 0 to n - 1 and each person belongs
 * exactly to one group.
 * Given the array groupSizes of length n telling the group size each person
 * belongs to, return the groups there are and
 * the people's IDs each group includes.
 */

package groupsizes;

import java.util.*;

class Solution
{
    public List<List<Integer>> groupThePeople(int[] groupSizes)
    {
        ArrayList<Pair> arr = new ArrayList<>();

        int max = 0;
        for (int i = 0; i < groupSizes.length; i++)
        {
            int val = groupSizes[i];
            arr.add(new Pair(val, i));
            if (val > max) max = val;                
        }
        Collections.sort(arr);
        
        // ystem.out.println(arr);
        
        List<List<Integer>> ans = new ArrayList<>();
        int curr = 0;
        while (curr < arr.size())
        {
            int len = arr.get(curr).value;
            List<Integer> row = new ArrayList<>();
            
            for (int i = 0; i < len; i++)
                row.add(arr.get(curr + i).index);
            
            ans.add(row);
            
            if (curr + len == arr.size())
                break;
            else
                curr += len;
        }
        
        return ans;
    }    

    private class Pair implements Comparable<Pair>
    {
        int value;
        int index;

        public Pair(int value, int index)
        {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Pair o)
        {
            if (this.value < o.value)
                return -1;
            else if (this.value == o.value)
                return 0;
            else return 1;
        }

        @Override
        public String toString()
        {
            return "(" + value + ", " + index + ")";
        }

    }
    
}