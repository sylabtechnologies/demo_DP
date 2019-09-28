// https://leetcode.com/problems/time-based-key-value-store/

package timemaptest;
import java.util.*;

class TimeMap
{
    HashMap<String, TreeMap<Integer, String>> map;

    public TimeMap()
    {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp)
    {
        if (map.containsKey(key))
        {
            TreeMap<Integer, String> val = map.get(key);
            val.put(timestamp, value);
        }
        else
        {
            TreeMap<Integer, String> newVal = new TreeMap<>();
            newVal.put(timestamp, value);
            map.put(key, newVal);
        }
    }
    
    public String get(String key, int timestamp)
    {
        if (!map.containsKey(key)) return new String();
        
        TreeMap<Integer, String> val = map.get(key);
        
        Map.Entry<Integer, String> ans = val.floorEntry(timestamp);
        if (ans == null)
            return new String();
        else
            return ans.getValue();
    }
}



public class TimeMapTest
{

    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
