package task2;
import java.util.*;

// https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/

class Solution
{
    public int longestSubarray(int[] nums)
    {
        int len = nums.length;
        if (len < 2) return 0;
            
        ArrayList<Link> chain = new ArrayList<>();
        int curr = nums[0], curLen = 1;
        int max = 1;
        for (int i = 1; i < len; i++)
        {
            if (nums[i] != curr)
            {
                chain.add(new Link(curr, curLen));
                if (curr == 1)
                    max = Math.max(curLen, max);
                
                curr = nums[i];
                curLen = 1;
                
            }
            else
                curLen++;
        }
        
        chain.add(new Link(curr, curLen));
        if (curr == 1)
            max = Math.max(curLen, max);
        
        if (chain.size() == 1)
        {
            if (chain.get(0).val == 0)
                return 0;
            else
                return chain.get(0).len - 1;
        }
        
        System.out.println(chain);
        
        // slide window
        int cLen = chain.size();
        int start = 0;

        while (start < cLen)
        {
            if (chain.get(start).val == 1)
            {
                if (start + 2 < cLen)
                {
                    if (chain.get(start + 1).len == 1)
                        max = Math.max(max, chain.get(start).len + chain.get(start + 2).len );
                }
                    
            }
            
            start++;
        }
        
        return max;
    }

    private static class Link
    {
        int val;
        int len;

        public Link(int val, int len)
        {
            this.val = val;
            this.len = len;
        }

        @Override
        public String toString()
        {
            return "[" + val + " x " + len + "]";
        }
        
    }
}

public class Task2
{
    public static void main(String[] args)
    {
//        int arr[] = {1,1,0,0,1,1,1,0,1};
        int arr[] = {0,0,1,1};
        System.out.println(new Solution().longestSubarray(arr));
    }
    
}
