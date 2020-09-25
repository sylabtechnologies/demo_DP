// https://leetcode.com/problems/parallel-courses/
package toposort1;
import java.util.*;

class Solution
{
    public int minimumSemesters(int numCourses, int[][] prerequisites)
    {
        Graph g = new Graph(numCourses);

        int[] indegree = new int[numCourses];
        for (int[] prereq : prerequisites)
        {
            int nb1 = prereq[0] - 1;
            int nb2 = prereq[1] - 1;
            
            g.addEdge(nb1, nb2);
            indegree[nb2]++;
        }
        
        // add topostarters
        Queue<Integer> q = new LinkedList<>();
        int time[] = new int[numCourses];
        for (int i = 0; i < indegree.length; i++)
        {
            if (indegree[i] == 0)
            {
                q.add(i);
                time[i] = 1;
            }
        }
        
        int count = 0, ret = -1;
        while (!q.isEmpty())
        {
            int node = q.poll();
            count++;
            
            for (Integer next : g.getAdjacency(node))
            {
                if (time[next] != 0) continue;
                
                /* 'remove each node's outbound edges from the graph' */
                indegree[next] -= 1;
                if (indegree[next] == 0)
                {
                    q.offer(next);
                    time[next] = time[node] + 1;
                    ret = Math.max(ret, time[next]);
                }
            }
        }
        
        return (count == numCourses) ? ret : -1;
    }
}

public class TopoSort1
{
    public static void main(String[] args)
    {
        int crs[][] = {{1,2},{2,3},{3,1}};
//        int crs[][] = {{1, 3},{2,3}};
        Solution sl = new Solution();
        System.out.println(sl.minimumSemesters(3, crs));
    }
}
