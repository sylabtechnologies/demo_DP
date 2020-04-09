// https://leetcode.com/problems/backspace-string-compare/

package bkspacestr;
import java.util.LinkedList;

class Solution
{
    private final static char BACKSPACE = '#';
            
    public boolean backspaceCompare(String str1, String str2)
    {
        LinkedList<Character> lst1 = strToList(str1);
        LinkedList<Character> lst2 = strToList(str2);
        
        if (lst1.size() != lst2.size()) return false;
        
        for (int i = 0; i < lst1.size(); i++)
            if (lst1.get(i) != lst2.get(i)) return false;
                
        return true;
    }

    private LinkedList<Character> strToList(String str1)
    {
        LinkedList<Character> result = new LinkedList<>();
        
        for (char c : str1.toCharArray())
        {
            if (c == BACKSPACE)
            {
                if (!result.isEmpty()) 
                     result.removeLast();
            }
            else
                result.addLast(c);
        }
        
        return result;
    }
}

public class BkSpaceStr
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().backspaceCompare("a##c", "#a#c"));
    }
    
}
