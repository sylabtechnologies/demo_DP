/// MMz COORDS & super4encap
// fix factorials

package threecharsubstrings;
import java.util.*;

class Solution
{
    private static final char LOW_A = 'a';
    private static final int  OKSIGN = 3;
    
    private int[][] dp;
    private int[] mySignature;
    private List<ArrayList<Integer>> allInd;
    
    public int numberOfSubstrings(String s)
    {
        if (s == null || s.length() < 3) return 0;
        int oldlen = s.length();

        char[] sa = s.toCharArray();
        sa = unique(sa);
        int len = sa.length;
        int trunc = (oldlen == len) ? 1 : oldlen - len;

        if (len == 3)
            return sumFreq(freq3(sa, 0, 3)) == OKSIGN ? 1 : 0;
        
        // init
        dp = new int[len - 2][];
        mySignature = new int[len - 2];

        int count = 0;
        for (int i = 0; i < len - 2; i++)
        {
            dp[i] = freq3(sa, i, i + 3);
            mySignature[i] = sumFreq(dp[i]);
            if (mySignature[i] == OKSIGN) count++;
        }

        allInd = new ArrayList<>();
        allInd.add(new ArrayList<>());
        allInd.add(new ArrayList<>());
        allInd.add(new ArrayList<>());
        for (int i = 3; i < len; i++)
        {
            ArrayList<Integer> ref = allInd.get(getIndex(sa[i]));
            ref.add(i);
        }

//        System.out.println(Arrays.toString(sa));
//        System.out.println(allInd);
        
        for (int start = 0; start + 3 < len; start++)
        {
//            char[] prn = Arrays.copyOfRange(sa, start, start + 4);
//            System.out.println(Arrays.toString(prn));
            
            if (mySignature[start] == OKSIGN)
                count += len - start - 3;
            else
            {
                // 5 - 3
                int farthest = findMissing(start);
                
                if (farthest >= 0)
                    count += len - farthest;
            }

        }
        
        return count * trunc;
    }

    /// find farthest missing
    private int findMissing(int start)
    {
        int find = OKSIGN - mySignature[start];
        ArrayList<Integer> found = new ArrayList<>();
        
        for (int i = 0; i < 3; i++)
        {
            int freq  = dp[start][i];
            if (freq == 1) continue;

            ArrayList<Integer> ref = allInd.get(i);
            for (Integer pos : ref)
            {
                if (pos >= start + 3)
                {
                    found.add(pos);
                    break;
                }
            }
        }
        
        if (found.size() != find)
            return -1;
        else
            return Collections.max(found);
    }
    
    private static int getIndex(char a)
    {
        switch(a)
        {
            case 'a':
                return 0;
            case 'b':
                return 1;
            case 'c':
                return 2;
            default:
                throw new IllegalArgumentException("numberOfSubstrings");
        }
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

    private char[] unique(char[] sa)
    {
        int len = sa.length;
        char[] uniq = new char[len];
        uniq[0] = sa[0];
        int curr = 0;
        
        for (int i = 1; i < len; i++)
        {
            if (uniq[curr] != sa[i])
            {
                curr++;
                uniq[curr] = sa[i];
            }
        }
                
        char[] res = Arrays.copyOfRange(uniq, 0, curr + 1);
        return res;
    }
}

public class ThreeCharSubstrings
{
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        
//        System.out.println(sol.numberOfSubstrings("aabacaabbcacccbcbaaacbcaacc"));
        System.out.println(sol.numberOfSubstrings("aaacb"));
//        System.out.println(sol.numberOfSubstrings("ababbbc"));
        System.out.println(sol.numberOfSubstrings("abcabc"));
    }
    
}
