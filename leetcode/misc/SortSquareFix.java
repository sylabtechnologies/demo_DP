/// https://leetcode.com/problems/squares-of-a-sorted-array/submissions/

/*
class Solution {
    public int[] sortedSquares(int[] A) {
        int[] ans = new int[A.length];
        
        int count = 0;
        for (int i : A)
            ans[count++] = i*i;

        Arrays.sort(ans);
        return ans;
    }
}
*/

package squaresort;

import java.util.Arrays;

class Solution
{
    public static int[] sortedSquares(int[] arr)
    {
        int[] ans = new int[arr.length];
        
        if (arr == null || arr.length == 0) return ans;

        if (arr.length == 1)
        {
            ans[0] = ans[0]*ans[0];
            return ans;
        }

        // 1. get non-neg
        int beg = 0, end = arr.length;
        int mid = 0;
        while (beg < end)
        {
            mid = beg + (end - beg) / 2;
            
            if (mid == 0) break;
            if (arr[mid - 1] < 0 && arr[mid] >= 0) break;
            
            if (arr[mid] > 0)
                end = mid;
            else
                beg = mid;
        }

        if (mid == 0)
        {
            for (int i = 0; i < arr.length; i++)
            {
                ans[i] = arr[i]*arr[i];
            }
            
            return ans;
        }
        
        beg = mid;
        end = mid - 1;

        int count = 0;
        boolean canGoLeft = true, canGoRight = true;
        
        while (canGoLeft && canGoRight)
        {
            int val = Math.abs(arr[end]);
            
            if (val > arr[beg])
            {
                val = arr[beg];
                beg++;
            }
            else end--;
            
            ans[count++] = val*val;
            
            if (beg == arr.length) canGoRight = false;
            if (end < 0) canGoLeft = false;
        }
        
        if (canGoRight)
        {
            int val = Math.abs(arr[beg++]);
            ans[count++] = val*val;
            if (beg == arr.length) canGoRight = false;
        }
        else if (canGoLeft)
        {
            int val = Math.abs(arr[end--]);
            ans[count++] = val*val;
            if (beg == arr.length) canGoRight = false;
        }
        
        return ans;
    }
}


public class SquareSort
{

    public static void main(String[] args)
    {
        int[] arr = {0, 2};
        
        System.out.println(Arrays.toString(Solution.sortedSquares(arr)));
    }
    
}
