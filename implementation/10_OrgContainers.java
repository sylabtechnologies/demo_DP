/**
 * https://www.hackerrank.com/challenges/organizing-containers-of-balls/problem
 * 
 * compare rows and column sums
 * 
 */

package orgcontainers;
import java.util.*;

public class OrgContainers
{
    static String organizingContainers(int[][] container)
    {
        
        int rows = container.length;
        int cols = container[0].length;
        
        int[] capacity = new int[rows];
        for (int i = 0; i < rows; i++)
        {
            int sum = 0;
            for (int j = 0; j < cols; j++)
            {
                sum += container[i][j];
            }
            
            capacity[i] = sum;
        }
        Arrays.sort(capacity);
        
        int[] balls = new int[cols];
        for (int i = 0; i < cols; i++)
        {
            int sum = 0;
            for (int j = 0; j < rows; j++)
            {
                sum += container[j][i];
            }
            
            balls[i] = sum;
        }
        Arrays.sort(balls);
        
        return Arrays.equals(capacity, balls) ? "Possible" : "Impossible";
        
    }
    
    public static void main(String[] args)
    {
        // int[][] arr = {{1, 1}, {1, 1}, {1, 1}};

        int[][] arr = {{0, 2, 1}, {1, 1, 1}, {2, 0, 0}};
        
        
        System.out.println(organizingContainers(arr));
        
    }
    
}


        /*
        
        int n = container.length;

        int typeOne = 0;
        for (int i = 0; i < n; i++)
        {
            typeOne += container[i][0];
        }

        // cmp to rest
        for (int j = 1; j < container[0].length; j++)
        {
            int sum = 0;
            for (int i = 0; i < n; i++)
            {
                sum += container[i][j];
            }
            
            if (sum != typeOne) return "Impossible";
        }
        
        return "Possible";
        */
