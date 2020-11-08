package goog20;
import java.util.*;

// https://leetcode.com/problems/sell-diminishing-valued-colored-balls/ 
// - greedy from the top
class Solution
{
    private static int MYMOD = 1_000_000_007;
    
    public int maxProfit(int[] inventory, int orders)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int x : inventory) pq.add(x);
        
        long profit = 0, stock = 1, mesa = pq.poll();
        while (!pq.isEmpty())
        {
            if (mesa > pq.peek())
            {
                int step = (int) (mesa - pq.peek());
                
                int level = (int) (orders / stock);
                if (level <= step) break;
                
                profit += stock*mathProgress(mesa, step);
                orders -= stock*step;
                mesa -= step;
            }
            else
            {
                stock++;
                pq.poll();
            }
        }
        
        int level = (int) (orders / stock);
        long remain = orders % stock;
        profit += stock*mathProgress(mesa, level);
        profit += remain*(mesa - level);
        return (int) (profit % MYMOD);
    }

    private long mathProgress(long start, int orders)
    {
        if (orders == 0) return 0;
        
        long b = start;
        long a = b - orders + 1;
        long sum = orders*(a+b) / 2;
        return sum;
    }
}

public class Goog20
{
    public static void main(String[] args)
    {
        int arr2[] = {497_978_859,167_261_111,483_575_207,591_815_159};
        System.out.println(new Solution().maxProfit(arr2, 836556809));
    }
}
