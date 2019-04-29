// apparently further encap and func plural

package solution;
import java.io.*;
import java.util.*;

public class Solution
{
    private static final Scanner scanner = new Scanner(System.in);
    
    private static final Map<Integer, String> wordmap = new HashMap<>();
    
    static
    {
        wordmap.put(0, "o' clock");
        wordmap.put(1, "one");
        wordmap.put(2, "two");
        wordmap.put(3, "three");
        wordmap.put(4, "four");
        wordmap.put(5, "five");
        wordmap.put(6, "six");
        wordmap.put(7, "seven");
        wordmap.put(8, "eight");
        wordmap.put(9, "nice");
        wordmap.put(10, "ten");

        wordmap.put(11, "eleven");
        wordmap.put(12, "twelve");
        wordmap.put(13, "thirteen");
        wordmap.put(14, "fourteen");
        wordmap.put(15, "quarter");
        wordmap.put(16, "sixteen");
        wordmap.put(17, "seventeen");
        wordmap.put(18, "eighteen");
        wordmap.put(19, "nineteen");
        wordmap.put(20, "twenty");
        wordmap.put(21, "twenty one");
        wordmap.put(22, "twenty two");
        wordmap.put(23, "twenty three");
        wordmap.put(24, "twenty four");
        wordmap.put(25, "twenty five");
        wordmap.put(26, "twenty six");
        wordmap.put(27, "twenty seven");
        wordmap.put(28, "twenty eight");
        wordmap.put(29, "twenty nine");
        wordmap.put(30, "half");
        
    }
    
    private static String getMinutes(int m)
    {
        if (m == 15 || m == 30)
            return wordmap.get(m);
        
        if (m == 1)
            return wordmap.get(m) + " minute";
        else
            return wordmap.get(m) + " minutes";
    }
    
    static String timeInWords(int h, int m)
    {
        String res;
        String mins;
        
        if (m == 0)
        {
            res = wordmap.get(h) + " " + wordmap.get(m);
        }
        else if (m <= 30)
        {
            mins = getMinutes(m);
            res = mins + " past " + wordmap.get(h);
        }
        else
        {
            mins = getMinutes(60 - m);
            res = mins + " to " + wordmap.get(h + 1);
        }
        
        return res;
    }

    public static void main(String[] args) throws IOException
    {
//        int hh = scanner.nextInt();
//        int mm = scanner.nextInt();
        
        System.out.println(timeInWords(1, 59));
    }    

}
