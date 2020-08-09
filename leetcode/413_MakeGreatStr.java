// https://leetcode.com/problems/make-the-string-great/
package goodstring;
import java.util.*;

class Solution
{
    public String makeGood(String s)
    {
        LinkedList<Character> lst = new LinkedList<>();
        for (char c : s.toCharArray())
            lst.add(c);
        
        while (!lst.isEmpty())
        {
            int removeAt = -1;
            for (int i = 0; i < lst.size() - 1; i++)
            {
                char fr = lst.get(i);
                char sn = lst.get(i+1);
                
                boolean skip = false;
                if (Character.isLowerCase(fr) && Character.isUpperCase(sn))
                {
                    if (Character.toUpperCase(fr) == sn)
                        skip = true;
                }
                else if (Character.isUpperCase(fr) && Character.isLowerCase(sn))
                {
                    if (Character.toUpperCase(sn) == fr)
                        skip = true;
                }
                
                if (skip)
                {
                    removeAt = i; break;                    
                }
            }
            
            if (removeAt >= 0)
            {
                lst.remove(removeAt + 1);
                lst.remove(removeAt);
            }
            else break;
        }
        
        if (lst.isEmpty()) return new String();
        
        StringBuilder sb = new StringBuilder(lst.size());
        for (char c : lst)
            sb.append(c);
        return sb.toString();
    }
}

public class GoodString
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().makeGood("abBAcC"));
    }
    
}
