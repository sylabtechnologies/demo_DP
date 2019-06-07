/** 
 * https://www.hackerrank.com/challenges/library-fine/problem
 */
package libfine;
import java.util.*;

public class LibFIne
{

    static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2)
    {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, y1);
        cal.set(Calendar.MONTH, m1);
        cal.set(Calendar.DAY_OF_MONTH, d1);
        Date ret = cal.getTime();
        
        cal.set(Calendar.YEAR, y2);
        cal.set(Calendar.MONTH, m2);
        cal.set(Calendar.DAY_OF_MONTH, d2);
        Date due =  cal.getTime();

        if (ret.compareTo(due) <= 0) return 0;

        int fine = 0;
        
        if (y1 != y2) return 10000;
        
        if (m1 != m2) return (m1 - m2)*500;

        return 15*(d1 - d2);
    }

    public static void main(String[] args)
    {
        int fine = libraryFine(9, 6, 2015, 6, 6, 2015);
        System.out.println(fine);
    }
    
}
