/**
 * https://www.hackerrank.com/challenges/almost-sorted/problem
 * 
 * reverse engineer by comparing to sorted array
 * 
 */

package almostsorted;

import java.util.Arrays;

public class AlmostSorted
{
    static void almostSorted(int[] arr)
    {
        int[] copy = arr.clone();
        Arrays.sort(copy);
        
        if (Arrays.equals(arr, copy)) answer("yes");
        
        // find leftmost inequality
        int leftIndex = 0;
        while (leftIndex < arr.length)
        {
            if (arr[leftIndex] != copy[leftIndex]) break;
            leftIndex++;
        }
        
        // find rightmost inequality
        int rightIndex = arr.length - 1;
        while (rightIndex >= 0)
        {
            if (arr[rightIndex] != copy[rightIndex]) break;
            rightIndex--;
        }
        
        // try to swap
        performSwap(arr, leftIndex, rightIndex);
        if (Arrays.equals(arr, copy)) answer("yes", "swap", leftIndex + 1, rightIndex + 1);
        
        // we reversed 2 & we try the rest
        int i = leftIndex + 1;
        int j = rightIndex - 1;
        
        while (i < j)
        {
            performSwap(arr, i, j);
            i++; j--;
        }
        
        if (Arrays.equals(arr, copy)) answer("yes", "reverse", leftIndex + 1, rightIndex + 1);
        
        answer("no");
            
    }

    private static void performSwap(int[] arr, int ind1, int ind2)
    {
        int temp = arr[ind2];
        arr[ind2] = arr[ind1];
        arr[ind1] = temp;
    }
    
    
    private static void answer(String ans)
    {
        System.out.println(ans);
        System.exit(0);
    }

    private static void answer(String ans, String method, int leftIndex, int rightIndex)
    {
        System.out.println(ans);
        System.out.println(method + " " + leftIndex  + " " + rightIndex);
        System.exit(0);
    }
    
    
    public static void main(String[] args)
    {
        int[] arr = {1, 5, 4, 3, 2, 6};
        almostSorted(arr);
    }

    
}
