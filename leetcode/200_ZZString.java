package zzstring;
import java.util.*;

class Solution
{
    /// perDP do r&d cleanup
    static MultiMap<Character, Character> map;

    public static String sortString(String s)
    {
        map = new MultiMap<>();
        
        for (int i = 0; i < s.length(); i++)
        {
            Character c = s.charAt(i);
            map.put(c, c);
        }
        
        ArrayList<Character> keys = map.getKeys(true);
        StringBuilder sb = new StringBuilder();

        while (!keys.isEmpty())
        {
            sb.append(append12(keys));
            sb.append(append45(keys));
        }
        
        System.out.println(map);
        
        return sb.toString();
    }

    private static StringBuilder append12(ArrayList<Character> keys)
    {
        StringBuilder res = new StringBuilder();
               
        for (Character k : keys)
        {
            res.append(k);
            ArrayList<Character> row = map.getRow(k);
            row.remove(row.size() - 1);
        }
        
        clean(keys);
        
        return res;
    }

    private static StringBuilder append45(ArrayList<Character> keys)
    {
        StringBuilder res = new StringBuilder();
               
        for (int i = keys.size() - 1; i >= 0; i--)
        {
            Character k = keys.get(i);
            res.append(k);
            ArrayList<Character> row = map.getRow(k);
            row.remove(row.size() - 1);
        }
        
        clean(keys);
        
        return res;
    }

    private static void clean(ArrayList<Character> keys)
    {
        Iterator<Character> iter = keys.iterator();
        while (iter.hasNext())
        {
            Character k = iter.next();
            ArrayList<Character> row = map.getRow(k);
            if (row.isEmpty()) iter.remove();
        }
    }

}


public class ZZString
{

    public static void main(String[] args)
    {
        System.out.println(Solution.sortString("rat"));
    }
    
}
