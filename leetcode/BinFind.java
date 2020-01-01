/**
 * You’re given an array of objects sorted in ascending order; any object at index “i” can be lazily deleted by setting the
 * value to some special value like “null” at index “i” (something like vec[i] = nullptr).
 * Given a value, implement a function that returns the index of the element
 * in the array or -1 if not found.
 */

package binfind;

public class BinFind
{
    public static final int NULLVAL = -1;

    // binsearch
    public static int find(int key, int[] arr)
    {
        int lo = 0;
        int hi = arr.length;
        
        if (hi == 0) return NULLVAL;
        if (hi == 1) return arr[0] == key ? 1 : NULLVAL;
        
        while (lo < hi)
        {
            int mid = closest(arr, hi, lo);

            if (mid == NULLVAL) return NULLVAL;

            if (arr[mid] == key)
                return mid;
            else if (arr[mid] > key)
                hi = mid - 1;
            else 
                lo = mid + 1;
        }
        
        return (arr[lo] == key )? lo : NULLVAL;
    }

    private static int closest(int[] arr, int hi, int lo)
    {
        int mid = (hi + lo) / 2;
        
        if (arr[mid] != NULLVAL) return mid;
        
        int delta = 1;  // try random 1-2-3 jumps ?
        boolean goLeft = true, goRight = true;
        
        while (goLeft || goRight)
        {
            if (mid + delta <= hi)
            {
                if (arr[mid + delta] != NULLVAL) return mid + delta;
            }
            else goRight = false;
            
            if (mid - delta >= lo)
            {
                if (arr[mid - delta] != NULLVAL) return mid - delta;
            }
            else goRight = false;

            delta ++;
        }

        return NULLVAL;
    }

    
    public static void main(String[] args)
    {
        System.out.println( find (5, new int[]{2, -1, -1, 5, -1, 6, 7, 8}));
    }

}
