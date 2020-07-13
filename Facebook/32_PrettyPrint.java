package prettyprint;
import java.util.*;

class Solution
{
    public static ArrayList<ArrayList<Integer>> prettyPrint(int n)
    {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (n < 1) return res;
        
        ArrayList<Integer> seed = new ArrayList<>();
        for (int i = n; i >=1; i--) seed.add(i);
        for (int i = 2; i <= n; i++) seed.add(i);
        
        ArrayList<ArrayList<Integer>> half = new ArrayList<>();
        for (int i = 2; i <= n; i++)
        {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < seed.size(); j++)
            {
                int val = seed.get(j);
                if (val < i) val = i;
                row.add(val);
            }
            
            half.add(row);
        }

        for (int i = half.size() - 1; i >= 0; i--)
        {
            ArrayList<Integer> row = new ArrayList<>();
            row.addAll(half.get(i));
            res.add(row);
        }
        
        res.add(seed);
        
        for (int i = 0; i < half.size(); i++)
            res.add(half.get(i));
        
        return res;
    }
}

public class PrettyPrint
{
    public static void main(String[] args)
    {
        ArrayList<ArrayList<Integer>> pretty = Solution.prettyPrint(3);
        
        for (ArrayList<Integer> list : pretty)
            System.out.println(list);
    }
}
