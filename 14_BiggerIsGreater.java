// https://www.hackerrank.com/challenges/bigger-is-greater/problem

package biggerisgreater;
import java.util.*;

public class BiggerIsGreater
{
    static String biggerIsGreater(String s)
    {
        if (s.length() < 2) return "no answer";
        
        // copy tail
        ArrayList<Character> tail = new ArrayList();
        boolean found = false;
        Character foundChar = '?';
        int i = s.length() - 1;
        
        while (i > 0)
        {
            tail.add(s.charAt(i));
            
            if (s.charAt(i) > s.charAt(i - 1))
            {
                found = true;
                foundChar = s.charAt(i - 1);
                break;
            }

            i--;
        }
        
        if (!found) return "no answer";
        
        // sort tail, find bigger char, append
        Collections.sort(tail);
        
        Character swapChar = '?';
        for (int j = 0; j < tail.size(); j++)
        {
            if (tail.get(j) > foundChar) {
                swapChar = tail.get(j);
                tail.set(j, foundChar);
                break;
            }
        }

        Collections.sort(tail);
        
        // complete the swap
        StringBuilder ans = new StringBuilder(s.substring(0, i));
        ans.setCharAt(i-1, swapChar);
        
        for (int j = 0; j < tail.size(); j++)
            ans.append(tail.get(j));
            
        return ans.toString();

    }

    public static void main(String[] args)
    {
        biggerIsGreater("dkhc");
    }
    
}
