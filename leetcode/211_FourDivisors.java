package fourdivisors;
import java.util.*;

// 8 = 1 2 4 8

class Solution 
{
    private static final int SIZE = 50000;
    private static boolean seekPrimes = true;
    private static final TreeSet<Integer> primes = new TreeSet<>();
    
    public int sumFourDivisors(int[] nums)
    {
        if (seekPrimes) findPrimes();
        
        int ans = 0;
        for (int num : nums)
        {
            if (num <= 5) continue;;
            
            int count = 0;
            int divs[] = {0, 0};
            for (int p : primes)
            {
                if (p >= num) break;
                
                if (num % p == 0)
                {
                    if (count == 2)
                    {
                        count++;
                        break;
                    }

                    divs[count] = p;
                    count++;
                }
            }
            
            if (count == 2)
            {
                ans+= 1;                
                ans+= num + divs[0] + divs[1];
            }
        }

        return ans;
    }

    private void findPrimes()
    {
        int sieve[] = new int[SIZE];
        
        for (int i = 2; i <= SIZE; i++)
        {
            if (sieve[i-1] == 1) continue;
            
            int delta = i;
            for (int j = i + delta; j <= SIZE; j += delta)
                sieve[j-1] = 1;
        }

        for (int i = 2; i <= SIZE; i++)
        {
            if (sieve[i-1] == 0)
            {
                primes.add(i);
            }
        }
        
        // add other divisors
        ArrayList<Integer> secondary = new ArrayList<>();
        
        for (Integer p : primes)
        {
            for (Integer p1 : primes)
            {
                int nxt = p*p1;
                if (nxt > SIZE) break;
                secondary.add(nxt);
            }
        }

        for (Integer i : secondary)
        {
            primes.add(i);
        }
        
//        System.out.println(primes);
        
        seekPrimes = false;
    }
}

public class FourDivisors
{

    public static void main(String[] args)
    {
        Solution sl = new Solution();
        
        int nums[] = {7286,18704,70773,8224,91675};
        System.out.println(sl.sumFourDivisors(nums));
    }
    
}
