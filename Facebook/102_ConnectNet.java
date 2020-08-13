// https://leetcode.com/problems/number-of-operations-to-make-network-connected/
package connectnet;
import java.util.*;

class Solution
{
    private boolean visited[];
    private Graph<Integer> g;
    public int makeConnected(int n, int[][] connections)
    {
        /// be sure of spare parts amount
        //  the rest is to count bfs connected areas
        if (connections.length < n - 1) return -1;
        
        g = new Graph<Integer>(n);
        for (int[] con : connections)
        {
            g.addEdge(con[0], con[1]);
            g.addEdge(con[1], con[0]);
        }
        
        visited = new boolean[n];
        int count = 0;
        
        for (int i = 0; i < n; i++)
        {
            if (!visited[i])
            {
                bfs(i);
                count++;
            }
        }
        
        return count - 1;        
    }

    private void bfs(int node)
    {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        
        while (!q.isEmpty())
        {
            int curr = q.poll();

            if (visited[curr])
                continue;
            else
                visited[curr] = true;
            
            for (Integer next : g.getAdjacency(curr))
                q.add(next);
        }
    }
}

public class ConnectNet
{
    public static void main(String[] args)
    {
        int net[][] = { {0,1}, {0,2}, {3,4}, {2,3}};
        System.out.println(new Solution().makeConnected(5, net));  
    }
}
