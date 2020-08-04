package prereqs;
import java.util.*;

class Solution
{
    // dag
    public int solve(int numCourses, int[] from, int[] to)
    {
        Graph<Integer> g = new Graph<>(numCourses);
        int sinks[] = new int[numCourses];
        for (int i = 0; i < from.length; i++)
        {
            g.addEdge(from[i] - 1, to[i] - 1);
            sinks[to[i] - 1]++;
        }
        
        int visited = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < sinks.length; i++)
        {
            if (sinks[i] == 0) q.offer(i);
        }
        
        while (!q.isEmpty())
        {
            int course = q.poll();
            visited++;
            
            for (Integer visit : g.getAdjacency(course))
            {
                sinks[visit]--;
                if (sinks[visit] == 0) q.offer(visit);
            }
        }

        return (visited == numCourses) ? 1 : 0;        
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

public class Prereqs
{
    public static void main(String[] args)
    {
        int b[] = {1, 2}, c[] = {2, 3};
        System.out.println(new Solution().solve(3, b, c));
    }
    
}
