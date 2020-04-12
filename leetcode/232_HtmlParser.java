// https://leetcode.com/contest/weekly-contest-184
package htmlparser;

import java.util.HashMap;

class Solution
{
    static HashMap<String, Character> symbols;
    static HashMap<String, String> fullSymbols;
    static
    {
        symbols = new HashMap<>();
        symbols.put("ot", '\"');
        symbols.put("os", '\'');
        symbols.put("mp", '&');
        symbols.put("gt", '>');
        symbols.put("lt", '<');
        symbols.put("sl", '/');

        fullSymbols = new HashMap<>();
        fullSymbols.put("ot", "&quot");
        fullSymbols.put("os", "&apos");
        fullSymbols.put("mp", "&amp");
        fullSymbols.put("gt", "&gt");
        fullSymbols.put("lt", "&lt");
        fullSymbols.put("sl", "&frasl");
    }
    
    public String entityParser(String text)
    {
        String token[] = text.split(";");
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < token.length; i++)
        {
            String str = token[i];
//            System.out.println(str);
            
            boolean found = false;
            int replace = 0;
            Character sym = '?';
            
            if (str.length() >= 2) 
            {
                String key = str.substring(str.length() - 2);
                
                sym = symbols.get(key);
                if (sym != null)
                {
                    String full = fullSymbols.get(key);
                    replace = full.length();
                    if (full.length() <= str.length())
                    {
                        String cmp = str.substring(str.length() - full.length());
                        if (full.equals(cmp))
                            found = true;
                    }


                    
                }
            }
            
            if (found)
            {
                sb.append(str.substring(0, str.length() - replace));
                sb.append(sym);
            }
            else
            {
                sb.append(str);
                if (i != token.length - 1)
                    sb.append(';');
            }
            
        }
               
        return sb.toString();
    }
}

public class HtmlParser
{
    public static void main(String[] args)
    {
        Solution sl = new Solution();
        System.out.println(sl.entityParser("x &gt; y &amp;&amp; x &lt; y is always false"));
    }
    
}
