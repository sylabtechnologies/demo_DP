// https://www.hackerrank.com/challenges/append-and-delete/problem

package appenddelete;

public class AppendDelete
{
    static String appendAndDelete(String start, String target, int k)
    {
        // seek match
        int match = 0, i = 0;
        while (true)
        {
            if (i >= start.length() || i >= target.length()) break;
            
            if (!(start.charAt(i) == target.charAt(i))) break;
                
            match++; i++;
        }
        
        int minOps = start.length() + target.length() - 2*match;
        
        // check parity
        boolean parityFlag = minOps % 2 == k % 2;
        
        if (parityFlag) return k >= minOps ? "Yes" : "No";
        
        return k >= start.length() + target.length() + 1 ? "Yes" : "No";
    }

    public static void main(String[] args)
    {
        // String res = appendAndDelete("hackerhappy", "hackerrank", 9);
        // String res = appendAndDelete("aba", "aba", 7);
        // String res = appendAndDelete("ashley", "ash", 2);
        
        String res = appendAndDelete("abcd", "abcdert", 10);
        System.out.println(res);
    }
    
}
