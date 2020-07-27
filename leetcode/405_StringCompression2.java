// https://leetcode.com/problems/string-compression-ii/
package stringcompression;
import java.util.*;

/// make dfs recursive
class Solution
{
    ArrayList<Integer> answers = new ArrayList<>();
    
    public int getLengthOfOptimalCompression(String s, int k)
    {
        int strlen = s.length(); 
        if (strlen == 0) return 0;
        if (strlen <= k) return 0;
        
        ArrayList<Link> chain = new ArrayList<>();
        char prev = s.charAt(0); int len = 1;
        for (int i = 1; i < s.length(); i++)
        {
            char curr = s.charAt(i);
            if (curr != prev)
            {
                chain.add(new Link(prev, len));
                prev = curr;
                len = 1;
            }
            else len++;
        }
        chain.add(new Link(prev, len));
        
        return helper(chain, k);
    }

    private int helper(ArrayList<Link> chain, int maxMoves)
    {
        int srcLength = 0, ans = Integer.MAX_VALUE;
        for (Link link : chain) srcLength += link.length();
        if (maxMoves <= 0) return srcLength;
        
        for (int i = 0; i < chain.size(); i++)
        {
            Link curr = chain.get(i);
            
            if (i > 0 && i < chain.size() - 1 &&
               (curr.length <= maxMoves && chain.get(i - 1).myChar == chain.get(i + 1).myChar)) 
            {
                Link left = chain.get(i-1);
                Link right = chain.get(i+1);
                Link replace = new Link(left.myChar, left.length + right.length);
                int res1 = srcLength - left.length() - curr.length() - right.length() + replace.length();

                ArrayList<Link> next = new ArrayList<>();
                for (int j = 0; j < i -1 ; j++)
                    next.add(new Link(chain.get(j)));
                next.add(replace);
                for (int j = i + 2; j < chain.size() ; j++)
                    next.add(new Link(chain.get(j)));

                ans = Math.min( ans, Math.min(res1, helper(next, maxMoves - curr.length)));
            }
            else if (curr.length <= maxMoves)
            {
                ArrayList<Link> next = carbonCopy(chain);
                next.remove(i);
                int res2 = srcLength - curr.length();
                ans = Math.min( ans, Math.min(res2, helper(next, maxMoves - curr.length)));
            }
            else if (curr.length - 1 <= maxMoves)
            {
                ArrayList<Link> next = carbonCopy(chain);
                Link node = next.get(i); node.reduce(curr.length - 1);
                int res3 = srcLength - curr.length() + node.length();
                ans = Math.min( ans, Math.min(res3, helper(next, maxMoves - curr.length + 1)));
            }
            else
            {
                ArrayList<Link> next = carbonCopy(chain);
                Link node = next.get(i); node.reduce(maxMoves);
                int res4 = srcLength - curr.length() + node.length();
                ans = Math.min( ans, Math.min(res4, helper(next, maxMoves - curr.length + 1)));
            }
        }

        return ans;
    }

    private ArrayList<Link> carbonCopy(ArrayList<Link> orig)
    {
        ArrayList<Link> dest = new ArrayList<>();
        for (Link lnk : orig)
            dest.add(new Link(lnk));
        return dest;
    }

    private static class Link implements Comparable<Link>
    {
        final char myChar;
        int  length;
        String value;

        public Link(char c, int len)
        {
            if (len < 1) throw new IllegalArgumentException("size " + len);
            myChar = c;
            length = len;
            calcValue();
        }
        
        public Link(Link lnk)
        {
            this.myChar = lnk.myChar;
            this.length = lnk.length;
            this.value = lnk.value;
        }

        public int length() { return value.length(); }
        @Override
        public String toString() { return value; }

        private void calcValue()
        {
            if (length == 1)
                value = Character.toString(myChar);
            else
                value = myChar + Integer.toString(length);
        }

        private void reduce(int delta)
        {
            if (delta > length)
                throw new IllegalArgumentException("size " + delta);
            else if (delta == length)
                length = 0;
            else
            {
                length -= delta;
                calcValue();
            }
        }
        
        @Override
        public int compareTo(Link lnk)
        {
            if (this.length != lnk.length)
                return this.length - lnk.length;

            return this.myChar - lnk.myChar;
        }

    }
}

public class StringCompression
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().getLengthOfOptimalCompression("llllllllllttttttttt", 1));
    }
}

/*
int dp[111][111];
class Solution {
public:
    int getLengthOfOptimalCompression(string s, int k) {
        int n = s.size();
        memset(dp, 0x3f, sizeof(dp));
        dp[0][0] = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j <= k; j++) {
                dp[i][j + 1] = min(dp[i][j + 1], dp[i - 1][j]);
                int cnt = 0, del = 0;
                for(int l = i; l <= n; l++) {
                    cnt += s[l - 1] == s[i - 1];
                    del += s[l - 1] != s[i - 1];
                    if(j + del <= k) dp[l][j + del] = min(dp[l][j + del], dp[i - 1][j] + 1 + (cnt >= 100 ? 3 : cnt >= 10 ? 2 : cnt >= 2 ? 1: 0));
                }
            }
        }
        return dp[n][k];
    }
};
*/