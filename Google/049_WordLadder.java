package goog12;
import java.util.*;

// https://leetcode.com/problems/word-ladder/
class Solution
{
    public int ladderLength(String beginWord, String endWord, List<String> wordList)
    {
        boolean contains = false;
        Graph g = new Graph(wordList);
        for (int i = 0; i < wordList.size(); i++)
        {
            String from = wordList.get(i);
            if (from.equals(beginWord)) contains = true;
            
            for (int j = 0; j < wordList.size(); j++)
            {
                if (i == j) continue;
                
                String to = wordList.get(j);
                if (distance(from, to) > 1)
                    continue;
                else
                    g.add(from, to);
            }
            
        }
        
        Queue<String> bfs = new LinkedList<>();
        HashMap<String, Integer> lengths = new HashMap<>();
        if (contains)
        {
            bfs.add(beginWord);
            lengths.put(beginWord, 0);
        }
        else
        {
            for (String str : wordList)
            {
                if (distance(beginWord, str) > 1) continue;

                bfs.add(str);
                lengths.put(str, 1);
            }
        }
        
        HashSet<String> visited = new HashSet<>();
        while(!bfs.isEmpty())
        {
            String node = bfs.poll();
            if (visited.contains(node))
                continue;
            else
                visited.add(node);
            
            int len = lengths.get(node);
            if (node.equals(endWord)) return len;
            
            for (String next : g.getAdjacent(node))
            {
                bfs.add(next);
                lengths.put(next, len+1);
            }
        }

        return 0;
    }

    private int distance(String from, String to)
    {
        int cnt = 0;
        for (int i = 0; i < from.length(); i++)
        {
            if (from.charAt(i) != to.charAt(i))
                cnt++;
        }

        return cnt;
    }
}

public class Goog12
{
    public static void main(String[] args)
    {
        Solution sl = new Solution();
        System.out.println(sl.ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog")));
    }
    
}
