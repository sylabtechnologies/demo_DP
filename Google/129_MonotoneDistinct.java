package goog79;
import java.util.*;

/* https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/

#S. monotone stack, add only uniq chars

*/

class Solution 
{
    public String smallestSubsequence(String s) 
    {
        int left[] = new int[26];
        char arr[] = s.toCharArray();
        int uniq = 0;
        for (char c : arr)
        {
            if (left[index(c)] == 0) uniq++;
            left[index(c)] += 1;
        }
        
        boolean found[] = new boolean[26];
        int foundCnt = 0;
        Stack<Character> stack = new Stack<>();
        for (char c : arr) 
        {
            if (!found[index(c)])
                while (!stack.isEmpty() && stack.peek() > c)
                {
                    char lst = stack.peek();
                    int ix1 = index(lst);
                    if (left[ix1] == 0) break;
                    found[index(lst)] = false;
                    foundCnt--;
                    stack.pop();
                }
                
            int ix = index(c);
            left[ix]--;
            
            if (!found[index(c)])
            {
                found[index(c)] = true;
                foundCnt++;
                stack.add(c);
            }
            
            if (foundCnt == uniq) break;
        }
        
        StringBuilder sb = new StringBuilder();
        for (Character ch : stack)
            sb.append(ch);
        return sb.toString();
    }

    private int index(char c) 
    {
        return c - 'a';
    }
}

public class Goog79
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().smallestSubsequence("bcabc"));
        System.out.println(new Solution().smallestSubsequence("cbacdcbc"));
        System.out.println(new Solution().smallestSubsequence("cdadabcc"));
        System.out.println(new Solution().smallestSubsequence("ecbacba"));
        System.out.println(new Solution().smallestSubsequence("cbaacabcaaccaacababa"));
        System.out.println(new Solution().smallestSubsequence("dbbbabadcdcbdaddddbbcbdaaadbdaadcaaabbab"));
    }
}
