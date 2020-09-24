// https://leetcode.com/problems/course-schedule/
package toposort1;
import java.util.*;

class Solution
{
    public boolean canFinish(int numCourses, int[][] prerequisites)
    {
        Graph g = new Graph(numCourses);

        int[] indegree = new int[numCourses];
        for (int[] prereq : prerequisites)
        {
            g.addEdge(prereq[0], prereq[1]);
            indegree[prereq[1]]++;
        }
        
        // add topostarters
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[numCourses];
        for (int i = 0; i < indegree.length; i++)
        {
            if (indegree[i] == 0)
                q.add(i);
        }
        
        int count = 0;
        while (!q.isEmpty())
        {
            int node = q.poll();
            visited[node] = true;
            count++;
            
            
            for (Integer next : g.getAdjacency(node))
            {
                if (visited[next]) continue;
                
                /* 'remove each node's outbound edges from the graph' */
                indegree[next] -= 1;
                if (indegree[next] == 0) q.offer(next);
            }
        }
        
        return count == numCourses;
    }
}

