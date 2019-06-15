/**
 * https://www.hackerrank.com/challenges/happy-ladybugs/problem
 * - see algo
 * 
 * RET2 > RET1
 * 
 */

package ladybugs;

public class Ladybugs
{
    private final static char EMPTY = '_';
    private final static int  ABC_SIZE = 26;

    static String happyLadybugs(String b)
    {
        if (b.length() < 2)
            return (b.charAt(0) != EMPTY) ? "NO" : "YES";

        int[] freq = new int[ABC_SIZE];
        int emptyCells = 0;
                
        for (int i = 0; i < b.length(); i++)
        {
            if (b.charAt(i) == EMPTY)
            {
                emptyCells++;
                continue;
            }
            
            int ind = b.charAt(i) - 'A';
            freq[ind]++;
        }
        
        // check all are happy
        if (emptyCells == 0)
        {
            int i = 1;
            int cellsInRow = 1;
            char currentColor = b.charAt(0);
            
            while (i < b.length())
            {
                if (b.charAt(i) == currentColor)
                    cellsInRow++;
                else if (cellsInRow < 2)
                    return "NO";
                else
                {
                    cellsInRow = 1;
                    currentColor = b.charAt(i);
                }
                
                i++;
            }
            
            return (cellsInRow < 2) ? "NO" : "YES";

        }
        
        // check letter count
        int oneLetter = 0;
        for (int i = 0; i < ABC_SIZE; i++)
        {
            if (freq[i] == 1) oneLetter++;
        }
        
        return (oneLetter > 0) ? "NO" : "YES";

    }
    
    public static void main(String[] args)
    {
        System.out.println(happyLadybugs("AABBC"));
        
    }
    
}
