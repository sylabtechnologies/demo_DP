// https://leetcode.com/problems/connecting-cities-with-minimum-cost/
package kruskalcities;
import java.util.*;

class Solution
{
    private int[] parent;

    public int minimumCost(int n, int[][] connections)
    {
        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 0; i < connections.length; i++)
        {
            int x = connections[i][0] - 1;  // check bases
            int y = connections[i][1] - 1;
            int dist = connections[i][2];
            edges.add(new Edge(x, y, dist));
        }
        
        Collections.sort(edges);
        
        parent = setUnion(n);
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
        
        int parCnt = 0;
        for (int p : parent)
            if (p == -1) parCnt++;
        
        return (parCnt == 1) ? cost : -1;
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
