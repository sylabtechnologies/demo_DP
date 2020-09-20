// https://leetcode.com/problems/longest-palindromic-substring/
// "aacddefcaa'

class Solution
{
    public String longestPalindrome(String str)
    {
        // find longest suffix
        char[] original = str.toCharArray();
        int n = original.length;
        String rev = new StringBuilder(str).reverse().toString();
        char[] reversed = rev.toCharArray();
        
        int[][] LCSuffix = new int[n + 1][n + 1];
        int row = 0, col = 0, maxLen = 0;

        for (int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= n; j++)
            {
                if(original[i-1] == reversed[j-1])
                {
                    LCSuffix[i][j] = LCSuffix[i-1][j-1] + 1;
                    
                    int revIx = i;
                    int forIx = j - LCSuffix[i][j] + 1;
                    
                    if (str.length() - revIx + 1 == forIx && maxLen < LCSuffix[i][j])
                    {
                        maxLen = LCSuffix[i][j];
                        row = i; col = j;
                    }
                }
                else
                    LCSuffix[i][j] = 0;
                
            }
        }
        
        StringBuilder answer = new StringBuilder();
        while (LCSuffix[row][col] != 0)
        {
            answer.append(original[row - 1]);
            row--; col--;            
        }

        return answer.toString();
    }
}
