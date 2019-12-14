// https://leetcode.com/problems/unique-binary-search-trees/
// - find recursion & memoize

package uniquebst;
import java.util.Arrays;

public class Solution
{
    private static int[] mem;
    
    public static int numTrees(int n)
    {
        if (n <= 0) return 0;
        if (n < 3)  return n;
        
        mem = new int[n+1];
        Arrays.fill(mem, -1); mem[1] = 1; mem[2] = 2;
            
        return numRecursive(n);
    }    

    private static int numRecursive(int n)
    {
        if (mem[n] > 0 ) return mem[n];
        
        int count = 2*numRecursive(n-1);
        
        for (int i = 1; i < n-1; i++)
        {
            count += numRecursive(i)*numRecursive(n - i - 1);
        }
        
        mem[n] = count;
        return count;
    }
}
