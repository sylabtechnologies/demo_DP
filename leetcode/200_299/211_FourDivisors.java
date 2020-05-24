// https://leetcode.com/problems/four-divisors/

package fourdivisors;
import java.util.*;

class Solution 
{
    private static final int SIZE = 100000;
    private static final int primeSize;
    private static final TreeSet<Integer> primes;
    private static final HashSet<Integer> other;
    
    static
    {
        primeSize = (int) (Math.sqrt(SIZE) + 1);
        primes    = new TreeSet<>(getPrimes(primeSize));
        other     = getPrimes(SIZE);
        other.removeAll(primes);
    }
    
    public int sumFourDivisors(int[] nums)
    {
        int ans = 0;
        for (int num : nums)
        {
            if (num <= 5) continue;
            
            List<Integer> divs = getPrimeFactors(num);
            System.out.println(" n = " + num + " : " + divs.toString());
            
            if (divs.isEmpty()) continue;
            
            int x = divs.get(0);
            if (divs.size() == 2)
            {
                if (x * divs.get(1) == num)
                    ans+= 1 + num + x + divs.get(1);
            }
            else if (divs.size() == 1)
            {
                int test = num / x;

                int x2 = x*x;
                if (num == x2) continue;

                if (other.contains(test) || test == x2)
                {
                    ans+= 1 + num + divs.get(0) + test;
                }
            }
        }

        return ans;
    }

    private static List<Integer> getPrimeFactors(int num)
    {
        List<Integer> result = new ArrayList();

        int count = 0;
        int stop = num/2 + 1;
        for (int p : primes)
        {
            if (p >= stop) break;

            if (num % p == 0)
            {
                result.add(p);
                count++;
                if (count > 3) break;
            }
        }

        return result;
    }
    
    private static HashSet<Integer> getPrimes(int size)
    {
        HashSet<Integer> result = new HashSet<>();
        boolean sieve[] = new boolean[size];
        
        for (int i = 2; i <= size; i++)
        {
            if (sieve[i-1]) continue;
            
            int delta = i;
            for (int j = i + delta; j <= size; j += delta)
                sieve[j-1] = true;
        }

        for (int i = 2; i <= size; i++)
        {
            if (!sieve[i-1]) result.add(i);
        }
        
//        System.out.println(result);
        return result;
    }

}

public class FourDivisors
{

    public static void main(String[] args)
    {
        Solution sl = new Solution();
        
//        int nums[] = {21, 4, 7};
//        int nums[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int nums[] = {7286,18704,70773,8224,91675};
//        int nums[] = {90779,36358,90351,75474,32986};

        System.out.println(sl.sumFourDivisors(nums));
    }
    
}
