// https://leetcode.com/problems/minimum-cost-to-connect-two-groups-of-points/
// cant Kruskal disconnected compos
package kruskalcities;
import java.util.*;

class Solution
{
    private int size1, size2, result;
    private boolean visited[];
    private int memoMin[];
    
    public int connectTwoGroups(List<List<Integer>> cost)
    {
        size1 = cost.size();
        size2 = cost.get(0).size();
        result = Integer.MAX_VALUE;
        visited = new boolean[size1 + size2];
        
        memoMin = new int[size2];
        for (int ix = 0; ix < size2; ix++)
        {
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < size1; i++)
                min = Math.min(min, cost.get(i).get(ix));
            
            memoMin[ix] = min;
        }
        
        dfs(0, 0, cost);
        return result;
    }

    private void dfs(int globalIx, int sum, List<List<Integer>> cost)
    {
        if (globalIx == size1 + size2)
        {
            result = Math.min(result, sum);
            return;
        }
        
        if (sum > result) return;

        if (globalIx < size1)
        {
            visited[globalIx] = true;
            for (int i = 0; i < size2; i++)
            {
                boolean sav = visited[i + size1];
                visited[i + size1] = true;
                dfs(globalIx + 1, sum + cost.get(globalIx).get(i), cost);
                visited[i + size1] = sav;
            }
        }
        else
        {
            if (visited[globalIx])
                dfs(globalIx+1, sum, cost);
            else
                dfs(globalIx + 1, sum + memoMin[globalIx - size1], cost);
        }
        
    }
}

public class KruskalCities
{
    public static void main(String[] args)
    {
        int edges[][] = {{1,3,5}, {4,1,1}, {1, 5, 3}};
        List<List<Integer>> cost = new ArrayList<>();
        for (int i = 0; i < edges.length; i++)
        {
            List<Integer> row = new ArrayList<>();
            for (Integer cst : edges[i])
                row.add(cst);
            cost.add(row);          
        }
        
        System.out.println(new Solution().connectTwoGroups(cost));
    }
}

