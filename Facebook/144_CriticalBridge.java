// https://leetcode.com/problems/critical-connections-in-a-network/
// https://www.hackerearth.com/practice/algorithms/graphs/articulation-points-and-bridges/tutorial/

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


class Edge
{
    int from, to;

    public Edge(int from, int to)
    {
        if (from == to) throw new IllegalArgumentException();

        if (from < to)
        {
            this.from = from;
            this.to = to;
        }
        else
        {
            this.from = to;
            this.to = from;
        }
    }

    @Override
    public int hashCode()
    {
        long hash = 7;
        hash = 31 * hash + this.from;
        hash = 31 * hash + this.to;
        hash = hash % 1_000_000_007;
        return (int) hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (getClass() != obj.getClass())
            return false;

        final Edge other = (Edge) obj;
        if (this.from != other.from)
            return false;

        if (this.to != other.to)
            return false;

        return true;
    }

    @Override
    public String toString()
    {
        return "(" + from + ", " + to + ')';
    }
}


class Graph
{
    private List<ArrayList<Integer>> adjacency;
    private int numEdges;
    private int numNodes;
    
    public Graph(Integer numVertices)
    {
        numNodes = numVertices;
        numEdges = 0;
        adjacency = new ArrayList<>(numVertices);
        
        for (int i = 0; i < numVertices; i++)
            adjacency.add(new ArrayList<>());
    }
    
    void addEdge(Edge e)
    {
        numEdges++;
        adjacency.get(e.from).add(e.to);
        adjacency.get(e.to).add(e.from);
    }
    
    List<Integer> getAdjacency(int index)
    {
        return adjacency.get(index);
    }

    public int getEdges()
    {
        return numEdges;
    }

    public int getNodes()
    {
        return numNodes;
    }
}
