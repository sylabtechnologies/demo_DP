package amazonpackages;
import java.util.*;

public class Solution
{
    private final static int RESERVE = 30;
    
    public ArrayList<Integer> IDsOfPackages(int truck, ArrayList<Integer> packages)
    {
        ArrayList<Item> tester = new ArrayList<>();
        for (int i = 0; i < packages.size(); i++)
        {
            Item it = new Item(packages.get(i), i);
            tester.add(it);
        }
        Collections.sort(tester);
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int limit  = truck - RESERVE;
        int maxDelta = Integer.MAX_VALUE;

        for (int i = 0; i < tester.size(); i++)
        {
            for (int j = i + 1; j < tester.size(); j++)
            {
                int occupied = tester.get(i).value +  tester.get(j).value;
                int delta = limit - occupied;
                if (delta < 0) break;
                    
                if (delta < maxDelta)
                {
                    ans.clear();
                    ans.add(tester.get(i).index);
                    ans.add(tester.get(j).index);
                    maxDelta = delta;
                }
                else if (delta == maxDelta)
                {
                    if (Math.max(tester.get(i).value, tester.get(j).value)
                        > Math.max(ans.get(0), ans.get(1)))
                    {
                        ans.clear();
                        ans.add(tester.get(i).index);
                        ans.add(tester.get(j).index);
                    }
                }
            }
        }
        
        if (ans.isEmpty()) ans.add(-1);
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
