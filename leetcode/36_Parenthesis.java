/** https://leetcode.com/problems/valid-parentheses/
 * 
 * 
 */
package parenthesis;
import java.util.*;

public class Parenthesis
{
    private static final HashMap<Character, Character> braces;
    static
    {
        braces = new HashMap<>();
        braces.put('(', ')');
        braces.put('[', ']');
        braces.put('{', '}');
    }
    
    public static void main(String[] args)
    {
        System.out.println(isValid("()[]{}"));
    }

    public static boolean isValid(String s)
    {
        LinkedList<Character> list = new LinkedList<>();
        
        for (char c : s.toCharArray())
        {
            list.addLast(c);
            
            if (list.size() > 1)
            {
                Character cc = list.get(list.size() - 2);
                if ( braces.get(cc) == list.getLast())
                {
                    list.removeLast();
                    list.removeLast();
                }
            }
        }

        return list.isEmpty();
    }

    
}
