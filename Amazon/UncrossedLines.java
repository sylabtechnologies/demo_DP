package crosslines;
import java.util.*;

// use LCS
class Solution
{
    public int maxUncrossedLines(int[] A, int[] B)
    {
        int n = A.length, m = B.length;
        
        int dp[][] = new int[n + 1][];
        for (int i = 0; i <= n; i++)
            dp[i] = new int[m + 1];
        
        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= m; j++)
            {
                if (A[i-1] == B[j-1])
                    dp[i][j] = dp[i-1][j-1]  + 1;
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                
                // print2D(dp);
            }
        }
        
        return dp[n][m];
    }
    
}

public class CrossLines
{
    public static void main(String[] args)
    {
        int arr1[] = {1, 4, 2},  arr2[] = {1, 2, 4};
        System.out.println(new Solution().maxUncrossedLines(arr1, arr2));
    }
}
