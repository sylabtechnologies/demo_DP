// https://leetcode.com/problems/rearrange-spaces-between-words/
import java.util.*;

class Solution
{
    public String reorderSpaces(String text)
    {
        ArrayList<String> words = new ArrayList<>();
        
        int spaces = text.length();
        for (String w : text.split(" "))
        {
            if (!w.isEmpty())
            {
                words.add(w);
                spaces -= w.length();
            }
        }
        
        if (words.isEmpty()) return text;
        if (words.size() == 1) return words.get(0) + spaceX(spaces);
        if (words.size() == 2) return words.get(0) + spaceX(spaces) + words.get(1);

        int num = words.size() - 1;
        int div = spaces / num;

        String spc = spaceX(div);
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < words.size() - 1; i++)
            ret.append(words.get(i) + spc);
        
        spaces = spaces - div*num;
        ret.append(words.get(words.size() - 1));
        ret.append(spaceX(spaces));
        return ret.toString();
    }

    private String spaceX(int num)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++)
            sb.append(' ');
        
        return sb.toString();
    }
}

