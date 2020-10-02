// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
package goog1;
import java.util.*;

class Solution
{
    public String removeDuplicates(String S, int kCount)
    {
        Stack<Elem> stk = new Stack<>();
        for (char c : S.toCharArray())
        {
            if (stk.isEmpty())
            {
                stk.add(new Elem(1, c));
                continue;
            }
            
            Elem prev = stk.peek();
            if (prev.ch != c)
            {
                stk.add(new Elem(1, c));
                continue;
            }

            prev.cnt++;
            while (!stk.isEmpty())
            {
                Elem nxt = stk.peek();
                if (nxt.cnt < kCount)
                    break;

                stk.pop();
                break;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (Elem elem : stk)
        {
            for (int i = 0; i < elem.cnt; i++)
                sb.append(elem.ch);
        }
        return sb.toString();
    }

    private static class Elem
    {
        int cnt; char ch;
        public Elem(int cnt, char ch) { this.cnt = cnt; this.ch = ch;}

        @Override
        public String toString() {
            return cnt + " @ " + ch;
        }
        
    }
}

public class Goog1
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().removeDuplicates("pbbcggttciiippooaais", 2));
    }
}
