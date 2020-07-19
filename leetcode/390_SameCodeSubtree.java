package task18b;
import java.util.*;
import java.util.LinkedList;

class Solution
{
    private static final int ABCSIZE = 26;
    
    public int[] countSubTrees(int n, int[][] edges, String labels)
    {
        int prefix[][] = new int[n][];
        for (int i = 0; i < n; i++)
        {
            prefix[i] = new int[ABCSIZE];
            int code = labels.charAt(i) - 'a';
            prefix[i][code] = 1;
        }
        
        boolean process[] = new boolean[n];
        HashMap<Integer, List<Integer>> adjacency = new HashMap<>();
        for (int[] e : edges)
        {
            List<Integer> adj = adjacency.getOrDefault(e[1], new ArrayList<>());
            adj.add(e[0]);
            adjacency.put(e[1], adj);
            process[e[0]] = true;
        }

        LinkedList<Integer> bfs = new LinkedList<>();
        for (int i = 0; i < n; i++)
        {
            if (!process[i]) bfs.add(i);
        }

        boolean visited[] = new boolean[n];
        while (!bfs.isEmpty())
        {
            int node = bfs.removeFirst();
            if (visited[node]) continue;;
            visited[node] = true;
            
            List<Integer> adj = adjacency.get(node);
            
            if (adj != null)
            {
                for (Integer next : adj)
                {
                    bfs.add(next);

                    for (int i = 0; i < ABCSIZE; i++)
                        prefix[next][i] += prefix[node][i];
                }
            }
        }
        
        int ans[] = new int[n];
        for (int i = 0; i < n; i++)
        {
            int code = labels.charAt(i) - 'a';
            ans[i] = prefix[i][code];
        }
        
        return ans;
    }
}

public class Task18B
{
    public static void main(String[] args)
    {
        int arr[][] = {{0, 2}, {0, 3}, {2, 1}};
        String str = "aeed";
        System.out.println(Arrays.toString(new Solution().countSubTrees(4, arr, str)));
    }
}

