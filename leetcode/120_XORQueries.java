// https://leetcode.com/problems/xor-queries-of-a-subarray/
// map-on-map as if interval tree (put all onto R?)

package xorqueries;

import java.util.*;

public class Solution
{
    public int[] xorQueries(int[] arr, int[][] queries)
    {
        Map<Integer, TreeMap<Integer, Integer> > map = new HashMap<>();
        
        for (int[] q : queries)
        {
            int x = q[0], y = q[1];
            
            TreeMap<Integer, Integer> chain = map.get(x);
            if (chain != null)
                chain.put(y, 0);
            else
            {
                chain = new TreeMap<>();
                chain.put(y, -1);
                map.put(x, chain);
            }
        }
        
        // chain xors
        for (Map.Entry<Integer, TreeMap<Integer, Integer> > row : map.entrySet())
        {
            TreeMap<Integer, Integer> chain = row.getValue();
            Integer key = row.getKey();
            
            Integer prev = null;
            int xor = 0;
            
            for (Map.Entry<Integer, Integer> elem : chain.entrySet())
            {
                Integer next = elem.getKey();
                
                if (prev == null)
                    xor = getXor(arr, key, next);
                else
                {
                    int nextXor = getXor(arr, prev + 1, next);
                    xor = xor ^ nextXor;
                }
                
                prev = next;
                chain.put(next, xor);
            }
        }
        
        int[] res = new int[queries.length];
        int count = 0;
        
        for (int[] q  : queries)
        {
            TreeMap<Integer, Integer> chain = map.get(q[0]);
            res[count] = chain.get(q[1]);
            count++;
        }
        
        return res;
    }

    private int getXor(int[] arr, int start, int end)
    {
        if (start == end) return arr[start];
        
        int ans = 0;
        for (int i = start; i <= end; i++)
            ans = ans ^ arr[i];

        return ans;
    }
    
}
