// https://leetcode.com/problems/time-needed-to-inform-all-employees/ via BFS

package informemployees;
import java.util.*;

class Solution
{
    public static int numOfMinutes(int n, int headID, int[] manager, int[] informTime)
    {
        Queue<Integer> bfs = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        int[] time  = new int[n];
        int max = 0;
        
        MultiMap<Integer, Integer> nodes = new MultiMap<>();
        for (int i = 0; i < n; i++)
        {
            if (i == headID) continue;

            int boss = manager[i];
            nodes.put(boss, i);
        }
        
        bfs.add(headID);
        int visitCount = 1;
        while (!bfs.isEmpty())
        {
            int node = bfs.poll();
            if (visited[node]) continue;

            visited[node] = true;
            
            ArrayList<Integer> row = nodes.getRow(node);
            if (row == null) continue;;
            
            for (Integer i : row)
            {
                if (visited[i]) continue;
                
                bfs.offer(i);
                time[i] = informTime[node] + time[node];
                max = Math.max(time[i], max);

                visitCount++;
                if (visitCount == n) return max;
            }
            
        }
        
        return max;
    }
}

public class InformEmployees
{

    public static void main(String[] args)
    {
//        int n = 6, headID = 2;
//        int[] manager = {2,2,-1,2,2,2}, informTime = {0,0,1,0,0,0};

        int n = 7, headID = 6;
        int[] manager = {1,2,3,4,5,6,-1}, informTime = {0,6,5,4,3,2,1};
        System.out.println(Solution.numOfMinutes(n, headID, manager, informTime));
    }
        
    
}
