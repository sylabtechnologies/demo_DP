/// a1/review/s/hotels https://www.interviewbit.com/problems/hotel-reviews/
package reviews;
import java.util.*;

class Solution
{
    public ArrayList<Integer> solve(String A, ArrayList<String> B)
    {
        String good[] = A.split("_");
        HashSet<String> goodness = new HashSet<>(Arrays.asList(good));
        
        MultiMap<Integer, Integer> mapAll = new MultiMap<>();
        for (int i = 0; i < B.size(); i++)
        {
            String str = B.get(i);
            int rank = 0;
            for (String val : str.split("_"))
            {
                if (goodness.contains(val))
                    rank++;
            }
            
            mapAll.put(rank, i);
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<Integer> rows = mapAll.getKeys(true);
        for (int i = rows.size() - 1; i >= 0; i--)
        {
            Integer rank = rows.get(i);
            ArrayList<Integer> row = mapAll.getRow(rank);
            ans.addAll(row);
        }
        
        return ans;
    }
}

public class Reviews
{
    public static void main(String[] args)
    {
        ArrayList<String> revs =
            new ArrayList<>(Arrays.asList("water_is_cool", "cold_ice_drink", "cool_wifi_speed"));
        
        System.out.println(new Solution().solve("cool_ice_wifi", revs));
    }
}
