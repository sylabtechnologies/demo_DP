
package maxprofit;

import java.util.ArrayList;
import java.util.Collections;

public class MaxProfit
{

    public static void main(String[] args)
    {
        int[] arr = {3,2,6,5,0,3};
        
        System.out.println(maxProfit(arr));
    }
    
    /// loop and keep min price
    public static int maxProfit(int[] prices)
    {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        
        for (int price : prices)
        {
            maxProfit = Math.max(maxProfit, price - minPrice);
            minPrice = Math.min(minPrice, price);
        }
        
        return maxProfit;        
    }    
    
}

/*
    public static int maxProfit(int[] prices)
    {
        if (prices.length < 2) return 0;
        
        ArrayList<Decision> dd = new ArrayList<>();
        
        for (int i = 0; i < prices.length; i++)
        {
            Decision d = new Decision(i, prices[i]);
            dd.add(d);
        }
        
        Collections.sort(dd);
        
        for (int i = 0; i < dd.size(); i++)
        {
            System.out.println(dd.get(i));
        }
        
        
        int start = 0;
        int next =  dd.size() - 1;
        boolean found = false;

        while (!found & start < dd.size() - 1)
        {
            if (dd.get(start).day2buy < dd.get(next).day2buy)
                found = true;
            else
            {
                next--;

                if (start == next)
                {
                    start++;
                    next = dd.size() - 1;
                }
            }
        }
        
        if (found)
            return dd.get(next).price2buy - dd.get(start).price2buy;
        else
            return -1;
    }    

*/
