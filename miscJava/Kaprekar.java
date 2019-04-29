// kaprekar numbers

package solution;
import java.io.*;
import java.util.*;

public class Solution
{
    private static final Scanner scanner = new Scanner(System.in);
    
    private static String intToString(long n)
    {
        StringBuilder sb = new StringBuilder();
        
        while(n != 0)
        {
            long digit = n % 10 + 48;
            char c = (char) digit;
            sb.append(c);
            
            n = n/10;
        }
        
        return sb.reverse().toString();
    }

   static void kaprekarNumbers(int p, int q)
   {
       int count = 0;
       
       for (long n = p; n < q; n++)
       {
           if (n < 4)
           {
               if (n == 1)
               {
                    System.out.print("1 ");
                    count++;
               }
               
               continue;
           }
           
           String square = intToString(n * n);

           int cut = square.length() / 2;

           int n1 = Integer.valueOf(square.substring(0, cut));
           int n2 = Integer.valueOf(square.substring(cut));
           
           if (n1 + n2 == n)
           {
               System.out.print(n + " ");
                count++;
           }
       }
       
       if (count == 0)
            System.out.println("INVALID RANGE");
       else
            System.out.println("");

   }
    
    
    public static void main(String[] args) throws IOException
    {
//        int hh = scanner.nextInt();
//        int mm = scanner.nextInt();
  
        kaprekarNumbers(1, 100000);
        
//        System.out.println(intToString(5978));
    }    

}
