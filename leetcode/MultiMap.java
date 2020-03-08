package calendar;
import java.util.*;

public class MultiMap<K extends Comparable<K>, V>
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