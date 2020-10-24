package goog17;
import java.util.*;

// https://leetcode.com/problems/bag-of-tokens/
class Solution
{
    public int bagOfTokensScore(int[] tokens, int power)
    {
        Arrays.sort(tokens);
        
        int beg = 0, end = tokens.length - 1, score = 0;
        while (beg <= end)
        {
            if (power >= tokens[beg])
            {
                power -= tokens[beg++];
                score++;
            }
            else if (score > 0)
            {
                if (beg == end) break;
                
                power += tokens[end--];
                score--;
            }
            else break;
        }
        
        return score;
    }
}

public class Goog17
{
    public static void main(String[] args)
    {
        int t[] = {100,200,300,400};
        System.out.println(new Solution().bagOfTokensScore(t, 200));
    }
}
