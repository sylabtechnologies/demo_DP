// https://leetcode.com/problems/bitwise-and-of-numbers-range/
package bitrange;

class Solution
{
    public int rangeBitwiseAnd(int m, int n)
    {
        if (m == 0) return 0;
        
        char[] lo = Integer.toBinaryString(m).toCharArray();
        char[] hi = Integer.toBinaryString(n).toCharArray();
        
        if (lo.length != hi.length) return 0;
        
        int tail = 0;
        for (int i = 0; i < hi.length; i++, tail++)
            if (hi[i] != lo[i]) break;
        
        for (int i = tail; i < hi.length; i++)
            hi[i] = '0';
        
        return Integer.parseInt(new String(hi), 2);
    }
}

public class BitRange
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().rangeBitwiseAnd(6, 7));
    }
    
}
        
