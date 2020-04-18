// https://leetcode.com/contest/biweekly-contest-24/problems/minimum-value-to-get-positive-step-by-step-sum/

package possteps;

class Solution
{
    public int minStartValue(int[] nums)
    {
        int start = 4;
        
        int sum = 200;
        int min = Integer.MAX_VALUE;
        for (int n : nums)
        {
            sum += n;
            System.out.println(sum);
            if (sum < min) min = sum;
        }

        int res = 201 - min;
        if (res <= 0) res = 1;
        return res;
    }
}

public class PosSteps
{
    public static void main(String[] args)
    {
        int arr[] = {-3,2,-3,4,2};
        System.out.println(new Solution().minStartValue(arr));
    }
    
}
