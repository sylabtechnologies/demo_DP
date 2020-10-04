// https://leetcode.com/problems/minimum-one-bit-operations-to-make-integers-zero/
package goog5;
import java.util.*;

class Solution
{
    public int minimumOneBitOperations(int n)
    {
        // ret Gray code to decimal
        int res = 0;
        while (n > 0)
        {
            res ^= n;
            n = n >> 1;
        }
        
        return res;        
    }
}
