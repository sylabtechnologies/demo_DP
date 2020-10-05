// https://leetcode.com/problems/fruit-into-baskets/
package goog7;
import java.util.*;

class Solution
{
    public int totalFruit(int[] tree)
    {
        final int ll = tree.length;
        if (ll < 3) return ll;
        
        TreeMap<Integer, Integer> type = new TreeMap<>();
        type.put(tree[0], 1);

        int max = 1, count = 1, start = 0;
        for (int i = 1; i < ll; i++)
        {
            int nxt = tree[i];
            
            if (type.containsKey(nxt))
            {
                int fr = type.get(nxt);
                type.put(nxt, fr + 1);
                count++;
            }
            else if (type.size() == 1)
            {
                type.put(nxt, 1);
                count++;
            }
            else
            {
                boolean go = true;
                while (go && start < i)
                {
                    int key = tree[start];
                    int fr = type.get(tree[start++]);
                    count--;
                    
                    if (fr == 1)
                    {
                        type.remove(key);
                        go = false;
                        continue;
                    }
                    else
                        type.put(key, fr - 1);
                }
                
                type.put(nxt, 1);
                count++;
            }
            
            if (max < count) max = count;
        }

        return max;
    }
}

public class Goog7
{
    public static void main(String[] args)
    {
        int arr[] = {3,3,3,1,2,1,1,2,3,3,4};
        System.out.println(new Solution().totalFruit(arr));
    }
}
