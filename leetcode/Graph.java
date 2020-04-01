package dijkstra1;
import java.util.*;

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


