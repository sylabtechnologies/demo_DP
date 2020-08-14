// https://leetcode.com/problems/network-delay-time/ - dijkstra
package networkdelay;
import java.util.*;

class Solution
{
    public int networkDelayTime(int[][] times, int numNodes, int K)
    {
        Graph<Edge> g = new Graph<>(numNodes);
        for (int[] t : times)
        {
            Edge next = new Edge(t[1] - 1, t[2]);
            g.addEdge(t[0] - 1, next);
        }

        boolean shortTree[] = new boolean[numNodes];
        int distance[] = new int[numNodes];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[K-1] = 0;
        
        for (int node = 0; node < numNodes; node++)
        {
            int u = minDist(distance, shortTree);
            if (u < 0) continue;
            
            shortTree[u] = true;
            if (distance[u] == Integer.MAX_VALUE) continue;
            
            for (Edge el : g.getAdjacency(u))
            {
                if (shortTree[el.destination]) continue;
                
                int nextDist = distance[u] + el.weight;
                if (nextDist < distance[el.destination])
                    distance[el.destination] = distance[u] + el.weight;
            }
        }

        int max = -1;
        for (int dist : distance)
        {
            if (dist == Integer.MAX_VALUE) return -1;
            if (dist > max) max = dist;
        }
        return max;
    }
    
    // pick min not in sptSet
    private int minDist(int[] distance, boolean [] treeSet)
    {
        int min = Integer.MAX_VALUE;
        int index = -1;
        
        for (int i = 0; i < distance.length; i++)
        {
            if (treeSet[i]) continue;
            
            if (distance[i] < min)
            {
                min = distance[i];
                index = i;                
            }
        }
        
        return index;        
    }

    private static class Edge
    {
        int destination, weight;
        public Edge(int dest, int w) { destination = dest; weight = w; }
        @Override
        public String toString() { return "->" + destination + " @" + weight; }
    }
}

public class NetworkDelay
{
    public static void main(String[] args)
    {
//        int times[][] = {{2,1,1}, {2,3,1}, {3,4,1}};
        int times[][] = {{1,2,1}, {2,3,2}, {1,3,2}};
        System.out.println(new Solution().networkDelayTime(times, 3, 1)); 
    }
    
}

class Graph<E>
{
    private ArrayList<ArrayList<E>> adjacency;

    public Graph(Integer numVertices)
    {
        adjacency = new ArrayList<>(numVertices);
        
        for (int i = 0; i < numVertices; i++)
            adjacency.add(new ArrayList<>());
    }
    
    void addEdge(int from, E to)
    {
        ArrayList<E> node = adjacency.get(from);
        node.add(to);
    }
    
    ArrayList<E> getAdjacency(int index)
    {
        return adjacency.get(index);
    }
}
