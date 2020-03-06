package bitsort;
import java.util.*;

class Solution
{
    public int[] sortByBits(int[] arr)
    {
        MultiMap map = new MultiMap();
        
        for (int i : arr)
            map.put(bitCount(i), i);
        
        int[] res = new int[arr.length];
        int curr = 0;
        
        TreeMap<Integer, ArrayList<Integer>> mymap = map.map;
        
        for (Map.Entry<Integer, ArrayList<Integer>> entry : mymap.entrySet())
        {
            Integer key = entry.getKey();
            ArrayList<Integer> row = entry.getValue();
            Collections.sort(row);
            
            for (Integer i : row)
                res[curr++] = i;
            
        }
        
        return res;
    }
    
    public static int bitCount(int n) 
    { 
        int count = 0; 
        while (n > 0) 
        { 
            count += n & 1; 
            n >>= 1; 
        }
        
        return count; 
    }     
    
}

public class BitSort
{

    public static void main(String[] args)
    {
        int[] arr = {1024,512,256,128,64,32,16,8,4,2,1};
        Solution sol = new Solution();
        int[] res = sol.sortByBits(arr);
        System.out.println(Arrays.toString(res));
    }
    
}

