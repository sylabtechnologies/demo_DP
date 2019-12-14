// https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/
// binsearch:

package finddivisor;
import java.util.HashMap;

public class Solution
{
    private static HashMap<Integer, Integer> memo = new HashMap<>();
    
    public static int smallestDivisor(int[] nums, int threshold)
    {
//        printArray(nums);
        
        if (nums.length == 1)
            return (int) Math.ceil( ((double) nums[0]) / threshold );
        
        int lo = 1;
        int loSum = getSum(nums, 1);
        if (loSum <= threshold) return 1;
        
        int hi = getMax(nums);
        int hiSum = nums.length;
        
//        for (int i = lo; i <=hi; i++)
//            printDivided(nums, i);

        while (lo < hi)
        {
            int mid = (lo + hi)/2;
            int midSum = getSum(nums, mid);

            if (midSum  <= threshold)
                hi = mid;
            else
                lo = mid + 1;
        }

        return lo;
    }

    private static int getSum(int[] nums, int divisor)
    {
        if (memo.containsKey(divisor))
            return memo.get(divisor);
        
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
        {
            double d = nums[i];
            int res = (int) Math.ceil(d/divisor);
            sum += res;
        }
        
        memo.put(divisor, sum);
        
        return sum;
    }

    private static int getMax(int[] nums)
    {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] > max)
                max = nums[i];
        }
        
        return max;
    }
    
    private static void printDivided(int[] nums, int divisor)
    {
        System.out.println("divisor " + divisor);

        int sum = 0;
        for (int i = 0; i < nums.length; i++)
        {
            double d = nums[i];
            int res = (int) Math.ceil(d/divisor);
            sum += res;
            System.out.print(res + " ");
        }
        System.out.println("; sum = " + sum + "\n");
    }

    public static void printArray(int[] nums)
    {
        for (int i = 0; i < nums.length; i++)
        {
            System.out.print(nums[i] + " ");
        }
        System.out.println(";");
    }    
   
}
