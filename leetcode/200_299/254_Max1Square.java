
package maxsquare;

// stj-whouse
class Solution
{
    public int maximalSquare(char[][] mat)
    {
        int nR = mat.length;
        if (nR == 0) return 0;
        int nC = mat[0].length;
        if (nC == 0) return 0;
        
        int dp[][] = new int[nR][nC];
        
        int smax = 0;
        for (int i = 0; i < nR; i++)
        {
            if (mat[i][0] == '1')
            {
                dp[i][0] = 1;
                smax = 1;
            }
            else dp[i][0] = 0;
        }

        for (int j = 0; j < nC; j++)
        {
            if (mat[0][j] == '1')
            {
                dp[0][j] = 1;
                smax = 1;
            }
            else dp[0][j] = 0;
        }
        
        for (int i = 1; i < nR; i++)
        {
            for (int j = 1; j < nC; j++)
            {
                if (mat[i][j] == '1')
                    dp[i][j] = Math.min(dp[i][j-1], Math.min(dp[i-1][j],dp[i-1][j-1])) + 1;
                else dp[i][j]= 0;
                
                if(smax < dp[i][j]) smax = dp[i][j];
            }
        }
        
        return smax*smax;
    }
}

public class MaxSquare
{
    public static void main(String[] args)
    {
        char mat[][] = {
            {'1', '0', '1', '0', '0'},
            {'1', '0', '1', '1', '1'},
            {'1', '1', '1', '1', '1',},
            {'1', '0', '0', '1', '0'}};

        System.out.println(new Solution().maximalSquare(mat));
        
    }
}
