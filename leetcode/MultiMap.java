/*
 * <int, int> multimap, use hash but provide ascending keys
 */
package weakrows;
import java.util.*;

public class MultiMap
{
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

    public void put(Integer key, Integer val)
    {
        ArrayList<Integer> row = map.get(key);

        if (row == null)
        {
            row = new ArrayList<>();
            map.put(key, row);
        }

        row.add(val);
    }

    public ArrayList<Integer> getRow(Integer key)
    {
        return map.get(key);
    }
    
    public ArrayList<Integer> getKeys()
    {
        ArrayList<Integer> ans = new ArrayList<>();
        
        for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet())
            ans.add(entry.getKey());
        
        Collections.sort(ans);
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
