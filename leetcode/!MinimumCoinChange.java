package task1;
import java.util.*;

class Result
{
    /*
     * Complete the 'ChangeMaker' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. FLOAT price
     *  2. FLOAT_ARRAY payment
     */
    
    private static int coins[] = {1, 5, 10, 25};
    private static final int coinLen = coins.length;

    public List<Integer> ChangeMaker(float price, List<Float> payment)
    {
        int amount = 0;
        for (Float item : payment)
            amount += item*100;
        
        int p = (int) (price * 100);
        
        if (amount > p)
        {
            amount -= p;            
        }
        else
            amount = p;
        
        int dp[] = new int[amount + 1];
        int ans[][] = new int[amount + 1][];
        
        for (int i = 0; i <= amount; i++)
        {
            ans[i] = new int[coinLen];
            dp[i] = Integer.MAX_VALUE;
        }
        
        for (int i = 1; i <= amount; i++)
        {
            for (int j = 0; j < coinLen; j++)
            {
                int coin = coins[j];
                if (coin == i)
                {
                    dp[i] = 1;
                    
                    for (int k = 0; k < coinLen; k++)
                    {
                        ans[i][k] = (k == j)? 1 : 0;
                    }
                }
                else if (i > coin)
                {
                    if (dp[i - coin] == Integer.MAX_VALUE) continue;
                    
                    if (dp[i] > dp[i - coin] + 1)
                    {
                        dp[i] = dp[i - coin] + 1;
                        
                        for (int k = 0; k < coinLen; k++)
                            ans[i][k] = ans[i - coin][k];
                        
                        ans[i][j]++;
                    }
                }
            }
            
            // System.out.println(Arrays.toString(ans[i]));
        }
        
        
        LinkedList<Integer> res = new LinkedList<>();
        
        for (int cc : ans[amount])
            res.add(cc);
        
        return res;
    }

}
public class Task1
{

    public static void main(String[] args)
    {
        List<Float> pay = new ArrayList<>();
        pay.add(1.0f);
        pay.add(0.1f);
        pay.add(0.1f);
        
        System.out.println(new Result().ChangeMaker(0.99f, pay));

        pay.clear();
        pay.add(1.0f);
        pay.add(0.25f);
        pay.add(0.1f);
        
        System.out.println(new Result().ChangeMaker(0.8f, pay));
    }
    
}

