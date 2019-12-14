// https://leetcode.com/problems/unique-paths-ii/
// just take care

package uniquepath2;
import java.util.Arrays;


public class UniquePath2
{

    public static void main(String[] args)
    {
        // int[][] obstacles = { {0, 0, 0}, {0, 1, 0}};
        
        int[][] obstacles = { {0}, {1}};
        System.out.println(uniquePaths2(obstacles));
        
    }

    public static int uniquePaths2(int[][] obstacleGrid)
    {
        if (obstacleGrid == null) return 0;
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        if(n==0 || m==0)return 0;

        int[] dp = new int[n];
        for (int i = 0; i < n; i++)
        {
            if (obstacleGrid[0][i] == 0)
                dp[i] = 1;
            else
                break;
        }
        if (m==1) return dp[n-1];
        
        for (int i = 1; i < m; i++)
        {
            if (obstacleGrid[i][0] == 1)
                dp[0] = 0;
            
            for (int j = 1; j < n; j++)
            {
                if (obstacleGrid[i][j] == 0)
                    dp[j] += dp[j-1];
                else
                    dp[j] = 0;
            }
        }
        
        return dp[n-1];
    }
    
}
