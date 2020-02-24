// https://leetcode.com/problems/closest-divisors/submissions/
package closestdivisors;
import java.util.ArrayList;

class Solution
{
    private static int[] getDivisors(int num)
    {
        int sqr = (int) Math.sqrt(num);
        
        for (int i = sqr + 1; i >= 1; i--)
            if (num % i == 0)
                return new int[] { i, num/i};
        
        return new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE };
    }
    
    public int[] closestDivisors(int num)
    {
        if (num == 1) return new int[] {1, 2};
        
        int[] close1 = getDivisors(num + 1);
        int[] close2 = getDivisors(num + 2);

        int d1 = Math.abs(close1[0] - close1[1]);
        int d2 = Math.abs(close1[0] - close2[1]);
        
        return (d1 < d2) ? close1 : close2;
    }

}

public class ClosestDivisors {

    public static void main(String[] args)
    {
        Solution sol = new Solution();
        int [] ans = sol.closestDivisors(123);
        System.out.println(Arrays.toString(ans));
    }
    
}
