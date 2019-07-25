/*
 * find a; pairs that utilize max memory & O(n*m)
 *
 */

package amazondevices;
import java.util.*;

public class AmazonDevices
{

    public static void main(String[] args)
    {
        Solution obj = new Solution();
        
        /*
        Integer[][] foreData = {{1,2},{2,4},{3,6}};
        List<List<Integer>> foreground = new ArrayList<List<Integer>>();
        for (Integer[] row : foreData)
            foreground.add(Arrays.asList(row));

        Integer[][] backData = {{1,2}};
        List<List<Integer>> background = new ArrayList<List<Integer>>();
        for (Integer[] row : backData)
            background.add(Arrays.asList(row));
        
        System.out.println(obj.optimalUtilization(7, foreground, background));
        */

        Integer[][] foreData = {{1, 3}, {2, 5}, {3, 7}, {4, 10}};
        List<List<Integer>> foreground = new ArrayList<List<Integer>>();
        for (Integer[] row : foreData)
            foreground.add(Arrays.asList(row));
        
        Integer[][] backData = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        List<List<Integer>> background = new ArrayList<List<Integer>>();
        for (Integer[] row : backData)
            background.add(Arrays.asList(row));
        
        System.out.println(obj.optimalUtilization(10, foreground, background));
        
    }
    
}
