// https://leetcode.com/problems/edit-distance/
package editdistance;

class Solution
{
    public int minDistance(String word1, String word2)
    {
        int len1 = word1.length();
        int dp[][] = new int[len1+1][];
        int len2 = word2.length();
        for (int i = 0; i <= len1; i++)
            dp[i] = new int[len2+1];
        
        // delete all solutions
        for (int k = 0; k <= len1; k++)
            dp[k][0] = k;
        
        for (int k = 0; k <= len2; k++)
            dp[0][k] = k;
        
        for (int i = 1; i <= len1; i++)
        {
            for (int j = 1; j <= len2; j++)
            {
                if (word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
            }
        }
        
        return dp[len1][len2];
    }
}

public class EditDistance
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().minDistance("horse", "ros"));
        
    }
}
