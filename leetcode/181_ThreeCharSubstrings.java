package threecharsubstrings;
import java.util.Arrays;

class Solution
{
    private static final int OKSIGN = 3; 
    private static final char LOW_A = 'a';

    public static int numberOfSubstrings(String s)
    {
        if (s == null || s.length() < 3) return 0;

        char[] sa = s.toCharArray();
        int len = s.length();

        if (len == 3)
            return sumFreq(freq3(sa, 0, 3)) == OKSIGN ? 1 : 0;

        int[][] dp = new int[len - 2][];
        int[] sign = new int[len - 2];

        // init
        int count = 0;
        for (int i = 0; i < len - 2; i++)
        {
            dp[i] = freq3(sa, i, i + 3);
            sign[i] = sumFreq(dp[i]) == OKSIGN ? 1 : 0;
            if (sign[i] == 1) count++;
        }

        for (int fin = 3; fin < len; fin++)
        {
            for (int start = 0; start + fin < len; start++)
            {
                // char[] prn = Arrays.copyOfRange(sa, start, start + fin + 1);
                // System.out.println(Arrays.toString(prn));

                if (sign[start] == 1)
                {
                    count++;
                    continue;
                }

                char newChar = sa[start + fin];
                int ind  = (int)(newChar - LOW_A);

                // make stronger
                if (dp[start][ind] == 1) continue;

                dp[start][ind] = 1;
                sign[start] = sumFreq(dp[start]) == OKSIGN ? 1 : 0;

                if (sign[start] == 1) count++;
            }
        }

        return count;
    }

    private static int sumFreq(int[] freq)
    {
        int sum = 0;
        for (int i = 0; i < 3; i++)
            sum += (freq[i]);

        return sum;
    }

    private static int[] freq3(char[] s, int from, int to)
    {
        int[] freq = new int[3];

        for (int i = from; i < to; i++)
        {
            int ind  = (int)(s[i] - LOW_A);
            if (freq[ind] == 0) freq[ind] = 1;
        }

        return freq;
    }
}

public class ThreeCharSubstrings
{
    public static void main(String[] args)
    {
        System.out.println(Solution.numberOfSubstrings("aabacaabbcacccbcbaaacbcaacc"));
        System.out.println(Solution.numberOfSubstrings("aaabc"));
    }
    
}
