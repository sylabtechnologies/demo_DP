// https://leetcode.com/contest/weekly-contest-206/problems/min-cost-to-connect-all-points/

class Solution
{
    private int[] parent;
    
    public int minCostConnectPoints(int[][] points)
    {
        int n = points.length;
        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 0; i < points.length; i++)
        {
            int x = points[i][0];
            int y = points[i][1];
            
            for (int j = i + 1; j < points.length; j++)
            {
                if (i == j) continue;

                int x1 = points[j][0];
                int y1 = points[j][1];
                int dist = Math.abs(x-x1) + Math.abs(y-y1);
                edges.add(new Edge(dist, i, j));
            }
        }
        
        parent = setUnion(n);
        Collections.sort(edges);
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

        public Edge(int dist, int from, int to)
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
