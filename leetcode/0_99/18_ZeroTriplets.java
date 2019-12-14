package zerotriplets;
import java.util.*;

/** https://fizzbuzzed.com/top-interview-questions-1/
 * sort array & run each section from both ends in ~ O(n*n)
 */

public class Solution
{
    public List<List<Integer>> threeSum(int[] arr)
    {
        List<List<Integer>> ans = new ArrayList<>();
        if (arr.length < 3) return ans;
        Arrays.sort(arr);
        
        for (int i = 0; i < arr.length; i++)
        {
            // no dups
            if (i != 0 && arr[i-1] == arr[i]) continue;
            
            int j = i + 1;
            int k = arr.length - 1;
            
            while (j < k)
            {
                if (arr[i] + arr[j] + arr[k] == 0)
                {
                    List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                    ans.add(temp);
                    j++;
                    // no dups
                    while (j < k && arr[j] == arr[j-1]) ++j;
                }
                else if (arr[i] + arr[j] + arr[k] < 0)
                    j++;
                else
                    k--;
            }
            
        }

        return ans;
    }
    
}
