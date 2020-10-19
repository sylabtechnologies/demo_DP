package goog10;
import java.util.*;

class Solution
{
    private int[] parent;
    
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes)
    {
        final int numPt = n + 1;
        final int waterNode = 0;
        
        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 0; i < wells.length; i++)
            edges.add(new Edge(waterNode, i + 1, wells[i]));
        for (int i = 0; i < pipes.length; i++)
        {
            int[] pipe = pipes[i];
            edges.add(new Edge(pipe[0], pipe[1], pipe[2]));
        }
        Collections.sort(edges);
        
        parent = setUnion(numPt);
        int cost = 0;
        for (Edge edge : edges)
        {
            int src = edge.from;
            int dst = edge.to;
            
            int p1 = findParent(src);
            int p2 = findParent(dst);
            
            if (p1 == p2) continue;
            
            makeUnion(p1, p2);
            cost += edge.dist;
        }
        
        return cost;
    }

    private int[] setUnion(int numPt)
    {
        int ans[] = new int[numPt];
        Arrays.fill(ans, -1);
        return ans;
    }

    private int findParent(int i)
    {
        if (parent[i] < 0) return i; // root
        return findParent(parent[i]);
    }

    private void makeUnion(int x, int y)
    {
        parent[x] = y;
    }

    class Edge implements Comparable<Edge>
    {
        int dist, from, to;

        public Edge(int from, int to, int dist)
        {
            this.dist = dist; this.from = from; this.to = to;
        }

        @Override
        public int compareTo(Edge e)
        {
            return Integer.compare(this.dist, e.dist);
        }

        @Override
        public String toString()
        {
            return "(" + from + ", " + to + ") = " + dist;
        }
    }

}


public class Goog10
{
    public static void main(String[] args)
    {
        int src[] = {1,2,2,3,2};
        int pipes[][] = {{1,2,1}, {2,3,1}, {4,5,7}};
        System.out.println(new Solution().minCostToSupplyWater(5, src, pipes));
    }

    private static List<Integer> int2lst(int[] row)
    {
        List<Integer> ret = new ArrayList<>(row.length);
        for (int x : row) ret.add(x);
        return ret;
    }    
}


