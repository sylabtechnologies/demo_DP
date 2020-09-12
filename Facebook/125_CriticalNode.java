// https://leetcode.com/problems/critical-connections-in-a-network/
// https://www.hackerearth.com/practice/algorithms/graphs/articulation-points-and-bridges/tutorial/
package criticalnode;
import java.util.*;

class Solution
{
    private static final boolean TRACE = false;
    private static boolean[] visited;
    private static int discovery[];
    private static int low[];
    private static int parent[];
    private static int time;    
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections)
    {
        Graph g = new Graph(n);
        for (List<Integer> cn : connections)
            g.addEdge(new Edge(cn.get(0), cn.get(1)));
        
        return dfsBridges(g);
    }

    private List<List<Integer>> dfsBridges(Graph g)
    {
        discovery = new int[g.getNodes()];
        low =  new int[g.getNodes()];
        parent = new int[g.getNodes()];
        Arrays.fill(parent, -1);
        visited = new boolean[g.getNodes()];
        time = 0;
        
        List<List<Integer>> ret = new ArrayList<>();
        dfsUtil(g, 0, ret);

        if (TRACE)
        {
            for (int i = 0; i < g.getNodes(); i++)
                System.out.println("discover " + i + " @ " + discovery[i] + " low " + low[i]);
        }

        return ret;
    }

    private void dfsUtil(Graph g, int node, List<List<Integer>> ret)
    {
        time++;
        discovery[node] = time;
        visited[node] = true;
        low[node] = time;
        
        for (Integer next : g.getAdjacency(node))
        {
            if (visited[next])
            {
                if (next != parent[node])
                    low[node] = Math.min(low[node], discovery[next]);
            }
            else
            {
                parent[next] = node;
                dfsUtil(g, next, ret);
                
                low[node] = Math.min(low[node], low[next]);
                
                if (low[next] > discovery[node])
                    ret.add(Arrays.asList(node,next));
            }
        }
    }
}

public class CriticalNode
{
    public static void main(String[] args)
    {
        int edges[][] = {{0,1}, {0, 5}, {1, 2}, {1,3}, {2,3}, {2,4}, {3,4}};
        List<List<Integer>> conn = new ArrayList<>();
        for (int[] e : edges)
            conn.add(Arrays.asList(e[0],e[1]));
        System.out.println(new Solution().criticalConnections(6, conn));
    }
}
