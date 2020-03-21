package routers;
import java.util.*;

/*
https://www.geeksforgeeks.org/articulation-points-or-cut-vertices-in-a-graph/

sect 5.9.2 http://mimoza.marmara.edu.tr/~msakalli/cse706_12/SkienaTheAlgorithmDesignManual.pdf

https://aonecode.com/amazon-online-assessment-questions

https://www.glassdoor.com/Interview/OA-3-Linked-list-questions-Onsite-using-BST-find-connections-in-social-network-OO-questions-like-method-accessment-poly-QTN_867972.htm

google amcat oa

*/

public class Solution
{        
    List<Integer> criticalRouters(int numRouters, int numLinks, ArrayList<ArrayList<Integer>> links)
    {
        MultiMap<Integer, Integer> graph = new MultiMap<>();
        for (ArrayList<Integer> link : links)
        {
            graph.put(link.get(0), link.get(1));
            graph.put(link.get(1), link.get(0));
        }
        
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= numRouters; i++)
        {
            if (!bfs(numRouters, i, graph))
                ans.add(i);
        }
    
        return ans;
    }

    private boolean bfs(int n, int i, MultiMap<Integer, Integer> nodes)
    {
        System.out.println("remove " + i);

        Queue<Integer> bfs = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];
        int visitCount = 0;
        visited[i] = true;
        
        if (i == 1)
            bfs.add(2);
        else
            bfs.add(1);
        
        while (!bfs.isEmpty())
        {
            int node = bfs.poll();
            System.out.println(node);

            if (visited[node]) continue;
            visited[node] = true;
            
            visitCount++;
            
            ArrayList<Integer> row = nodes.getRow(node);
            System.out.println(row);
            
            for (Integer e : row)
            {
                if (visited[e]) continue;;
                bfs.offer(e);
            }
        }        

        return visitCount == n - 1;
    }
}