// https://leetcode.com/problems/simplified-fractions/
package simplefractions;
import java.util.*;

class Solution
{
    public List<String> simplifiedFractions(int n)
    {
        List<String> res = new ArrayList<>();
        if (n == 1) return res;
        
        for (int i = 2; i <= n; i++)
        {
            String base = "/" + Integer.toString(i);
            for (int j = 1; j < i; j++)
            {
                if (gcd(j, i) != 1) continue;
                
                String curr = Integer.toString(j) + base;
                res.add(curr);
            }
        }
            
        return res;
    }

    private int gcd(int m, int n)
    {
        if (m < n)
        {
            int temp = n;
            n = m; m = temp;
        }
        
        return (n == 0) ? m : gcd(m % n, n);
    }
}

public class SimpleFractions
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().simplifiedFractions(4));
    }
    
}

