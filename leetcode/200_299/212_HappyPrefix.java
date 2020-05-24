package happyprefix;

class Solution
{
    private static final long MAXHASH = 99999997;
            
    public String longestPrefix(String s)
    {
        String ans = new String();
        if (s == null || s.length() == 1) return ans;
        
        char orig[] = s.toCharArray();
        int len = orig.length;
        
        long hash1 = getHash(orig, 0, 1);
        long hash2 = getHash(orig, len - 1, len);
        
        if (orig[0] == orig[len-1]) ans += orig[0];
        
        int curLen = 2;
        while (curLen < len)
        {
            hash1 = growHash(hash1, orig, curLen - 1);
            hash2 = growHash(hash2, orig, len - curLen);
            
            if (hash1 == hash2)
            {
                if (s.substring(0, curLen).equals(s.substring(len - curLen)))
                    ans = s.substring(0, curLen);
            }
            
            curLen++;
        }
        
        return ans;
    }

    private long getHash(char[] orig, int beg, int end)
    {
        long ans = 0;
        
        for (int i = beg; i < end; i++)
        {
            int val = (int) (orig[i] - 'a');
            if (ans + val < MAXHASH)
                ans += val;
            else
                ans -= MAXHASH + val;
        }
        
        return ans;
    }

    private long growHash(long hash, char[] carr, int i)
    {
        int val = (int) (carr[i ]- 'a');
        if (hash + val < MAXHASH)
            hash += val;
        else
            hash -= MAXHASH + val;
        
        return hash;
    }
    
}

public class HappyPrefix
{
    public static void main(String[] args)
    {
        Solution sol = new Solution();
//        System.out.println(sol.longestPrefix("level"));
        System.out.println(sol.longestPrefix("leetcodeleet"));
    }
    
}
