package goog9;
import java.util.*;

/* https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/
   freq-associative gcd
*/

class Solution
{
    public boolean hasGroupsSizeX(int[] deck)
    {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int card : deck)
        {
            int fr = count.getOrDefault(card, 0) + 1;
            count.put(card, fr);
        }
        
        int freq[] = new int[count.size()], cur = 0;
        for (Map.Entry<Integer, Integer> elem : count.entrySet())
        {
            int fr = elem.getValue();
            freq[cur++] = fr;
        }
        
        if (freq.length == 1)
            return freq[0] > 1;
        
        int gcd = freq[0];
        for (int i = 1; i < freq.length; i++)
        {
            gcd = findGcd(freq[i], gcd);
            if (gcd == 1) return false;
        }
        
        return true;
    }

    private int findGcd(int a, int b)
    {
        if (a == 0)  return b; 
        return findGcd(b % a, a);
    }
}

public class Goog9
{
    public static void main(String[] args)
    {
        int arr[] = {1};  //  {1,2,3,4,4,3,2,1};
        System.out.println(new Solution().hasGroupsSizeX(arr));
        
//        List<List<Integer>> seqs = new ArrayList<>();
//        for (int[] row : arr2)
//            seqs.add(int2lst(row));
//        System.out.println(new Solution().sequenceReconstruction(arr, seqs));
    }

    private static List<Integer> int2lst(int[] row)
    {
        List<Integer> ret = new ArrayList<>(row.length);
        for (int x : row) ret.add(x);
        return ret;
    }
    
}
