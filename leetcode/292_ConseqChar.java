// https://leetcode.com/problems/consecutive-characters/
package conseqchar;

class Solution
{
    public int maxPower(String s)
    {
        int power = 1, currPower = 1;
        char curr = s.charAt(0);
        
        for (int i = 1; i < s.length(); i++)
        {
            if (s.charAt(i) == curr)
            {
                currPower++;
                power = Math.max(currPower, power);
            }
            else
            {
                currPower = 1;
                curr = s.charAt(i);
            }
        }
        
        return power;
    }
}

public class ConseqChar
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().maxPower("leeetcode"));
        
    }
    
}
