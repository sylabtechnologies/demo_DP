// https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/
// return size minus LCS

package palyinsert;

class Solution
{
    public static int minInsertions(String s)
    {
        String rev = (new StringBuilder(s).reverse()).toString();
        
        int size = s.length();
        int[][] dp = new int[size + 1][size + 1];
        
        for (int i = 0; i < size + 1; i++)
        {
            for (int j = 0; j < size + 1; j++)
            {
                if (i == 0 || j == 0) continue;
                
                if (s.charAt(i-1) == rev.charAt(j - 1))
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                {
                    int val1 = dp[i-1][j];
                    int val2 = dp[i][j-1];
                    dp[i][j] = (val1 > val2) ? val1 : val2;
                    
                }
            }
        }
        
        return size - dp[size][size];
    }
}
