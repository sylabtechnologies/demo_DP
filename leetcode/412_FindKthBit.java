// https://leetcode.com/problems/find-kth-bit-in-nth-binary-string/
package findkthbit;

class Solution
{
    public char findKthBit(int n, int k)
    {
        String res = mybin(n).toString();
        return res.charAt(k-1);
    }

    private StringBuilder mybin(int n)
    {
        if (n == 1) return new StringBuilder("0");
        
        StringBuilder res = mybin(n-1);
        
        StringBuilder invert = new StringBuilder();
        for (int i = 0; i < res.length(); i++)
        {
            char c = res.charAt(i);
            
            if (c == '0')
                invert.append('1');
            else
                invert.append('0');
            
        }
        
        res.append('1');
        res.append(invert.reverse());
        return res;
    }
}

public class FindKthBit
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().findKthBit(4, 11));
    }
    
}
