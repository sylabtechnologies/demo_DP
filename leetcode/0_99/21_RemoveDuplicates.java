package removeduplicates;

import java.util.*;

public class RemoveDuplicates
{
    public static final int MAXIMUM_DUPLICATES = 2;

    public static void main(String[] args)
    {
        // int[] arr = {0,0,1,1,1,1,2,3,3};
        int[] arr = {1,1,1,2,2,3};
        
        int len = removeDuplicates(arr);
        printArr(arr, len);
    }

    private static int removeDuplicates(int[] arr)
    {
        if (arr.length <= 2) return arr.length;
        
        int curr = 0, copy = 0;
        int currDups = 1, count = 1;
        while (curr < arr.length)
        {
            arr[copy] = arr[curr];
            
            if (curr < arr.length - 1)
            {
                if (arr[curr] == arr[curr + 1])
                    currDups++;
                else
                    currDups = 1;

                if (currDups <= MAXIMUM_DUPLICATES)
                {
                    copy++; count++;
                }
            }
            
            curr++;
        }
        
        return count;
    }

    private static void printArr(int[] arr, int len)
    {
        for (int i = 0; i < len; i++)
            System.out.print(arr[i] + " ");
        
        System.out.println("");
    }
    
}

/*
            if (arr[curr] == arr[next])
            {
                currDups++;
            }
            else
            {
                currDups = 1;
                curr = next;
            }
            
            next++;

*/