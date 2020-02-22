package threecharsubstrings;

import java.util.Arrays;

public class ThreeCharSubstrings
{
    public static void main(String[] args)
    {
        // System.out.println(Solution.numberOfSubstrings("abcabc"));
        System.out.println(Solution.numberOfSubstrings("abc"));
    }
    
    public static class Solution
    {
        private static int SIGN = 3; 
        private static char LOW_A = 'a';
        
        private static int numberOfSubstrings(String s)
        {
            if (s == null || s.length() < 3) return 0;
            
            char[] sa = s.toCharArray();
            int len = s.length();
            
            if (len == 3) return got3(sa, 0);
            
            int[] dp = new int[len - 2];
            
            // init
            int count = 0;
            for (int i = 0; i < len - 2; i++)
            {
                int res = got3(sa, i);
                dp[i] = res;
                count += res;
            }
            
            for (int i = 0; i < len - 3; i++)
            {
                int starter = dp[i];

                if (starter == 1)
                {
                    count += len - 3 - i;
                    continue;
                }
                
                for (int j = i + 1; j < len - 2; j++)
                {
                    int restart = got3(sa, i, j + 3);
                    
                    if (restart == 1)
                    {
                        count += len - j - 2;
                        break;
                    }
                }
                
            }
                
            return count;
        }

        private static int got3(char[] s, int start)
        {
            return got3(s, start, start + 3);
        }

        private static int got3(char[] s, int from, int to)
        {
            //char[] prn = Arrays.copyOfRange(s, from, to);
            //System.out.println(Arrays.toString(prn));
            
            int[] freq = new int[3];
            
            for (int i = from; i < to; i++)
            {
                int ind  = (int)(s[i] - LOW_A);
                if (freq[ind] == 0) freq[ind] = 1;
            }

            for (int i = 0; i < 3; i++)
                if (freq[i] != 1) return 0;

            return 1;
        }
    }
    
}
