// https://www.hackerrank.com/challenges/java-bigdecimal/problem
// 9 -100 50 0 56.6 90 0.12 .12 02.34 000.000

package solution;

import java.math.BigDecimal;
import java.util.*;

class BigDec implements Comparable
{
    private BigDecimal value;
    private String origin;
    
    BigDec(String s)
    {
        origin = s;
        value = new BigDecimal(s);
    }

    @Override
    public int compareTo(Object rhs)
    {
        if(!(rhs instanceof BigDec))
            throw new IllegalArgumentException("Incompatible objects");
    
        return value.compareTo(((BigDec)rhs).value);
    }

    @Override
    public String toString()
    {
        return origin;
    }
    
}

class Solution
{
    public static void main(String []args){
        //Input
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();

        String []s=new String[n+2];
        for(int i=0;i<n;i++)
        {
            s[i]=sc.next();
        }
        sc.close();

        BigDec[] bd = new BigDec[n];
        
        for(int i=0; i< n; i++)
        {
            bd[i] = new BigDec(s[i]);
        }
        
        Arrays.sort(bd);

        //Output
        for(int i=0;i < n; i++)
        {
            s[i] = bd[i].toString();
        }
    }
}
