// https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/

package kdiversestr;
class Solution
{
    public String getHappyString(int n, int k)
    {
        char[] happy = new char[n];
        
        initHappy(happy, 0);
        
        int count = 1, test = 1;
        String ans = "";

        while (test > 0)
        {
            if (count == k)
            {
                ans = new String(happy, 0, n);
                break;
            }
            
            test = advance(happy);
            if (test < 0) break;
            
//            System.out.println(new String(happy, 0, happy.length));
            count++;
        }
        
        return ans;
    }

    private int advance(char[] happy)
    {
        final int len = happy.length;
        
        int i = len - 1;
        while (i >= 0)
        {
            char c = (char) (happy[i] + 1);
            
            if (c < 'd')
            {
                happy[i] = c;
                
                if (i > 0)
                {
                    if (happy[i] != happy[i-1])
                    {
                        int offset = len - i - 1;
                        if (offset > 0)
                            initHappy(happy, len - offset);
                        return 1;
                    }
                }
                else
                {
                    int offset = len - 1;
                    initHappy(happy, len - offset);
                    System.out.println("** " + new String(happy, 0, happy.length));
                    return 1;
                }
                    
            }
            else
                i--;
        }
        
        return -1;
    }
   
    private void initHappy(char[] happy, int start)
    {
        int inx = 1;
        for (int i = start; i < happy.length; i++)
        {
            if (inx % 2 == 1)
                happy[i] = 'a';
            else
                happy[i] = 'b';
            
            inx++;
        }
    }

}


public class KDiverseStr
{
    public static void main(String[] args)
    {
        System.out.println(">>>" + new Solution().getHappyString(10, 100));
    }
    
}
