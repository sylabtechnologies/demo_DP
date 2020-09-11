package breakpaly;

class Result
{
    public static String breakPalindrome(String palindromeStr)
    {
        char pval[] = palindromeStr.toCharArray();
        
        int len = pval.length;
        if (len == 1) return "IMPOSSIBLE";
        
        int mid = 0;
        if (len % 2 == 1)
        {
            mid = len/2 + 1;
        }
        
        boolean replaced = false;
        for (int i = 0; i < pval.length; i++)
        {
            char c = pval[i];
            
            if (c > 'a' && i != mid)
            {
                pval[i] = 'a';
                replaced = true;
                break;
            }
        }
        
        if (replaced)
        {
            if (checkPaly(pval))
                return "IMPOSSIBLE";
            
            return new String(pval);
        }
        else
            return "IMPOSSIBLE";
    }

    private static boolean checkPaly(char[] pval)
    {
        int i = 0, j = pval.length - 1;
        while(i < j)
        {
            if (pval[i++] != pval[j--]) return false;
        }
        
        return true;
    }
}

public class BreakPaly
{
    public static void main(String[] args)
    {
        String paly = "aaabbaaa";
        System.out.println(Result.breakPalindrome(paly));
    }
    
}
