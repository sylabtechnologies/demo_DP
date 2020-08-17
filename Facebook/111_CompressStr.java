// https://leetcode.com/problems/string-compression/

class Solution {
    public int compress(char[] str)
    {
        if (str.length < 2) return str.length;
        
        int trunc = 0, ll = 1;
        char prev = str[trunc];
        for (int j = 1; j < str.length; j++)
        {
            char curr = str[j];
            
            if (curr != prev)
            {
                trunc = helper(str, trunc, prev, ll);
                prev = curr;
                ll = 1;
            }
            else ll++;
        }

        return helper(str, trunc, prev, ll);
    }    

    private int helper(char[] string, int start, char key, int howmany)
    {
        string[start++] = key;
        if (howmany > 1)
        {
            for (char dd : Integer.toString(howmany).toCharArray())
                string[start++] = dd;
        }
        
        return start;
    }
}