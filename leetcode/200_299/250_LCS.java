package lcs;

class Solution
{
    public int longestCommonSubsequence(String text1, String text2)
    {
        char[] longer, shorter;
        
        if (text1.length() < text2.length())
        {
            longer = text2.toCharArray();
            shorter = text1.toCharArray();
        }
        else
        {
            longer = text1.toCharArray();
            shorter = text2.toCharArray();
        }
        
        int m = longer.length;
        int n = shorter.length;
        int DP[][] = new int[m + 1][n+1];
        int max = 0;
        
        for (int i = 1; i <= m; i++)
        {
            for(int j = 1; j <= n; j++)
            {
                if (longer[i-1] == shorter[j-1])
                    DP[i][j] = DP[i-1][j-1] + 1;
                else
                    DP[i][j] = Math.max(DP[i-1][j], DP[i][j-1]);
            }
        }
        
        return DP[m][n];
    }
}

public class LCS
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().longestCommonSubsequence("abcde", "ace"));  
    }
    
}
