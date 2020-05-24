// https://leetcode.com/problems/destination-city/

package destcity;
import java.util.*;

class Solution
{
    public String destCity(List<List<String>> paths)
    {
        MultiMap<String, String> destMap = new MultiMap<>();
        TreeSet<String> destCty = new TreeSet<>();
        
        for (List<String> p : paths)
        {
            String src = p.get(0);
            String dst = p.get(1);
            destMap.put(src, dst);
            destCty.add(dst);
        }
        
        for (String ci : destCty)
        {
            ArrayList<String> test = destMap.getRow(ci);
            if (test == null) return ci;
        }
        
        return null;
    }
}

public class DestCity
{
    public static void main(String[] args)
    {
        List<List<String>> pp = new ArrayList<>();
        pp.add(Arrays.asList("L", "NY"));
        pp.add(Arrays.asList("NY", "M"));
        pp.add(Arrays.asList("M", "SP"));
        
        System.out.println(new Solution().destCity(pp));
    }
    
}
