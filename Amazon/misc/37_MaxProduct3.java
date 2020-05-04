package maxproduct3;
import java.util.*;

class Solution
{
    public int maximumProduct(int[] nums)
    {
        Arrays.sort(nums);
        
        // combo all
        int beg = 0;
        int end = nums.length - 1;
        int len = 0;
        
        ArrayList<Integer> indices = new ArrayList<>();
        while (len < 3 && beg < end)
        {
            indices.add(beg); indices.add(end);
            len++; beg++; end--;
        }
        if (beg == end) indices.add(beg);
        System.out.println(indices);
        
        int max = Integer.MIN_VALUE;
        Subsets sub = new Subsets(indices);
        
        for (List<Integer> set : sub.listOfSubsets)
        {
            if (set.size() == 3)
            {
                System.out.println(set);

                int ans = 1;
                for (Integer i : set)
                {
                    ans *= nums[i];
                }
                if (ans > max) max = ans;
            }
        }

        return max;
    }
}

public class MaxProduct3
{
    public static void main(String[] args)
    {
        int test[] = {1, 2, 3, 4};
        System.out.println(new Solution().maximumProduct(test));  
    }
}

