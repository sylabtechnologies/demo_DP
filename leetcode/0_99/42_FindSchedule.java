package findschedule;
import java.util.*;

class Graph
{
    private List<List<Integer>> adjacency;

    public Graph(Integer numVertices)
    {
        // set capacity
        adjacency = new ArrayList<>(numVertices);
        
        for (int i = 0; i < numVertices; i++)
            adjacency.add(new ArrayList<>());
    }
    
    void addEdge(Integer from, Integer to)
    {
        List<Integer> node = adjacency.get(from);
        node.add(to);
    }
    
    List<Integer> getAdjacency(int index)
    {
        return adjacency.get(index);
    }
}


class Solution
{
    public boolean canFinish(int numCourses, int[][] prerequisites)
    {
        Graph g = new Graph(numCourses);

        // count sinks & add edges
        int[] sinks = new int[numCourses];
        for (int[] prereq : prerequisites)
        {
            g.addEdge(prereq[0], prereq[1]);
            sinks[prereq[1]]++;
        }
        
        // populare staters
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++)
        {
            if (sinks[i] == 0)
                queue.add(i);
        }
        
        int visited = 0;
        // visit all decrementing sinks
        while (!queue.isEmpty())
        {
            int course = queue.removeFirst();
            visited++;
            
            List<Integer> list = g.getAdjacency(course);
            for (int visit : list)
            {
                sinks[visit]--;
                if (sinks[visit] == 0)
                    queue.add(visit);
            }
            
        }
        
        return visited == numCourses;
    }
}