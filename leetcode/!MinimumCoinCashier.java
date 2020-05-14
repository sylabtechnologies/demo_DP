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

    // https://www.cs.princeton.edu/courses/archive/spring07/cos423/lectures/greed-dp.pdf
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
        
        LinkedList<Integer> ans = new LinkedList<>();
        
        int i = 3;
        for (; i >= 0; i--)
        {
            int coin = coins[i];
            
            if (amount < coin)
            {
                ans.addFirst(0);
                continue;
            }
            
            int howm = amount / coin;
            if (amount % coin == 0)
            {
                ans.addFirst(howm);
                i--;
                break;
            }
            
            amount = amount - howm*coin;
            ans.addFirst(howm);
        }
        
        while (i >= 0)
        {
            ans.addFirst(0); i--;
        }
        
        return ans;
    }

}
public class Task1
{

    public static void main(String[] args)
    {
        List<Float> pay = new ArrayList<>();
        pay.add(3.89f);
        
        System.out.println(new Result().ChangeMaker(1.0f, pay));

        pay.clear();
        pay.add(1.0f);
        pay.add(0.25f);
        pay.add(0.1f);
        
        System.out.println(new Result().ChangeMaker(0.74f, pay));
    }
    
}

/*
        List<Float> pay = new ArrayList<>();
        pay.add(1.0f);
        pay.add(0.25f);
        pay.add(0.1f);
        
        System.out.println(new Result().ChangeMaker(0.8f, pay));
*/