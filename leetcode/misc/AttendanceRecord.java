// https://leetcode.com/problems/student-attendance-record-i/

package mar18;

class Solution
{
    public static boolean checkRecord(String s)
    {
        int countA = 0;
        int countL = 0;
        boolean previousL = false;
        
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == 'A')
            {
                countA++;
                
                if (countA > 1) return false;
                
                countL = 0;
                previousL = false;
            }
            else if (s.charAt(i) == 'L')
            {
                countL++;

                if (previousL)
                {
                    if (countL > 2) return false;
                }
                else
                    previousL = true;
            }
            else
            {
                countL = 0;
                previousL = false;
            }
        }

        return true;
    }
}


public class Tempm17
{
    public static void main(String[] args)
    {
        System.out.println(Solution.checkRecord("PPALLLP"));
    }
    
}
