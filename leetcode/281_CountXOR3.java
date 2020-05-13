// memoize https://leetcode.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/
package count3;
import java.util.Arrays;

class Solution
{
    int memo[][];
            
    public int countTriplets(int[] arr)
    {
        int len = arr.length;
        memo= new int[len][];
        
        for (int i = 0; i < len; i++)
        {
            int row[] = new int[len];
            Arrays.fill(row, -1);
            memo[i] = row;            
        }
        
        int count = 0;
        for (int i = 0; i < len; i++)
        {
            for (int j = i + 1; j < len; j++)
            {
                for (int k = j; k < len; k++)
                {
                    int  a  = getIt(arr, i, j - 1);
                    int  b = getIt(arr, j, k);

                    if (a == b) count++;
                }
            }
        }
        
        return count;
    }

    private int getIt(int[] arr, int a, int b)
    {
        if (memo[a][b] >= 0) return memo[a][b];

        int res = arr[a];
        if (b > a)
        {
            if (memo[a][b - 1] >= 0)
            {
                res = memo[a][b - 1] ^ arr[b];
            }
            else
            {
                for (int i = a + 1; i <= b; i++)
                    res ^= arr[i];
            }
        }
        
        memo[a][b] = res;
        return res;
    }
}

public class Count3
{
    public static void main(String[] args)
    {
//        int arr[] = {2,3,1,6,7};
//        System.out.println(new Solution().countTriplets(arr));

        int arr2[] =  {7,11,12,9,5,2,7,17,22};
        System.out.println(new Solution().countTriplets(arr2));
    }
    
}
