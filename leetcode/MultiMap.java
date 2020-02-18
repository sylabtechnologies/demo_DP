/*
 * <int, int> multimap, use hash, give ascending keys on request
 */

package weakrows;
import java.util.*;

public class MultiMap
{
    private HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    private ArrayList<Integer> keys = new ArrayList<>();

    public void put(Integer key, Integer val)
    {
        ArrayList<Integer> row = map.get(key);

        if (row == null)
        {
            row = new ArrayList<>();
            map.put(key, row);
            keys.add(key);
        }

        row.add(val);
    }

    public ArrayList<Integer> getRow(Integer key)
    {
        return map.get(key);
    }
    
    public ArrayList<Integer> getKeys(boolean sorted)
    {
        ArrayList<Integer> ans = new ArrayList<>();
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
    
}
