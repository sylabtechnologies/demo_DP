/*
https://www.chegg.com/homework-help/questions-and-answers/need-solution-java-length-6-1-1-returned-string-length-8-q42378165

three alpabhets a ,b ,c
A string is called diverse if no 3 consecutive letters are same.
In other words diverse string may not contain any of the strings "aaa","bbb","ccc"

Given three integers x,y,z write a function to return any longest possible
diverse string containing at most x letters 'a', y letters 'b',z letters 'c'.
If no possiblity of building any string return empty string

= pq + NEXT

*/

package diversestring;
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
                return 1;
            else if (this.howMany > o.howMany)
                return -1;
            else return 0;
        }

        @Override
        public String toString()
        {
            return "[" + howMany + ", " + myChar + "]";
        }
        
    }
    
    public String solution(int A, int B, int C)
    {
        PriorityQueue<Elem> pq = new PriorityQueue<>();
        
        if (A > 0) pq.offer(new Elem(A, 'A'));
        if (B > 0) pq.offer(new Elem(B, 'B'));
        if (C > 0) pq.offer(new Elem(C, 'C'));
        
//        System.out.println(pq);
        
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty())
        {
            Elem el = pq.poll();

            sb.append(el.myChar);
            el.howMany -= 1;

            if (el.howMany > 0)
            {
                sb.append(el.myChar);
                el.howMany -= 1;
            }

            if (!pq.isEmpty())
            {
                Elem nxt = pq.poll();
                sb.append(nxt.myChar);
                nxt.howMany -= 1;
                if (nxt.howMany != 0) pq.offer(nxt);
            }
            else break;
            
            if (el.howMany != 0) pq.offer(el);
        }

        return sb.toString();
    }
}


public class DiverseString
{

    public static void main(String[] args)
    {
        Solution sol = new Solution();
        System.out.println(sol.solution(6, 1, 1));
        System.out.println(sol.solution(1, 3, 1));
        System.out.println(sol.solution(0, 1, 8));
    }
    
}
