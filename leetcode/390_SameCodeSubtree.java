package samecode;
import java.util.Arrays;

class Solution
{
    private static final int ABCSIZE = 26;
    
    public int[] countSubTrees(int n, int[][] edges, String labels)
    {
        // UG
        Graph<Integer> g = new Graph<>(n);
        for (int[] e : edges)
        {
            g.addEdge(e[0], e[1]);
            g.addEdge(e[1], e[0]);
        }
        
        int counter[] = new int[ABCSIZE];
        int result[]  = new int[n];
        dfs(0, labels, g, counter, result);
        return result;
    }

    // dfs
    private void dfs(int node, String labels, Graph<Integer> g, int[] counter, int[] result)
    {
        if (result[node] == 0)
        {
            // visit
            result[node] = 1;
            
            for (Integer child : g.getAdjacency(node))
            {
                int childCounter[] = new int[ABCSIZE];
                
                if (result[child] == 0)
                {
                    dfs(child, labels, g, childCounter, result);
                    for (int i = 0; i < counter.length; i++)
                        counter[i] += childCounter[i];
                }
            }

            int ix = labels.charAt(node) - 'a';
            counter[ix] += 1;
            result[node] = counter[ix];
        }
    }
}

public class SameCode
{
    public static void main(String[] args)
    {
        int arr[][] = {{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}};
        String str = "abaedcd";
        System.out.println(Arrays.toString(new Solution().countSubTrees(7, arr, str)));
    }
    
}
