// magnetic force

package aug2;
import java.util.*;

class Solution
{
    public int maxDistance(int[] arr, int k)
    {
        Arrays.sort(arr);
        int n = arr.length;
        
        int hi = arr[n-1] - arr[0];
        if (k == 2) return hi;
        
        int lo = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++)
        {
            int d = arr[i] - arr[i - 1];
            if (d < lo) lo = d;
        }

        int result = -1;
        while (lo < hi) 
        { 
            int mid = lo + (hi - lo) / 2;

            if (canDo(mid, arr, n, k)) 
            { 
                result = Math.max(result, mid); 
                lo = mid + 1;
            } 

            else
                hi = mid; 
        } 

        return result; 
    }
    
    boolean canDo(int mid, int arr[],  int n, int k) 
    { 
        int pos = arr[0]; 
        int numElem = 1; 

        for (int i = 1; i < n; i++) 
        { 
            if (arr[i] - pos >= mid) 
            { 
                pos = arr[i]; 
                numElem++; 

                if (numElem == k)  return true; 
            } 
        } 
        
        return false; 
    }     
}

public class Aug2
{
    public static void main(String[] args)
    {
        // int arr[] = {85,24,66,57,71,43,62,93,35,23,41,8,92,96,63,77,75,26,79,78};
        
        int arr[] = {5,4,3,2,1,1000000000};
        System.out.println(new Solution().maxDistance(arr, 2));
    }
}
