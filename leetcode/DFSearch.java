package lee4graph;
import java.util.*;

public class DFSearch
{
    private static boolean[] visited;
    private static int disc[];
    private static int low[];
    private static int parent[];
    private static int time;
    
    public static ArrayList<Edge> dfsCritical(Graph g, int start)
    {
        disc = new int[g.countNodes()];
        low =  new int[g.countNodes()];
        parent = new int[g.countNodes()];
        parent[0] = -1;
        visited = new boolean[g.countNodes()];
        time = 0;

        ArrayList<Edge> ans = new ArrayList<>();
        dfsHelper(g, start, ans);
        
        return ans;
    }

    public static ArrayList<Integer> dfsConnected(Graph g)
    {
        visited = new boolean[g.countNodes()];
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < visited.length; i++)
        {
            if (visited[i]) continue;

            Stack<Integer> stk = new Stack<>();
            stk.push(i);

            int count = 0;
            while (!stk.isEmpty())
            {
                int node = stk.pop();
                if (visited[node]) continue;
                visited[node] = true;

                count++;
                
                System.out.println(node + 1);

                for (Integer next : g.getAdjacency(node))
                {
                    if (!visited[next])
                        stk.push(next);
                }
            }
            
            ans.add(count);
        }
        
        return ans;
    }
    
    public static boolean allVisited()
    {
        for (boolean b : visited)
            if (!b) return false;
        return true;
    }

    private static void dfsHelper(Graph g, int node, ArrayList<Edge> ans)
    {
        time++;
        visited[node] = true;
        disc[node] = time;
        low[node] = time;

        System.out.println("discover " + node + " @ " + time);
        
        for (Integer next : g.getAdjacency(node))
        {
            if (!visited[next])
            {
                parent[next] = node;
                
                System.out.println("go = " + node + " " + next);
                dfsHelper(g, next, ans);
                
                low[node] = Math.min(low[node], low[next]);
                System.out.println("result for edge " + node + " " + next + " low = " + low[node]);
                
                if (low[next] > disc[node])
                {
                    Edge ed = new Edge(node, next);
                    ans.add(ed);
                }
            }
            else
            {
                System.out.println(Arrays.toString(low));
                if (parent[node] != next)
                {
                    low[node] = Math.min(low[node], disc[next]);
                    System.out.println("Update edge " + node + " " + next + " low = " + low[node]);
                }
            }
        }
    }
}
