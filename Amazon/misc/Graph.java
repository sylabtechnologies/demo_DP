package cheapflights;
import java.util.*;

// #D graph
class Graph
{
    private List<HashSet<Weight>> adjacency;

    public Graph(Integer numVertices)
    {
        adjacency = new ArrayList<>(numVertices);
        
        for (int i = 0; i < numVertices; i++)
            adjacency.add(new HashSet<>());
    }
    
    void addEdge(int from, int to, int price)
    {
        HashSet<Weight> node = adjacency.get(from);
        node.add(new Weight(to, price));
    }
    
    HashSet<Weight> getAdjacency(int index)
    {
        return adjacency.get(index);
    }
}

