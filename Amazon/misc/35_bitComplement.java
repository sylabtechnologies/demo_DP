// https://leetcode.com/problems/complement-of-base-10-integer/
package complement;

class Solution
{
    public int bitwiseComplement(int num)
    {
        boolean isNegative = false;
        if (num < 0)
        {
            isNegative = true;
            num = - num;
        }
        
        boolean bitSet[] = new boolean[32];
        int bitlen = 0;
        final int bit = 1;
        
        while (num > 0)
        {
            if ( (num & bit) == 1)
                bitSet[bitlen++] = false;
            else
                bitSet[bitlen++] = true;
            
            num = num >> 1;
        }
        
        int ans = 0;
        if (bitlen == 0) ans = 1;
        
        for (int i = bitlen - 1; i >= 0; i--)
        {
            ans = ans << 1;
            if (bitSet[i]) ans += 1;
        }
        
        return (isNegative) ? -ans : ans;
    }
}

public class Complement
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().bitwiseComplement(-10));
    }
}
