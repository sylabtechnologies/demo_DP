// https://www.hackerrank.com/challenges/cut-the-sticks/problem
// @alalmeht

package solution;
import java.util.*;

public class Solution
{
    // Complete the cutTheSticks function below.
    static int[] cutTheSticks(int[] arr)
    {
        if (arr.length == 0)
            throw new IllegalArgumentException("grid must be full");

        Arrays.sort(arr);
        
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(arr.length);
        int currentCut = arr[0];
        int advance = 1;
        
        // just browsing states
        while (advance < arr.length)
        {
            if (currentCut != arr[advance])
            {
                currentCut = arr[advance];
                ans.add(arr.length - advance);
            }

            advance++;
        }
        
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++)
        {
            res[i] = ans.get(i);
        }
        return res;
    }

    public static void main(String []args)
    {
        int[] arr = {1, 2, 3};

        System.out.println(Arrays.toString(cutTheSticks(arr)));
        
    }

}
