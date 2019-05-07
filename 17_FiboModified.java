/**
 * https://www.hackerrank.com/challenges/fibonacci-modified/problem
 */

package fibomodified;
import java.math.BigInteger;

public class FiboModified {

    public static void main(String[] args) {
        System.out.println(fibonacciModified(0, 1, 5));
    }

    private static BigInteger fibonacciModified(int t1, int t2, int n)
    {
        BigInteger tOne = BigInteger.valueOf(t1);
        BigInteger tTwo =  BigInteger.valueOf(t2);
        
        for (int i = 2; i < n; i++)
        {
            BigInteger next = tTwo.multiply(tTwo);
            next = tOne.add(next);
            tOne = tTwo;
            tTwo = next;
        }
        
        return tTwo;
    }
    
}
