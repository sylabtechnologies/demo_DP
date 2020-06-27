// https://leetcode.com/problems/perfect-squares/
package perfectsquares;
import java.util.*;

class Solution
{
    private TreeSet<Integer> squares;
    
    // cant find 3 return 4 per Lagrange
    public int numSquares(int n)
    {
        int i = 1;
        squares = new TreeSet<>();
        
        while (true)
        {
            int sq = i*i;
            if (sq == n) return 1;
            if (sq > n) break;
            
            squares.add(sq);
            i++;
        }
        
        if (find2sum(n)) return 2;
        
        for (int sq : squares)
        {
            int target = n - sq;
            if (find2sum(n - sq)) return 3;
        }
        
        return 4;
    }

    private boolean find2sum(int target)
    {
        for (int sq : squares)
        {
            if (sq > target - 1) break;
            if (squares.contains(target - sq)) return true;
        }
        
        return false;
    }
}

public class PerfectSquares
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().numSquares(12));
    }
}
