// https://leetcode.com/problems/rank-transform-of-an-array/submissions/

package rankxform;
import java.util.*;

class Solution {
    public int[] arrayRankTransform(int[] arr)
    {
        if (arr == null) return null;
        if (arr.length == 0) return new int[0];
        
        TreeMap<Integer, Integer> rank = new TreeMap<>();
        
        for (int i : arr)
            rank.put(i, 0);

        int curr = 0;
        for (Map.Entry<Integer, Integer> entry : rank.entrySet())
            entry.setValue(++curr);
        
        int[] res = new int[arr.length];
        int count = 0;
        for (int i : arr)
        {
            res[count] = rank.get(i);
            count++;
        }
        
        return res;
    }
}

public class RankXform
{

    public static void main(String[] args)
    {
        int[] arr = {37,12,28,9,100,56,80,5,12};

        System.out.println(Arrays.toString(Solution.arrayRankTransform(arr)));
    }
    
}
