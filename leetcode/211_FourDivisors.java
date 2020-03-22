package fourdivisors;
import java.util.*;

// FIX!
// https://www.dcode.fr/divisors-list-number

class Solution 
{
    private static final int SIZE = 320;
    private static final Set<Integer> primes = getPrimes(SIZE);
    
    public int sumFourDivisors(int[] nums)
    {
        int ans = 0;
        for (int num : nums)
        {
            if (num <= 5) continue;
            
            List<Integer> divs = getDivisors(num);
//            System.out.println(" n = " + num + " : " + divs.toString());
            
            if (divs.size() == 2)
            {
                if (num == (divs.get(0) * divs.get(1)))
                    ans+= 1 + num + divs.get(0) + divs.get(1);
            }
            else if (divs.size() == 1)
            {
                int d = divs.get(0);
                int test = num / d;
                if ( test == d*d)
                    ans+= 1 + num + divs.get(0) + (num/divs.get(0));
            }
        }

        return ans;
    }

    private static List<Integer> getDivisors(int num)
    {
        List<Integer> result = new ArrayList();

        int count = 0;
        for (int p : primes)
        {
            if (p >= num) break;

            if (num % p == 0)
            {
                result.add(p);
                count++;
                if (count > 3) break;
            }
        }

        return result;
    }
    
    private static TreeSet<Integer> getPrimes(int size)
    {
        TreeSet<Integer> result = new TreeSet<>();
        int sieve[] = new int[size];
        
        for (int i = 2; i <= size; i++)
        {
            if (sieve[i-1] == 1) continue;
            
            int delta = i;
            for (int j = i + delta; j <= size; j += delta)
                sieve[j-1] = 1;
        }

        for (int i = 2; i <= size; i++)
        {
            if (sieve[i-1] == 0) result.add(i);
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
        
        int nums[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        int nums[] = {7286,18704,70773,8224,91675};
//        int nums[] = {90779,36358,90351,75474,32986};
        System.out.println(sl.sumFourDivisors(nums));
    }
    
}