/* https://www.hackerrank.com/challenges/drawing-book/problem */
package solution;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    // force the count
    static int pageCount(int n, int p)
    {
        if (p == 1) return 0;
        if (p == n) return 0;

        // count from 1
        int countfromOne = 0;
        int count = 1;
        int page  = 2;

        while(true)
        {
            if (p == page || p == page + 1)
            {
                countfromOne = count;
                break;
            }

            page += 2;
            count += 1;
        }

        int countfromLast = 0;
        while(true)
        {
            if (n == page || n == page + 1)
            {
                break;
            }

            page += 2;
            countfromLast += 1;
        }

        return (countfromOne < countfromLast) ? countfromOne : countfromLast;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException
    {
        int n = scanner.nextInt();
        int p = scanner.nextInt();

        int result = pageCount(n, p);
        System.out.println(result);

        scanner.close();
    }
}
