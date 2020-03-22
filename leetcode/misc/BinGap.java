// https://leetcode.com/problems/binary-gap/

class Solution
{
    public static int binaryGap(int N)
    {
        String s = Integer.toBinaryString(N);
        System.out.println(s);
        
        char[] digs = s.toCharArray();
        
        int max = 0, count = 0;
        boolean found = false;
        
        for (char c : digs)
        {
            if (c == '0')
            {
                if (!found) continue;
                
                count++;
            }
            else
            {
                if (!found)
                {
                    found = true;
                    count = 1;
                    continue;
                }
                
                if (count > max) max = count;
                count = 1;
            }
            
        }
        
        return max;
    }
}


public class Ttetete
{

    public static void main(String[] args)
    {
        System.out.println(Solution.binaryGap(13));
    }
    
}
