// https://leetcode.com/problems/reorganize-string/
import java.util.*;

class Solution
{
    public String reorganizeString(String str)
    {
        PriorityQueue<Elem> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        int freq[] = setFreq(str);
        for (int i = 0; i < freq.length; i++)
        {
            if (freq[i] != 0)
                pq.add(new Elem( (char)('a' + i), freq[i]));
        }

        StringBuilder res = new StringBuilder();
        Stack<Elem> stk = new Stack<>();
        while (!pq.isEmpty())
        {
//            System.out.println(pq);
            
            Elem curr = pq.poll();
            res.append(curr.ch);
            curr.len -= 1;
            if (curr.len == 0) continue;
            
            Elem next = pq.poll();
            if (next == null)
                return new String();
            res.append(next.ch);
            next.len -= 1;
            if (next.len > 0) pq.offer(next);
            pq.offer(curr);
            
        }
        
        return res.toString();
    }

    private int[] setFreq(String s)
    {
        int freq[] = new int[26];
        for (char c : s.toCharArray())
        {
            int ix = c - 'a';
            freq[ix]++;
        }

        return freq;
    }    
    
    private static class Elem implements Comparable<Elem>
    {
        char ch; int len;

        public Elem(char c, int len)
        {
            this.ch = c;
            this.len = len;
        }

        @Override
        public int compareTo(Elem el)
        {
            if (this.len != el.len)
                return this.len - el.len;

            return el.ch - this.ch;
        }

        @Override
        public String toString() {
            return ch + " : " + len ;
        }
        
        
    }
}

public class TextPack
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().reorganizeString("abbabbaaab"));
    }
    
}
