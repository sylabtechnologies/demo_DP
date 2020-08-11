// https://leetcode.com/problems/plus-one/

class Solution
{
    public int[] plusOne(int[] num)
    {
        int ans[] = new int[num.length + 1];
        
        int carry = 1;
        boolean onlyCC = false;
        for (int i = num.length - 1; i >= 0; i--)
        {
            int x = num[i];
            
            if (onlyCC)
            {
                ans[i+1] = x;
                continue;
            }
            else
            {
                x += carry;
                if (x <= 9)
                {
                    carry = 0;
                    onlyCC = true;
                }
                else
                {
                    x = 0;
                    carry = 1;
                }
                    
                ans[i+1] = x;
            }
        }
        
        if (carry > 0) ans[0] = carry;
        
        int start = 0;
        while (ans[start] == 0)
            start++;
        
        int res[] = new int[ans.length - start];
        for (int i = start; i < ans.length; i++)
            res[i - start] = ans[i];
        return res;
    }
}