package criticalnode;
import java.util.*;

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