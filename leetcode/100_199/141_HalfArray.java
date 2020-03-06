// https://leetcode.com/problems/reduce-array-size-to-the-half/

package halfarray;
import java.util.*;

class Solution
{
    public static int minSetSize(int[] arr)
    {
        HashMap<Integer, Integer> rank = new HashMap<>();
        
        for (int i : arr)
        {
            Integer val = rank.getOrDefault(i, 0);
            rank.put(i, val + 1);
        }

        ArrayList<Integer> ord = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : rank.entrySet())
            ord.add(entry.getValue());

        Collections.sort(ord);
        Collections.reverse(ord);
        
        int ans = 0;
        int size = arr.length;
        int hSize = size/2;
        
        int curr = 0;
        while (size > hSize && curr < ord.size())
        {
            size -= ord.get(curr);
            ans++;
            curr++;
        }
        
        return ans;
    }
}

public class HalfArray
{

    public static void main(String[] args)
    {
        int[] arr = {3,3,3,3,5,5,5,2,2,7};
        
        System.out.println(Solution.minSetSize(arr));
    }
    
}
