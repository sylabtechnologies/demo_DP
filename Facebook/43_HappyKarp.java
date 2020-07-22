package happyprefix;

class Solution
{
    private static final int MYMOD = 1_000_000_007;
            
    public String longestPrefix(String s)
    {
        long hash1 = 0, hash2 = 0, myMultiple = 1, len = 0;
        
        for (int i = 0, j = s.length() - 1; j > 0; i++, j--)
        {
            int nextLeft = s.charAt(i) - 'a', nextRight = s.charAt(j) - 'a';
            
            hash1 = (hash1*26 + nextLeft ) % MYMOD;
            hash2 = (hash2 + nextRight*myMultiple ) % MYMOD;
            myMultiple = (myMultiple * 26) % MYMOD;
            
            if (hash1 == hash2) len = i + 1;
        }
        
        return s.substring(0, (int) len);
    }
}

public class HappyPrefix
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().longestPrefix("leetcodeleet"));
    }
    
}
