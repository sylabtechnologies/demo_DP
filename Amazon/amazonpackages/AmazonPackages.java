/*
 * #1 O (n*n) is most likely
 *
 */
package amazonpackages;
import java.util.ArrayList;
import java.util.Arrays;

public class AmazonPackages
{
    public static void main(String[] args)
    {
        Solution obj = new Solution();
        ArrayList<Integer> test = new ArrayList<>(Arrays.asList(1, 10, 25, 35, 60));
        System.out.println(obj.IDsOfPackages(90, test));
        
    }
    
}
