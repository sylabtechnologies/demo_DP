// https://leetcode.com/problems/largest-perimeter-triangle/

package triperimeter;
import java.util.Arrays;

class Solution
{
    public int largestPerimeter(int[] arr)
    {
        Arrays.sort(arr);
        
        // #D seem to be on the right side
        int curr = arr.length - 1;
        while (curr >= 0)
        {
            int max = arr[curr];
            int test = canTriangle(arr, curr - 1, max);
            
            if ( test > 0)
                return test + max;
            else
                curr--;
        }
        
        return 0;
    }

    private int canTriangle(int[] arr, int i, int max)
    {
        int test = 0;
        
        int count = 0;
        while (i >= 0)
        {
            test += arr[i];
            i--; count++;
            
            if (count == 2) break;
        }
        
        if (count != 2) return 0;
        if (test <= max) return 0;
        return test;
    }
}


public class TriPerimeter
{
    public static void main(String[] args)
    {
        int test[] = { 3, 2, 3, 4 };
        System.out.println(new Solution().largestPerimeter(test));
    }
    
}
