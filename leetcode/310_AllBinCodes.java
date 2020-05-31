// https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/
package task0;

class Solution
{
    public boolean hasAllCodes(String s, int k)
    {
        if (s.length() < k*k) return false;
        
        int curr = 0;
        for (int i = 0; i < k; i++)
        {
            curr *=2;
            
            if (s.charAt(i) == '1')
                curr++;
        }
        
        int maxpowered = (int) Math.pow(2.0, k-1);
        boolean hits[] = new boolean[maxpowered*2];
        int numHits = 1;
        hits[curr] = true;
        
        for (int i = k; i < s.length(); i++)
        {
            if (s.charAt(i - k) == '1')
                curr -= maxpowered;
            
            curr *=2;
            if (s.charAt(i) == '1')
                curr++;
            
            if (!hits[curr])
            {
                hits[curr] = true;
                numHits++;
                if (numHits == maxpowered*2) return true;
            }
        }
        
        return false;
    }
}

public class Task0
{
    public static void main(String[] args)
    {
        String s= "00110110";
        System.out.println(new Solution().hasAllCodes(s, 2));
    }
}
