// https://leetcode.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable/
package minedges;
import java.util.*;

class Solution
{
    private static final int RED = 1;
    private static final int GREEN = 2;
    private static final int BLUE = 3;
    
    private Set<Edge> removedBlue;
    
    public int maxNumEdgesToRemove(int n, int[][] edges)
    {
        removedBlue = new TreeSet<>();
        int rem1 = unionFind(n, RED, edges);
        if (rem1 < 0) return -1;
        
        int rem2 = unionFind(n, GREEN, edges);
        if (rem2 < 0) return -1;
        
        return rem1 + rem2 + removedBlue.size();
    }

    private int unionFind(int n, int type, int[][] edges)
    {
        Union un = new Union();
        
        // find this connected set
        int setCount = 0, skipCount = 0;
        for (int[] edge : edges)
        {
            if (edge[0] != BLUE) continue;
            
            int from = edge[1], to = edge[2];
            Edge e = new Edge(from, to);
            if (removedBlue.contains(e)) continue;
            
            int par1 = un.findParent(from);
            int par2 = un.findParent(to);
            
            if (par1 == par2)
            {
                removedBlue.add(e);
                continue;
            }
            else
            {
                setCount++;
                un.makeUnion(par1, par2);
            }
        }

        for (int[] edge : edges)
        {
            if (edge[0] != type) continue;
            
            int from = edge[1], to = edge[2];
            int par1 = un.findParent(from);
            int par2 = un.findParent(to);
            
            if (par1 == par2)
            {
                skipCount++;
                continue;
            }
            else
            {
                setCount++;
                un.makeUnion(par1, par2);
            }
        }
        
        if (setCount != n - 1) return -1;
        return skipCount;
    }
}

public class MinEdges
{
    public static void main(String[] args)
    {
        int edges[][] = {{3,1,2},{3,2,3},{1,1,3},{1,2,4},{1,1,2},{2,3,4}};
        System.out.println(new Solution().maxNumEdgesToRemove(4, edges));  
    }
}

class Edge
{
    int from, to;

    public Edge(int from, int to)
    {
        from--; to--; // check base
        
        if (from == to) throw new IllegalArgumentException();

        if (from < to)
        {
            this.from = from;
            this.to = to;
        }
        else
        {
            this.from = to;
            this.to = from;
        }
    }

    @Override
    public int hashCode()
    {
        long hash = 7;
        hash = 31 * hash + this.from;
        hash = 31 * hash + this.to;
        hash = hash % 1_000_000_007;
        return (int) hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (getClass() != obj.getClass())
            return false;

        final Edge other = (Edge) obj;
        if (this.from != other.from)
            return false;

        if (this.to != other.to)
            return false;

        return true;
    }

    @Override
    public String toString()
    {
        return "(" + (from + 1) + ", " + (to + 1) + ')';
    }
    
}


