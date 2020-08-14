// https://www.interviewbit.com/problems/commutable-islands/
package commuteisles;
import java.util.*;

class Solution
{
    private int[] parent;
    
    public int solve(int numIslands, ArrayList<ArrayList<Integer>> bridges)
    {
        Collections.sort(bridges, new MyComparator());
        parent = setUnion(numIslands);
        int cost = 0;        
        for (ArrayList<Integer> br : bridges)
        {
//            System.out.println("bridge : " + br);
            
            int src = br.get(0) - 1;
            int dst = br.get(1) - 1;
            
            int p1 = findParent(src);
            int p2 = findParent(dst);
            
            if (p1 == p2) continue;
            
            makeUnion(p1, p2);
            cost += br.get(2);
        }

        return cost;
    }

    private int[] setUnion(int numIslands)
    {
        int ans[] = new int[numIslands];
        Arrays.fill(ans, -1);
        return ans;
    }

    private int findParent(int i)
    {
        if (parent[i] < 0) return i; // root
        return findParent(parent[i]);
    }

    private void makeUnion(int x, int y)
    {
        parent[x] = y;
    }

    private static class MyComparator implements Comparator<ArrayList<Integer>>
    {
        @Override
        public int compare(ArrayList<Integer> b1, ArrayList<Integer> b2)
        {
            return b1.get(2) - b2.get(2);
        }
    }
}

public class CommuteIsles
{
    public static void main(String[] args)
    {
        int num = 4;
        int[][] br = { {1, 2, 1}, {2, 3, 4}, {1, 4, 3},
            {4, 3, 2}, {1, 3, 10}};
        
        ArrayList<ArrayList<Integer>> bridges = new ArrayList<>();
        for (int[] b : br)
        {
            ArrayList<Integer> elem = new ArrayList<>();
            for (int x : b)
                elem.add(x);
            bridges.add(elem);
        }
        
        System.out.println(new Solution().solve(num, bridges));
        
    }
}
