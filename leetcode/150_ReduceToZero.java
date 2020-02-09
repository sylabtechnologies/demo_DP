package makezero;

class Solution
{
    public static int numberOfSteps (int num)
    {
        int count = 0;
        
        while (num > 1)
        {
            if (num % 2 == 0)
                count++;
            else
                count+= 2;

            num = num / 2;
        }

        return count + 1;
    }
}

public class MakeZero
{

    public static void main(String[] args)
    {
        System.out.println(Solution.numberOfSteps(8));
    }
    
}
