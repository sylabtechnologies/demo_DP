package goog11;
import java.util.*;

// BFS https://leetcode.com/problems/lexicographically-smallest-string-after-applying-operations/
class Solution
{
    public String findLexSmallestString(String s, int a, int b)
    {
        HashSet<String> visited = new HashSet<>();
        Queue<String>   queue   = new LinkedList<>();
        queue.add(s);
        
        String smallest = s;
        while (!queue.isEmpty())
        {
            String node = queue.poll();
            if (visited.contains(node))
                continue;
            else
                visited.add(node);
            
            if (smallest.compareTo(node) > 0)
                smallest = node;
            
            queue.add(rotate(node, b));
            queue.add(addNum(node, a));
        }
       
        return smallest;
    }

    private String rotate(String s, final int b)
    {
        int len = s.length();
        return s.substring(len - b) + s.substring(0, len - b);
    }

    private String addNum(String s, final int a)
    {
        char arr[] = s.toCharArray();
        for (int j = 1; j < arr.length; j += 2)
        {
            int x = arr[j] - '0';
            x = (x + a) % 10;
            arr[j] = (char) (x + '0');
        }
        return new String(arr);
    }
}
