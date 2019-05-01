package lonelyinteger;
import java.util.*;
import static toolz.Util.*;

public class LonelyInteger {

    private final static Scanner scan = skan();
    
    public static void main(String[] args)
    {
        int n = scan.nextInt();
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++)
        {
            arr[i] = scan.nextInt();
        }

        if (arr.length == 0) return;            
        int res = arr[0];
        
        for (int i = 1; i < n; i++)
        {
            res = res ^ arr[i];
        }
        
        System.out.println(res);
        
    }
    
}
