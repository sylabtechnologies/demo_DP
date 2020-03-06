package subarrayssizek;

class Solution
{
    public static int numOfSubarrays(int[] arr, int k, int threshold)
    {
        int aggr = k*threshold;
        
        int currSum = 0;
        for (int i = 0; i < k; i++)
            currSum += arr[i];
        
        int ans = 0;
        if (currSum >= aggr) ans++;

        for (int i = k; i < arr.length; i++)
        {
            currSum = currSum - arr[i-k] + arr[i];
            if (currSum >= aggr) ans++;
        }

        return ans;
    }
}


public class SubarraysSizeK
{

    public static void main(String[] args)
    {
        int[] arr = {11,13,17,23,29,31,7,5,2,3};
        
        System.out.println(Solution.numOfSubarrays(arr, 3, 5));
    }
    
}
