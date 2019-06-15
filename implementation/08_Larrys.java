/**
 * https://www.hackerrank.com/challenges/larrys-array/problem
 * 
 * count even number of inversions
 * 
 */

package larrys;
import java.util.Arrays;

public class Larrys
{
    static String larrysArray(int[] arr)
    {
        int inversions = 0;
        for (int i = 0; i < arr.length; i++)
        {

            inversions += countInversions(arr, i);

        }

        // System.out.println("total: " + inversions);
        
        if (inversions % 2 == 0) 
            return "YES";
        else       
            return "NO";
    }

    private static int countInversions(int[] arr, int i)
    {
        int count = 0;
        
        for (int j = i + 1; j < arr.length; j++)
        {
            if (arr[i] > arr[j]) count++;
        }
        
        return count;
    }

    
    public static void main(String[] args)
    {
        // int[] arr = {1,6,5,2,4,3};
        
        int[] arr = {1, 3, 4, 2};
        
        System.out.println(larrysArray(arr));
    }
    
}

