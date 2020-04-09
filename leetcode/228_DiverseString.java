// https://leetcode.com/problems/longest-happy-string/

package longestdiverse;
import java.util.*;

class Solution
{
    class Elem implements Comparable<Elem>
    {
        int howMany;
        char myChar;

        public Elem(int howMany, char myChar)
        {
            this.howMany = howMany;
            this.myChar = myChar;
        }

        @Override
        public int compareTo(Elem o)
        {
            if (this.howMany < o.howMany)
                return -1;
            else if (this.howMany > o.howMany)
                return 1;
            else return 0;
        }

        @Override
        public String toString()
        {
            return "[" + howMany + ", " + myChar + "]";
        }
        
    }
    
    public String longestDiverseString(int A, int B, int C)
    {
        LinkedList<Elem> queue = new LinkedList<>();
        
        if (A > 0) queue.add(new Elem(A, 'a'));
        if (B > 0) queue.add(new Elem(B, 'b'));
        if (C > 0) queue.add(new Elem(C, 'c'));
        
        StringBuilder sb = new StringBuilder();
        char lastChar = ' '; int lastCount = 0;
        while (!queue.isEmpty())
        {
            Collections.sort(queue);
//            System.out.println(queue + " " + sb);
            
            if (sb.length() > 1) lastChar = sb.charAt(sb.length() - 1);

            Elem el = queue.removeLast();
            if (el.myChar == lastChar)
            {
                if (sb.length() > 2) lastChar = sb.charAt(sb.length() - 2);
                
                if (el.myChar == lastChar)
                {
                    if (queue.isEmpty()) break;
                    
                    queue.addFirst(el);
                    el = queue.removeLast();
                }
            }
            
            sb.append(el.myChar);
            el.howMany--;
            if (el.howMany > 0) queue.add(el);
        }

        return sb.toString();
    }
}


public class LongestDiverse
{

    public static void main(String[] args)
    {
        Solution sol = new Solution();
//        System.out.println(sol.longestDiverseString(1, 4, 5));
        System.out.println(sol.longestDiverseString(0, 8, 11));
    }
    
}