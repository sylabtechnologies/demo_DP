package amazondevices;
import java.util.*;

public class Solution
{
    List<List<Integer>> optimalUtilization( final int deviceCapacity,
        List<List<Integer>> foregroundAppList,
        List<List<Integer>> backgroundAppList)
    {
        ArrayList<Item> foreList = new ArrayList<>();
        for (int i = 0; i < foregroundAppList.size(); i++)
        {
            Item it = new Item(foregroundAppList.get(i).get(1), foregroundAppList.get(i).get(0));
            foreList.add(it);
        }
        Collections.sort(foreList);
        
        List<Item> backList = new ArrayList<>();
        for (int i = 0; i < backgroundAppList.size(); i++)
        {
            Item it = new Item(backgroundAppList.get(i).get(1), backgroundAppList.get(i).get(0));
            backList.add(it);
        }
        Collections.sort(backList);
        
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int maxDelta = Integer.MAX_VALUE;

        for (int i = 0; i < foreList.size(); i++)
        {
            for (int j = 0; j < backList.size(); j++)
            {
                int occupied = foreList.get(i).value +  backList.get(j).value;
                int delta = deviceCapacity - occupied;
                if (delta < 0) break;

                if (delta < maxDelta)
                {
                    ans.clear();
                    ans.add(Arrays.asList(foreList.get(i).index, backList.get(j).index));
                    maxDelta = delta;
                }
                else if (delta == maxDelta)
                    ans.add(Arrays.asList(foreList.get(i).index, backList.get(j).index));
                
            }
        }
        
        return ans;
    }
    
    
    private class Item implements Comparable<Item>
    {
        int value;
        int index;

        public Item(int value, int index)
        {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Item o)
        {
            if (this.value == o.value) return 0;

            if (this.value > o.value) return 1;

            return -1;
        }
    }
    
}
