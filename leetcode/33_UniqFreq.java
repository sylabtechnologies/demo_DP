package temp245;

/*
Given an array of integers arr, write a function that returns true if and only
if the number of occurrences of each value in the array is unique.
*/

import java.util.HashMap;
import java.util.Map;

class Solution
{
    public boolean uniqueOccurrences(int[] arr)
    {
        HashMap<Integer, Integer> freq = new HashMap<>();
        
        for (int i : arr)
        {
            int f = freq.getOrDefault(i, 0);
            freq.put(i, f + 1);
        }
        
        int[] occurs = new int[2001];
        for (Map.Entry<Integer,Integer> elem : freq.entrySet())
        {
            int index = elem.getValue() + 1000;

            if (occurs[index] > 0)
                return false;
            else
                occurs[index] = 1;
        }
        
        return true;
    }
    
}

public class Temp245
{
    
    public static void main(String[] args)
    {
        int[] arr = { -3,0,1,-3,1,1,1,-3,10,0 };
        Solution sol = new Solution();
        System.out.println(sol.uniqueOccurrences(arr));
    }
    
}
