// https://leetcode.com/problems/string-compression-ii/
package stringcompression;
import java.util.*;

// has no glue!
class Solution
{
    public int getLengthOfOptimalCompression(String s, int k)
    {
        if (s.length() == 0) return 0;
        
        char prev = s.charAt(0); int len = 1;

        PriorityQueue<Link> queue = new PriorityQueue<>();
        for (int i = 1; i < s.length(); i++)
        {
            char curr = s.charAt(i);
            
            if (curr != prev)
            {
                queue.add(new Link(prev, len));
                prev = curr;
                len = 1;
            }
            else len++;
        }
        queue.offer(new Link(prev, len));
        
        while (k > 0)
        {
            Link lnk = queue.poll();
            k--;
            
            if (lnk.length() > 1)
            {
                lnk.decrement();
                queue.offer(lnk);
            }
        }
        
        int ans = 0;
        while (!queue.isEmpty())
            ans += queue.poll().length();
        return ans;
    }

    private static class Link implements Comparable<Link>
    {
        final char myChar;
        private int  length;
        private String value;

        public Link(char c, int len)
        {
            myChar = c;
            length = len;
            calcValue();
        }

        public void decrement() { length--; calcValue(); }
        public int length() { return value.length(); }
        @Override
        public String toString() { return value; }

        private void calcValue()
        {
            if (length == 1)
                value = Character.toString(myChar);
            else
                value = myChar + Integer.toString(length);
        }

        @Override
        public int compareTo(Link lnk)
        {
            if (this.length != lnk.length)
                return this.length - lnk.length;

            return this.myChar - lnk.myChar;
        }
    }
}

public class StringCompression
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().getLengthOfOptimalCompression("aabbaa", 2));
    }
}
