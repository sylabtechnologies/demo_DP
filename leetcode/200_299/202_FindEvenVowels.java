// https://leetcode.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/

package lcevenvowels;
import java.util.*;

class Solution
{
    private static final int VOWELS_LEN = 5;
    private static final HashMap<Character, Integer> vowels;
    static
    {
        String vStr = "aeiou"; vowels = new HashMap<>();
        for (int i = 0; i < VOWELS_LEN; i++)
            vowels.put(vStr.charAt(i), i);
    }
    
    // CONVERGE to DP
    public int findTheLongestSubstring(String str)
    {
        if (str == null || str.isEmpty()) return 0;
        
        char[] letters = str.toCharArray();
        int len = str.length();
        int[][] DP  = new int[len][];
        
        // set imbalance to index of 5
        for (int i = 0; i < len; i++)
        {
            DP[i] = new int[1 + VOWELS_LEN];
            
            char c = letters[i];
            Integer key = vowels.get(c);
            
            if (key != null)
            {
                DP[i][0] = 0;
                DP[i][1 + key] = 1;
            }
            else
                DP[i][0] = 1;
        }

        // continue leetcodeisgreat
        for (int sizeMinusOne = 1; sizeMinusOne < len; sizeMinusOne++)
        {
            for (int j = 0; j + sizeMinusOne < len; j++)
            {
                char c = letters[j + sizeMinusOne];
                Integer key = vowels.get(c);
                
                if (key == null)
                {
                    if (checkBalance(DP[j]))
                        DP[j][0]++;
                    else
                        DP[j][0] = Math.max(DP[j][0], DP[j+1][0]);
                    
                }
                else
                {
                    if (DP[j][1 + key] == 1)
                    {
                        DP[j][1 + key] = 0;
                        DP[j][0] += 2;
                    }
                    else
                    {
                        DP[j][1 + key] = 1;
                        DP[j][0] = Math.max(DP[j][0], DP[j+1][0]);
                    }
                }
                
                prnArr(DP); System.out.println("-");
                
            }
            
            System.out.println("---");
        }
        
        return DP[0][0];
    }

    private boolean checkBalance(int[] column)
    {
        boolean ans = true;
        for (int i = 1; i < VOWELS_LEN + 1; i++)
        {
            if (column[i] > 0)
            {
                ans = false; break;                
            }
        }
        
        return ans;
    }

    private void prnArr(int[][] DP)
    {
        for (int i = 0; i < DP.length; i++)
            System.out.print(DP[i][0]);
        System.out.print(";\n");
    }
    
}
