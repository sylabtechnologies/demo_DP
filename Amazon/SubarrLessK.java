package subarrlessk;
import java.util.*;

// R/D a1bemar1e
class Solution
{
    private int refer[], dp[];
    
    public int numSubarrayProductLessThanK(int[] nums, int k)
    {
        if (nums.length == 0 && k < 2) return 0;
        
        refer = nums; dp = new int[nums.length];
        ArrayList<Section> all = new ArrayList<>();
        Section curr = new Section(0);
        
        for (int i = 1; i < nums.length; i++)
        {
            if (curr.onlyOnes != (nums[i] == 1))
            {
                all.add(curr); curr = new Section(i);
            }
            else
                curr.end++;
        }
        all.add(curr);
        
        int ans = 0;
        
        for (int i = 0; i < all.size(); i++)
        {
            Section sec  = all.get(i);
            
            if (!sec.onlyOnes)
                ans += getDP(sec, k);
            else
            {
                int seclen = sec.end - sec.start;
                ans += factorial(seclen);
                
                // go left
                if (i != 0)
                {
                    System.out.println(Arrays.toString(dp));
                    Section prev = all.get(i - 1);
                    
                    for (int j = prev.end - 1; j >= prev.start; j--)
                    {
                        int dist = sec.start - j;
                        if (dp[j] < dist) break;
                        ans += factorial(dp[j] - dist + 1);
                    }
                                        
//                    System.out.println(all.get(i - 1));
                }

                // go right
                if (i != all.size() - 1)
                {
                    System.out.println(all.get(i + 1));
                }
                
            }
        }
        
        return ans;
    }

    private int getDP(Section sec, final int k)
    {
        for (int i = sec.start; i < sec.end; i++)
        {
            if (refer[i] < k)
                dp[i] = 1;
            else continue;
            
            int start = i, next = start + 1, prod = refer[start];
            while (next < sec.end)
            {
                prod *= refer[next++];
                if (prod < k)
                    dp[i] += 1;
                else
                    break;
            }
        }

        int sum = 0;
        for (int n : dp) sum += n;
        return sum;
    }

    private int factorial(int n)
    {
        if (n == 1) return 1;
        return n * factorial(n - 1);
    }
    
    private class Section
    {
        boolean onlyOnes;
        int start, end;

        private Section(int index)
        {
            start = index; end = start + 1;
            onlyOnes = (refer[index] == 1);
        }

        @Override
        public String toString() { return "[" + start + ", " + end + ")";}
    }
}

public class SubarrLessK
{
    public static void main(String[] args)
    {
        // int arr[] = {10, 5, 2, 6};
//        int arr[] = {1, 1, 1};
        
        int arr[] = {6,8,6,6,10,8,10,3,7,7,4,9,3,1};
        System.out.println(new Solution().numSubarrayProductLessThanK(arr, 121));
        
        int arr2[] = {3,10,10,7,6,3,10,1,4,10,8,10};
        System.out.println(new Solution().numSubarrayProductLessThanK(arr2, 260));
        
    }
    
}
