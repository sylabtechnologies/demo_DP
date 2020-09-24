// https://leetcode.com/problems/course-schedule-ii/
package toposort1;
import java.util.*;

class Solution
{
    public int[] findOrder(int numCourses, int[][] prerequisites)
    {
        Graph g = new Graph(numCourses);

        int[] indegree = new int[numCourses];
        for (int[] prereq : prerequisites)
        {
            g.addEdge(prereq[1], prereq[0]);
            indegree[prereq[0]]++;
        }
        
        // add topostarters
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[numCourses];
        for (int i = 0; i < indegree.length; i++)
        {
            if (indegree[i] == 0)
                q.add(i);
        }
        
        int count = 0, ret[] = new int[numCourses];
        while (!q.isEmpty())
        {
            int node = q.poll();
            visited[node] = true;
            ret[count++] = node;
            
            for (Integer next : g.getAdjacency(node))
            {
                if (visited[next]) continue;
                
                /* 'remove each node's outbound edges from the graph' */
                indegree[next] -= 1;
                if (indegree[next] == 0) q.offer(next);
            }
        }
        
        if (count != numCourses) return new int[0];
        return ret;
    }
}

public class TopoSort1
{
    public static void main(String[] args)
    {
        int crs[][] = {{0, 1},{1,2},{2,0}};
//        int crs[][] = {{0, 2},{1,2}};
        Solution sl = new Solution();
        System.out.println(Arrays.toString(sl.findOrder(3, crs)));
    }
}
