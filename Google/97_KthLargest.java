package goog47;
import java.util.*;

class Solution 
{
    public int findKthLargest(int[] nums, int k) 
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) 
            pq.add(nums[i]);
        
        for (int i = k; i < nums.length; i++) 
        {
            int n = nums[i];
            
            if (n >= pq.peek()) 
            {
                pq.poll();
                pq.add(n);
            }
        }

        return pq.poll();
    }
}

public class Goog47
{
    public static void main(String[] args)
    {
        int arr[] = {3,2,1,5,6,4}; 
        System.out.println(new Solution().findKthLargest(arr, 2));
    }
}

