/// https://leetcode.com/contest/weekly-contest-170/problems/decrypt-string-from-alphabet-to-integer-mapping/

package decryptstring;

import java.util.HashMap;

class Solution
{
    private static HashMap<String, Character> map = new HashMap<>();
    static
    {
        for (int i = 10; i < 27; i++)
        {
            map.put(Integer.toString(i), (char)('j' + i - 10));
        }
    }
    
    public String freqAlphabets(String s)
    {
        StringBuilder sb = new StringBuilder();

        int curr = s.length() - 1;
        while (curr >= 0)
        {
            char c;
            if (s.charAt(curr) == '#')
            {
                c = fromString(s.substring(curr - 2, curr));
                curr = curr - 3;
            }
            else
            {
                c = fromDigit(s.charAt(curr));
                curr--;
            }
            sb.append(c);
        }
        
        return sb.reverse().toString();
    }
    
    private char fromDigit(char c)
    {
        int ix = (int) c - '0';
        ix--;
        return (char) ('a' + ix);
    }

    private char fromString(String s)
    {
        Character c = map.get(s);
        
        if (c == null) throw new IllegalArgumentException();
        
        return c;
    }
    
}
