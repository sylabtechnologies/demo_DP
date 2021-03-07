package goog49;
import java.util.*;

//_ https://leetcode.com/problems/check-array-formation-through-concatenation/
// w/ pieces map
class Solution 
{
    public boolean canFormArray(int[] arr, int[][] pieces) 
    {
        HashMap<Integer, int[]> pmap = new HashMap<>();
        for (int i = 0; i < pieces.length; i++) 
        {
            int[] pc = pieces[i];
            pmap.put(pc[0], pc);            
        }
        
        int i = 0;
        while (i < arr.length)
        {
            int key = arr[i];
            if (!pmap.containsKey(key)) return false;
            
            int[] pc = pmap.get(key);
            for (int j = 0; j < pc.length; j++) 
            {
                if (i + j >= arr.length) return false;
                if (pc[j] != arr[i + j]) return false;
            }
            
            i += pc.length;
        }
        
        return true;
    }
}

public class Goog49
{
    public static void main(String[] args)
    {
        int arr[] = {15,88}, pieces[][] = {{88},{15}};
        System.out.println(new Solution().canFormArray(arr, pieces));
    }
}

