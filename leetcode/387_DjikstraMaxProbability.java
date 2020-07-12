// https://leetcode.com/contest/weekly-contest-197/problems/path-with-maximum-probability/

package con3;
import java.util.*;

class Solution
{
    // Djikstra's
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int target)
    {
        Graph<Edge> g = new Graph<>(n);
        
        for (int i = 0; i < succProb.length; i++)
        {
            double prob = succProb[i];
            Edge e1 = new Edge(edges[i][1], prob);
            g.addEdge(edges[i][0], e1);
            
            Edge e2 = new Edge(edges[i][0], prob);
            g.addEdge(edges[i][1], e2);
        }
        
        boolean maxProbTree[] = new boolean[n];
        double  MptProbability[] = new double[n];
        MptProbability[start] = 1.0;
        
        for (int count = 0; count < n - 1; count++)
        {
            int maxNode = findMaxNode(maxProbTree, MptProbability);
            
            maxProbTree[maxNode] = true;
            double currMaxProb = MptProbability[maxNode];
            for (Edge edge : g.getAdjacency(maxNode))
            {
                int node = edge.node;
                double nextProb = currMaxProb*edge.probability;
                
                if (nextProb > MptProbability[node])
                    MptProbability[node] = nextProb;
            }
        }
        
        return MptProbability[target];
    }

    private int findMaxNode(boolean[] tree, double[] probability)
    {
        double max = -1;
        int maxindex = -1;
        
        for (int i = 0; i < tree.length; i++)
        {
            if (tree[i]) continue;
            
            if (probability[i] > max)
            {
                max = probability[i];
                maxindex = i;
            }
        }
        
        return maxindex;
    }
}

public class Con3
{
    public static void main(String[] args)
    {
//        int edges[][] = { {0,1},{1,2},{0,2} };
//        double succProb[] = {0.5, 0.5, 0.2};
//        System.out.println(new Solution().maxProbability(3, edges, succProb, 0, 2));

        int edges[][] = { {1,4},{2,4},{0,4}, {0,3}, {0,2}, {2,3} };
        double succProb[] = {0.37,0.17,0.93,0.23,0.39,0.04};
        System.out.println(new Solution().maxProbability(5, edges, succProb, 3, 4));
    }
    
}
