package goog10;
import java.util.*;



public class Goog10
{
    public static void main(String[] args)
    {
        int src[] = {1,2,2,3,2};
        int pipes[][] = {{1,2,1}, {2,3,1}, {4,5,7}};
        System.out.println(new Solution().minCostToSupplyWater(5, src, pipes));
    }

    private static List<Integer> int2lst(int[] row)
    {
        List<Integer> ret = new ArrayList<>(row.length);
        for (int x : row) ret.add(x);
        return ret;
    }    
}


