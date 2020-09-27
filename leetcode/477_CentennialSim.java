// https://leetcode.com/problems/maximum-profit-of-operating-a-centennial-wheel/
package wheelprofit;

class Solution
{
    /// sim:
    public int minOperationsMaxProfit(int[] cs, int ticket, int opCost)
    {
        int qSize = 0, profit = 0, maxProfit = Integer.MIN_VALUE, maxRun = 0;
        int runNo = 0;
        for (int i = 0; qSize > 0 || i < cs.length; i++)
        {
            if (i < cs.length) qSize += cs[i];
            int batch = Math.min(4, qSize);
            qSize -= batch;
            profit += batch*ticket - opCost;
            runNo++;
            if (profit > maxProfit)
            {
                maxProfit = profit;
                maxRun = runNo;
            }
        }

        return (maxProfit > 0) ? maxRun : -1;
    }
}

public class WheelProfit
{
    public static void main(String[] args)
    {
        int cust[] = {10,10,6,4,7};
        System.out.println(new Solution().minOperationsMaxProfit(cust, 3, 8));
    }
}
