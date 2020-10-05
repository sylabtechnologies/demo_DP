// https://leetcode.com/problems/complement-of-base-10-integer/
package goog7;
import java.util.*;

// the dude says XOR it
class Solution
{
    public int bitwiseComplement(int N)
    {
        if (N == 0) return 1;
        
        int allOnes = 0, temp = N;
        while (temp > 0)
        {
            temp = temp >> 1;
            allOnes++;
            if (temp > 0) allOnes = allOnes << 1;
        }
        
        return N ^ allOnes;
    }
}

public class Goog7
{
    public static void main(String[] args)
    {
        int arr[] = {5,7,10};
        for (int i : arr)
            System.out.println(new Solution().bitwiseComplement(i));
    }
}
