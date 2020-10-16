package goog10;
import java.util.*;

// toposolution https://leetcode.com/problems/coin-path/
/// w/ bfs decrease of indegrees

class Solution
{
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs)
    {
        if (seqs.size() == 0) return org.length == 0;
        
        int ll = org.length;
        Graph g = new Graph(ll);
        int[] inDegree = new int[ll];
        
        for(List<Integer> s : seqs)
        {
            if(s.size() == 1)
                if(s.get(0) <= 0 || s.get(0) > ll) return false;

            for(int i = 0; i < s.size() - 1; i++)
            {
                if (s.get(i) <= 0 || s.get(i) > ll || s.get(i + 1) <= 0 || s.get(i + 1) > ll)
                    return false;

                int from = s.get(i) - 1, to = s.get(i+1) - 1;
                g.add(from, to);
                inDegree[to]++;
            }
        }

        Queue<Integer> q = new ArrayDeque();
        for (int i = 0; i < inDegree.length; i++)
            if (inDegree[i] == 0) q.add(i);
        
        if (q.size() > 1) return false;
        
        int crIx = 0;
        while (!q.isEmpty())
        {
            if (q.size() > 1) return false;
            int node = q.poll();
            
            if (crIx >= org.length) return false;
            if (node + 1 != org[crIx++]) return false;
            
            for (int to : g.getAdjacent(node))
            {
                inDegree[to]--;
                if (inDegree[to] == 0)
                    q.offer(to);
            }
        }
        
        return crIx == org.length;
    }
}

