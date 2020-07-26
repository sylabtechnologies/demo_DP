// https://leetcode.com/problems/bulb-switcher-iv/
package taska;

class Solution
{
    /// switch all left-to-rightly
    public int minFlips(String target)
    {
        int count = 0, currentBit = 0;
        char bits[] = target.toCharArray();
        
        for (int i = 0; i < bits.length; i++)
        {
            char next = bits[i];
            if (next - '0' != currentBit)
            {
                currentBit = next - '0';
                ++count;
            }
        }
        
        return count;
    }
}

public class TaskA
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().minFlips("10111"));
    }
}
