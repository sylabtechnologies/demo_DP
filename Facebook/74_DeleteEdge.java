/// mod problem - https://www.interviewbit.com/problems/delete-edge/
package deleteedge;
import java.util.*;

class Solution
{
    Graph<Integer> g;
    public int deleteEdge(int[] weight, int[][] edges)
    {
        int n = weight.length;
        g = new Graph<>(n);
        for (int[] e : edges)
        {
            e[0]--; e[1]--;
            g.addEdge(e[0], e[1]);
            g.addEdge(e[1], e[0]);
        }
        
        // totsum
        boolean visited[] = new boolean[n];
        LinkedList<Integer> q = new LinkedList<>();
        q.add(edges[0][0]);
        long totSum = bfs(q, weight, visited);
        
        long max = -1;
        for (int[] edge : edges)
        {
            visited= new boolean[n];
            q.add(edge[0]);
            visited[edge[1]] = true;
 
            long sum = bfs(q, weight, visited);
            max = Math.max(max, sum*(totSum - sum) % 1_000_000_007);
        }
        
        return (int) (max);
    }

    private long bfs(LinkedList<Integer> q, int[] weight, boolean[] visited)
    {
        long sum = 0;
        while (!q.isEmpty())
        {
            int node = q.poll();
            if (visited[node]) continue;
            visited[node] = true;

            sum += weight[node];

            for (int next : g.getAdjacency(node))
                q.add(next);
        }
        
        return sum;
    }
}

public class DeleteEdge
{
    public static void main(String[] args)
    {
        int w[] = {10, 5, 12, 6};
        int ed[][] = {{1,2}, {1,4}, {4,3}};
        System.out.println(new Solution().deleteEdge(w, ed));
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
