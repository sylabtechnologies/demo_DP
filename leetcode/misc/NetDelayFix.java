// https://leetcode.com/problems/network-delay-time/ * 
// # debug 4,2,76

package mar18b;
import java.util.*;

class Solution
{
    private static class Elem
    {
        int toNode;
        int time;

        public Elem(int toNode, int time)
        {
            this.toNode = toNode;
            this.time = time;
        }
    }

    public int networkDelayTime(int[][] travelTime, int n, int start)
    {
        Queue<Integer> bfs = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        int[] time  = new int[n];
        Arrays.fill(time, -1);

        start = start -1;
        MultiMap<Integer, Elem> nodes = new MultiMap<>();
        for (int i = 0; i < travelTime.length; i++)
        {
            int from = travelTime[i][0] - 1;
            Elem el = new Elem(travelTime[i][1] - 1, travelTime[i][2]);
            nodes.put(from, el);
        }
        
        bfs.add(start);
        time[start] = 0;
        while (!bfs.isEmpty())
        {
            int node = bfs.poll();
            if (visited[node]) continue;

            visited[node] = true;
            ArrayList<Elem> row = nodes.getRow(node);
            if (row == null) continue;;
            
            for (Elem e : row)
            {
                bfs.offer(e.toNode);
                
                int newtime = time[node] + e.time;
                if (time[e.toNode] == -1)
                    time[e.toNode] = newtime;
                else
                {
                    if (newtime < time[e.toNode])
                    {
                        time[e.toNode] = newtime;
                    }
                }
            }
        }
        
        int max = 0;
        for (int i = 0; i < time.length; i++)
        {
            if (!visited[i]) return -1;
            if (time[i] > max) max = time[i];
        }
        
        return max;
    }
}

