// https://leetcode.com/problems/maximum-binary-string-after-change/
class Solution
{
    private int cut = -1;
    
    public String maximumBinaryString(String s)
    {
        char arr[] = s.toCharArray();
        
        // make cut
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] == '1') cut++;
            else break;
        }
        
        int zeros = 0;
        for (int i = Math.max(0, cut); i < arr.length; i++)
            if (arr[i] == '0') zeros++;
        
        if (zeros > 1)
        {
            int nextcut = cut + 1;
            for (int i = cut + 1; i < arr.length; i++)
            {
                if (zeros > 1)
                {
                    arr[i] = '1';
                    zeros--;
                    nextcut++;
                }
            }
            
            arr[nextcut] = '0';
            for (int i = nextcut + 1; i < arr.length; i++)
                arr[i] = '1';
        }
        
        return new String(arr);
    }
}
