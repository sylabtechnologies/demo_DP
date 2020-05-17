// https://leetcode.com/problems/rearrange-words-in-a-sentence/

package rearrangestr;
import java.util.ArrayList;

class Solution
{
    public String arrangeWords(String text)
    {
        String words[] = text.split(" ");
        MultiMap<Integer, String> map = new MultiMap<>();
        
        for (String word : words)
        {
            int len = word.length();
            map.put(len, word.toLowerCase());
        }
        
        ArrayList<Integer> keys = map.getKeys(true);
        ArrayList<String> ans = new ArrayList<>();
        for (Integer key : keys)
        {
            ArrayList<String> row = map.getRow(key);
            for (String word : row)
                ans.add(word);
        }
        
        String first = ans.get(0);
        String cap = first.substring(0, 1).toUpperCase();
        cap = cap + first.substring(1);
        ans.set(0, cap);
        
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < ans.size(); i++)
        {
            res.append(ans.get(i));
            if (i != ans.size() - 1) res.append(" ");
        }
            
        return res.toString();
    }
}

public class ArrangeWords
{
    public static void main(String[] args)
    {
        String text = "Leetcode is cool";
        System.out.println(new Solution().arrangeWords(text));
    }
    
}
