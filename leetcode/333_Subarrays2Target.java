// https://leetcode.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/

package subarrays2target;
import java.util.*;

class Solution
{
    public int minSumOfLengths(int[] arr, int target)
    {
        HashMap<Integer, Integer> prevSum = new HashMap<>();
        // keep interval fin for each length
        HashMap<Integer, Integer> intervalFin = new HashMap<>();
        ArrayList<Integer> lengthFound = new ArrayList<>();
        
        int currSum = 0;
        for (int i = 0; i < arr.length; i++)
        {
            currSum += arr[i];
            
            if (currSum == target)
            {
                int fin = i + 1;
                lengthFound.add(fin);
                
                intervalFin.put(fin, fin);
            }
            
            if (prevSum.containsKey(currSum - target))
            {
                int start = prevSum.get(currSum - target);
                int newLen = i + 1 - start;
                int fin = start + newLen;
                
                if (!intervalFin.containsKey(newLen))
                {
                    lengthFound.add(newLen);
                    intervalFin.put(newLen, fin);
                }
                else
                {
                    int prevFin = intervalFin.get(newLen);
                    
                    if (prevFin <= start)
                    {
                        lengthFound.add(newLen);
                        intervalFin.put(newLen, fin);
                    }
                }

            }
            
            prevSum.put(currSum, i + 1);
        }
        
        if (lengthFound.size() < 2) return -1;
        Collections.sort(lengthFound);
        return lengthFound.get(0) + lengthFound.get(1);
    }
}

public class Subarrays2Target
{
    public static void main(String[] args)
    {
        int arr[] = {1,2,2,3,2,6,7,2,1,4,8};
        System.out.println(new Solution().minSumOfLengths(arr, 5));
    }
}
