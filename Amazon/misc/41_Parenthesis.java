// https://leetcode.com/problems/score-of-parentheses/
package parenthscore;
import java.util.*;

class Solution
{
    public int scoreOfParentheses(String str)
    {
        final int LEFT_BRACKET = -1;
        Stack<Integer> results = new Stack<>();

        // push brackets!
        for (char c : str.toCharArray())
        {
            if (c == '(')
                results.push(LEFT_BRACKET);
            else if (c == ')')
            {
                int next = 0;

                if (results.peek() == LEFT_BRACKET)
                {
                    next = 1;
                    results.pop();
                }
                else
                {
                    while (!results.isEmpty() && results.peek() != LEFT_BRACKET)
                    {
                        next += results.pop();
                    }
                    next *= 2;
                    results.pop();
                }
                
                results.push(next);
            }
        }
        
        
        int total = 0;
        for (Integer r : results)
            total += r;
        return total;
    }
}

public class ParenthScore
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().scoreOfParentheses("(()(()))"));
        
    }
}

