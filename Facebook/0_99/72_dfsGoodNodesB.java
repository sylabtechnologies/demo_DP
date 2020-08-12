/* https://www.interviewbit.com/problems/path-with-good-nodes/
  - fallsview-suisha */
package goodnodes;
import java.util.*;

class Solution
{
    // dfs
    public int solve(int[] cost, int[][] edges, int max)
    {
        int n = cost.length;
        Graph<Integer> g = new Graph<>(n);
        for (int[] edge : edges)
        {
            g.addEdge(edge[0] - 1, edge[1] - 1);
            g.addEdge(edge[1] - 1, edge[0] - 1);
        }
        
        boolean visited[] = new boolean[n];
        boolean childrn[] = new boolean[n];
        
        int res = 0;
        Stack<Integer> dfs = new Stack<>();
        dfs.add(0); visited[0] = true;
        int totalCost[] = new int[n];
        totalCost[0] = cost[0];
        
        while (!dfs.isEmpty())
        {
            int node = dfs.peek();
            
            boolean unvisitedChild = false;
            for (int next : g.getAdjacency(node))
            {
                if (!visited[next])
                {
                    unvisitedChild = true;
                    childrn[node] = true;
                    visited[next] = true;
                    dfs.add(next);
                    totalCost[next] += totalCost[node] + cost[next];
                    break;
                }
            }
            
            if (!unvisitedChild) dfs.pop();
            if (!childrn[node] && totalCost[node] <= max)
                res++;
        }
        
        return res; 
    }
}

public class GoodNodes
{
    public static void main(String[] args)
    {
        int good[] = {0, 1, 0, 1, 1, 1};
        int edges[][] = {{1,2}, {1,5}, {1,6}, {2,3}, {2,4}};
        System.out.println(new Solution().solve(good, edges, 1));
    }
    
}

class Graph<E extends Comparable<E>>
{
    private List<TreeSet<E>> adjacency;

    public Graph(Integer numVertices)
    {
        adjacency = new ArrayList<>(numVertices);
        
        for (int i = 0; i < numVertices; i++)
            adjacency.add(new TreeSet<>());
    }
    
    void addEdge(int from, E to)
    {
        TreeSet<E> node = adjacency.get(from);
        node.add(to);
    }
    
    TreeSet<E> getAdjacency(int index)
    {
        return adjacency.get(index);
    }
}
