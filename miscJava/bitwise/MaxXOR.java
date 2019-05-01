package maxxor;
import java.util.*;
import static toolz.Util.skan;

public class MaxXOR
{

    private final static Scanner scan = skan();
    
    public static void main(String[] args)
    {
        int low = scan.nextInt();
        int high = scan.nextInt();
        
        int max = -1;
        for (int i = low; i < high; i++)
        {
            for (int j = low+1; j <= high; j++)
            {
                int prod = i ^ j;
                if (prod > max) max = prod;
            }
        }
        
        System.out.println(max);
        
    }
    
}
