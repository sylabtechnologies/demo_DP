
package maxsubarray;

import java.util.Arrays;

public class MaxSubarray
{
    // DP from one element to max
    private static int[] maxSubarray(int[] arr)
    {
        int[] DPsub = new int[arr.length];
        int maxSubarr = Integer.MIN_VALUE;
        int[] DPseq = new int[arr.length];
        
        // DP[0] = one element
        for (int i = 0; i < arr.length; i++)
        {
            DPsub[i] = arr[i];
            DPseq[i] = arr[i];
            if (maxSubarr < DPsub[i]) maxSubarr = arr[i];
        }

        for (int i = 1; i < DPsub.length; i++)
        {
            for (int j = DPsub.length - 1; j >= i; j--)
            {
                DPsub[j] = DPsub[j-1] + arr[j];
                if (maxSubarr < DPsub[j]) maxSubarr = DPsub[j];
            }

            int[] DPnext = new int[DPsub.length];
            for (int j = i; j <  DPsub.length; j++)
            {
                DPnext[j] = Math.max(Math.max(DPseq[j-1], DPseq[j]), DPseq[j-1] + arr[j]);
            }
            for (int j = i; j <  DPsub.length; j++)
            {
                DPseq[j] = DPnext[j];
            }
            
        }

        int[] ans = {0, 0};
        ans[0] = maxSubarr;
        ans[1] = DPseq[DPseq.length - 1];
        return ans;

    }

    public static void main(String[] args)
    {
        int [] test = {-2, -3, -1, -4, -6};
//        int [] test = {1, 2, 3, 4};
//        int [] test = {2, -1, 2, 3, 4, -5};

        System.out.println(Arrays.toString(maxSubarray(test)));
        
    }
    
}
