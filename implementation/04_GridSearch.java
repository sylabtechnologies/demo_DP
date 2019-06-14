/**
 * https://www.hackerrank.com/challenges/the-grid-search/problem
 * 
 * do the stream search problem w hash
 * encapsulate pattern fill/match
 * 
 */

package gridsearch;
import java.util.Scanner;
import toolz.Util.*;

public class GridSearch
{
    private static Scanner scan = toolz.Util.skan();

    public static void main(String[] args)
    {
        int gridSize = 10;
        String[] grid = new String[gridSize];
        
        for (int i = 0; i < gridSize; i++)
            grid[i] = scan.nextLine();
            
        int patSize = 3;
        String[] patrn = new String[patSize];
        
        for (int i = 0; i < patSize; i++)
            patrn[i] = scan.nextLine();
        
        System.out.println(gridSearch(grid, patrn));
        
    }

     
    static String gridSearch(String[] G, String[] P)
    {
        boolean found = false;
        
        int pLen = P[0].length();
        
        Pattern p = new Pattern( P[0], G[0].substring(0, pLen));

        for (int i = 0; i < G.length; i++)
        {
            p.rebuffer(G[i].substring(0, pLen));
            
            if (p.found())
            {
                found = giveTry(G, P, i, 0);
                if (found) return "YES";
            }
            
            for (int j = pLen; j < G[i].length(); j++)
            {
                p.push(G[i].charAt(j));

                if (p.found())
                {
                    found = giveTry(G, P, i, j + 1 - pLen);
                    if (found) return "YES";
                }
            }

        }

        return found ? "YES" :"NO";

    }

    private static boolean giveTry(String[] G, String[] P, int row, int col)
    {
        for (int i = 1; i < P.length; i++)
        {
            String strToCompare = G[i + row].substring(col, col + P[i].length());
            
            if (!strToCompare.equals(P[i])) return false;
        }

        return true;
    }
        
        
        
        

    
}
