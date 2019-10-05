/*

Given a string s and an integer k, find out if the given string is a K-Palindrome or not.

A string is K-Palindrome if it can be transformed into a palindrome by removing at most k characters from it.

OBVIOUS IT IS DYNAPROG! better yet LCS

*/

package kpalyndrome;

class Solution
{
    public boolean isValidPalindrome(String str, int k)
    {
        int n = str.length(); 
  
        StringBuilder revStr = new StringBuilder(str); 
        revStr = revStr.reverse(); 
  
        int lps = lcs(str, revStr.toString(), n, n); 
        return (n - lps <= k); 
    }

    static int lcs(String X, String Y, int m, int n)  
    { 
        int L[][] = new int[m + 1][n + 1]; 
  
        for (int i = 0; i <= m; i++) 
        { 
            for (int j = 0; j <= n; j++)  
            { 
                if (i == 0 || j == 0)  
                { 
                    L[i][j] = 0; 
                }  
                else if (X.charAt(i - 1) == Y.charAt(j - 1)) 
                { 
                    L[i][j] = L[i - 1][j - 1] + 1; 
                }  
                else
                { 
                    L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]); 
                } 
            } 
        } 
        
        return L[m][n]; 
    } 

}


public class KPalyndrome
{

    public static void main(String[] args)
    {
        Solution sol = new Solution();
        System.out.println(sol.isValidPalindrome("abcdeca", 2));
    }
    
}
