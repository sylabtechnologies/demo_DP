// https://leetcode.com/contest/weekly-contest-149/

package dayofyear;
import java.time.YearMonth;

public class DayOfYear
{

    public static void main(String[] args)
    {
        String date = "2019-02-10";
        
        int ans = dayOfYear(date);
        
        System.out.println(ans);
                
    }

    private static int dayOfYear(String dd)
    {
        int year = Integer.parseInt(dd.substring(0, 4));
        int month = Integer.parseInt(dd.substring(5, 7));
        int day   = Integer.parseInt(dd.substring(8));
        
        int count = 0;
        for (int i = 1; i < month; i++)
        {
            YearMonth yMo = YearMonth.of(year, i);
            count += yMo.lengthOfMonth();
        }

        return count + day;
    }
    
}
