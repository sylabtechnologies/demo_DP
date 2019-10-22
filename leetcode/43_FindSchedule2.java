package findschedule;
import java.util.*;

class Solution
{
    public int[] findOrder(int numCourses, int[][] prerequisites)
    {
        Graph g = new Graph(numCourses);
        int[] ans = new int[numCourses];

        // count sinks & add edges
        int[] sinks = new int[numCourses];
        for (int[] prereq : prerequisites)
        {
            g.addEdge(prereq[0], prereq[1]);
            sinks[prereq[1]]++;
        }
        
        // populate staters
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++)
        {
            if (sinks[i] == 0)
                queue.add(i);
        }
        
        int visited = 0;
        // visit all and decrement sinks
        while (!queue.isEmpty())
        {
            int course = queue.removeFirst();
            ans[numCourses - 1 - visited] = course;
            visited++;
            
            List<Integer> list = g.getAdjacency(course);
            for (int visit : list)
            {
                sinks[visit]--;
                if (sinks[visit] == 0)
                    queue.add(visit);
            }
            
        }
        
        if (visited == numCourses)
            return ans;
        else
            return new int[0];
    }


}