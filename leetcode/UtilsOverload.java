/**
 * 
 */

package utils;
import java.util.ArrayList;

public class Utils
{
    /// overload int
    public static ArrayList<Integer> copy(int[] arr)
    {
        ArrayList<Integer> res = new ArrayList<>();
        for (Integer elem : arr)
            res.add(elem);
        return res;
    }

    public static <T> ArrayList<T> copy(T[] arr)
    {
        ArrayList<T> res = new ArrayList<>();
        for (T elem : arr)
            res.add(elem);
        return res;
    }
    
    public static void main(String[] args)
    {
        int[] test1 = {1, 2, 4 ,7 };
        System.out.println(Utils.copy(test1));

        String[] test2 = {"one", "four", "seven" };
        System.out.println(Utils.copy(test2));
    }
    
}
