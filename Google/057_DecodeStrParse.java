// https://leetcode.com/problems/decode-string/

package goog21;
import java.util.*;

class Solution
{
    public String decodeString(String s)
    {
        if (s.isEmpty()) return new String();
        
        char arr[] = s.toCharArray();
        Stack<StringBuilder> stack = new Stack<>();
        stack.add(new StringBuilder());
        int lastNumber = 0;
        
        for (char c : arr)
        {
            if (Character.isDigit(c)) // separate the digistream
            {
                lastNumber = lastNumber * 10 + (c - '0');
                continue;
            }

            if (Character.isAlphabetic(c))
            {
                stack.peek().append(c);
                continue;
            }
            
            if (c == '[')
            {
                StringBuilder elem = new StringBuilder(Integer.toString(lastNumber));
                if (!stack.isEmpty() && stack.peek().length() == 0)
                    stack.peek().append(elem);
                else
                    stack.push(elem);
                stack.push(new StringBuilder());
                lastNumber = 0;                
                continue;
            }
            
            String copy = stack.pop().toString();
            int mul = Integer.parseInt(stack.pop().toString());

            StringBuilder multip = new StringBuilder();
            for (int i = 0; i < mul; i++)
                multip.append(copy);

            if (stack.isEmpty())
            {
                stack.push(multip);
                continue;
            }
            
            // if charstream append
            // or we have ] next
            char prev = stack.peek().charAt(0);
            if (Character.isAlphabetic(prev))
                stack.peek().append(multip);
            else               
                stack.push(multip);
        }
        
        return stack.peek().toString();
    }
}

public class Goog21
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
    }
}
