// https://leetcode.com/contest/weekly-contest-185/problems/display-table-of-food-orders-in-a-restaurant/

package foodorders;
import java.util.*;

class Solution
{
    public List<List<String>> displayTable(List<List<String>> orders)
    {
        MultiMap<Integer, String> tables = new MultiMap<>();
        TreeSet<String> dishes = new TreeSet<>();
        
        for (List<String> order : orders)
        {
            Integer table = Integer.parseInt(order.get(1));
            tables.put(table, order.get(2));
            dishes.add(order.get(2));
        }
        
        ArrayList<Integer> tkeys = tables.getKeys(true);
        List<List<String>> result = new ArrayList<>();
        
        ArrayList<String> hdr = new ArrayList<>();
        hdr.add("Table"); hdr.addAll(dishes);
        result.add(hdr);

        HashMap<String, Integer> index = new HashMap<>();
        int inx = 0;
        for (String dish : dishes)
            index.put(dish,inx++);
        
        int len = dishes.size();
        for (Integer tkey : tkeys)
        {
            ArrayList<String> row = new ArrayList<>();
            row.add(tkey.toString());
            
            ArrayList<String> tableRow = tables.getRow(tkey);
            
            HashMap<Integer, Integer> count = new HashMap<>();
            for (String dd : tableRow)
            {
                int in = index.get(dd);
                int cnt = count.getOrDefault(in, 0);
                count.put(in, cnt + 1);
            }
            
            for (String dish : dishes)
            {
                int in = index.get(dish);
                Integer cnt = count.getOrDefault(in, 0);
                row.add(cnt.toString());
            }

            result.add(row);
        }
        
        return result;
    }
}

public class FoodOrders
{
    public static void main(String[] args)
    {
        String ord[][] = {{"David","3","Ceviche"},{"Corina","10","Beef Burrito"},
        {"David","3","Fried Chicken"},{"Carla","5","Water"},{"Carla","5","Ceviche"},{"Rous","3","Ceviche"}};
        
        List<List<String>> orders = new ArrayList<>();
        for (String[] arr : ord)
            orders.add(Arrays.asList(arr));
        
        System.out.println(new Solution().displayTable(orders));
        
    }
}
