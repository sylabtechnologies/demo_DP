/**
 * https://leetcode.com/problems/sum-of-mutated-array-closest-to-target/
 *
*/

package mutatedsum;

import java.util.Arrays;

class Solution
{
    private static int cutoff(int len, int target)
    {
        int a = target/len;
        int d1 = Math.abs(target - a*len);

        int b = a + 1;
        int d2 = Math.abs(target - b*len);
        
        return (d1 > d2) ? b : a;
    }
    
    public static int findBestValue(int[] arr, int target)
    {
        int len = arr.length;
        if (len == 1) return Math.min(arr[0], target);
        
        Arrays.sort(arr);
        int sum = 0;
        
        for (int i = 0; i < arr.length; i++)
        {
            int cutoff = cutoff(len, target - sum);

            if (arr[i] > cutoff) return cutoff;
            
            sum += arr[i]; len--;
        }
        
        return arr[arr.length - 1];
    }
}

public class MutatedSum
{
    public static void main(String[] args)
    {
        int[] arr = {2, 3,5 };
        System.out.println(Solution.findBestValue(arr, 10));
    }
    
}
