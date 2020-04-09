// https://leetcode.com/problems/integer-replacement/
package integerrecursion;

/// #D branch into bst
class Solution
{
    public int integerReplacement(int n) 
    {
        return recursiveHelper(n, 0);
    }

    private int recursiveHelper(int n, int numSteps)
    {
        if (n == 1) return numSteps;
        if (n == 2147483647) return 32;
        
        if (n % 2 == 0)
            return recursiveHelper(n/2, numSteps + 1);
        else
            return Math.min(recursiveHelper(n+1, numSteps + 1), recursiveHelper(n - 1, numSteps + 1));
    }
}

public class IntegerRecursion
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().integerReplacement(65535));
    }
}
