// https://leetcode.com/contest/biweekly-contest-28/problems/final-prices-with-a-special-discount-in-a-shop/

class Solution
{
    public int[] finalPrices(int[] prices)
    {
        int ans[] = Arrays.copyOf(prices, prices.length);
        
        for (int i = 0; i < prices.length; i++)
        {
            int disc = -1;
            for (int j = i + 1; j < prices.length; j++)
            {
                if (prices[i] >= prices[j])
                {
                    disc = prices[j];
                    break;
                }
            }
            
            if (disc >=0 )
            {
                ans[i] -= disc;
            }
        }
        
        return ans;
    }
}
