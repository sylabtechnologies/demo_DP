// https://leetcode.com/problems/relative-sort-array/
package relativesort;
import java.util.*;

class Solution
{
    public int[] relativeSortArray(int[] arr1, int[] arr2)
    {
        HashMap<Integer, Integer> counts = new HashMap<>();
        ArrayList<Integer> tail = new ArrayList<>();
        
        // map
        for (int i = 0; i < arr2.length; i++)
            counts.put(arr2[i], 0);

        // split
        for (int i = 0; i < arr1.length; i++)
        {
            if (counts.containsKey(arr1[i]))
            {
                int count = counts.get(arr1[i]);
                counts.put(arr1[i], count + 1);
            }
            else
                tail.add(arr1[i]);
        }
        Collections.sort(tail);
        
        // combo
        int[] ans = new int[arr1.length];
        
        int k = 0;
        for (int i = 0; i < arr2.length; i++)
        {
            int count = counts.get(arr2[i]);
            for (int j = 0; j < count; j++, k++)
                ans[k] = arr2[i];
        }
        
        for (int j = 0; j < tail.size(); j++, k++)
            ans[k] = tail.get(j);
        
        return ans;
    }
}

public class RelativeSort
{
    public static void main(String[] args)
    {
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};
        
        Solution sol = new Solution();
        int[] ans = sol.relativeSortArray(arr1, arr2);
        for (int i = 0; i < ans.length; i++)
            System.out.print(ans[i] + " ");
    }
}
