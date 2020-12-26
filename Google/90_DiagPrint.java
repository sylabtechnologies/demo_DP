package goog37;
import java.util.*;

public class Goog37
{
    public static void main(String[] args)
    {
        int arr[][] = {{1,2,3}, {4,5,6}, {7,8,9}};
        System.out.println(Arrays.toString(new Solution().findDiagonalOrder(arr)));
    }
}


class Solution
{
    public int[] findDiagonalOrder(int[][] mat)
    {
        if (mat.length == 0) return new int[0];
        
        MultiMap<Integer, Integer> map = new MultiMap<>();
        for (int i = 0; i < mat.length; i++)
        {
            int[] row = mat[i];
            for (int j = 0; j < row.length; j++)
            {
                int key = i + j;
                map.put(key, row[j]);
            }
            
        }
        
        int ret[] = new int[mat.length*mat[0].length];
        int cnt = 0;
        ArrayList<Integer> keys = map.getKeys(true);
        for (Integer key : keys)
        {
            ArrayList<Integer> row = map.getRow(key);

            if (key % 2 == 1)
                for (int i = 0; i < row.size(); i++)
                    ret[cnt++] = row.get(i);
            else
                for (int i = row.size() - 1; i >= 0; i--)
                    ret[cnt++] = row.get(i);
        }
        
        return ret;
    }
}


class MultiMap<K extends Comparable<K>, V>
{
    private HashMap<K, ArrayList<V> > map = new HashMap<>();
    private ArrayList<K> keys = new ArrayList<>();

    public void put(K key, V val)
    {
        ArrayList<V> row = map.get(key);

        if (row == null)
        {
            row = new ArrayList<>();
            map.put(key, row);
            keys.add(key);
        }

        row.add(val);
    }

    public ArrayList<V> getRow(K key)
    {
        return map.get(key);
    }
    
    public ArrayList<K> getKeys(boolean sorted)
    {
        ArrayList<K> ans = new ArrayList<>();
        ans.addAll(keys);

        if (sorted) Collections.sort(ans);
        return ans;
    }

    public static int[] listToInt(List<Integer> lst)
    {
        int[] ans = new int[lst.size()];
        
        for (int i = 0; i < lst.size(); i++)
            ans[i] = lst.get(i);
        
        return ans;
    }
    
    @Override
    public String toString()
    {
        return map.toString();
    }
}
