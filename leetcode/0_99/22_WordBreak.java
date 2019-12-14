/**
 * https://www.geeksforgeeks.org/word-break-problem-dp-32/
 * 
 */

package wordbreak;

import java.util.*;

class Solution
{
    boolean setDone = false;
            
    public boolean wordBreak(String s, List<String> wordDict)
    {
        int end = s.length();
        HashSet<String> wordSet = new HashSet<>();
        wordSet.addAll(wordDict);
        
        // DP
        boolean[] canDo = new boolean[end + 1];
        
        for (int i = 1; i <= end; i++)
        {
            // check if current prefix can make true
            if (!canDo[i])
            {
                if (wordSet.contains(s.substring(0, i)))
                    canDo[i] = true;
            }

            if (canDo[i])
            {
                if (i == end) return true;
                
                // check all other
                for (int j = i+1; j <= end; j++)
                {
                    if (!canDo[j])
                    {
                        if (wordSet.contains(s.substring(i, j)))
                            canDo[j] = true;
                        
                        if (j == end && canDo[j] == true)
                            return true;
                    }
                    
                }
            }
        }
       
        return false;
    }
    
}


public class WordBreak
{
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        
        List<String> wordDict = Arrays.asList("leet", "code");
        if (sol.wordBreak("leetcode", wordDict))
            System.out.println("OK");
        else
            System.out.println("not OK");
        
    }
    
}
