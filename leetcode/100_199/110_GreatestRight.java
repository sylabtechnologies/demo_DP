// https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/

package nextgreatest;
import java.util.*;

class Solution
{
    public static int[] replaceElements(int[] arr)
    {
        if (arr.length == 0) return new int[0];

        int[] ans = new int[arr.length];
        ans[arr.length - 1] = -1;
        int max = arr[arr.length - 1];

        for (int i = arr.length - 2; i >= 0; i--)
        {
            ans[i]   = max;
            max = (arr[i] > max) ? arr[i] : max;
        }

        return ans;
    }
}

public class NextGreatest
{

    public static void main(String[] args)
    {
        int[] arr = {17,18,5,4,6,1};
        
        int[] ans = Solution.replaceElements(arr);
        System.out.println(Arrays.toString(ans));
    }
    
}
