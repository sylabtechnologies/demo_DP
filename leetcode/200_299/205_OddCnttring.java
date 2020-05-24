package oddcountstring;

class Solution
{
    public static String generateTheString(int n)
    {
        if (n <= 0) return new String();
        
        return generateHelper(n, 0).toString();
    }
    
    private static StringBuilder generateHelper(int n, int startAt)
    {
        StringBuilder sb = new StringBuilder();
        char curr = (char)('a' + startAt);

        if (n == 1)
        {
            sb.append(curr);
            return sb;
        }

        if (n <= 26)
        {
            if (n % 2 == 1)
            {
                for (int i = 0; i < n; i++)
                    sb.append(curr);
            }
            else
            {
                for (int i = 0; i < n - 1; i++)
                    sb.append(curr);
                
                curr++;
                sb.append(curr);
            }

            return sb;
        }
        
        while (n > 25)
        {
            sb.append(generateHelper(25, startAt));
            startAt++;
            n -= 25;
        }
        
        sb.append(generateHelper(n, startAt));
        return sb;
    }
    
}

public class OddCntString
{
    public static void main(String[] args)
    {
        System.out.println(Solution.generateTheString(8));
    }
    
}
