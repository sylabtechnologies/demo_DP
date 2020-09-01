// https://leetcode.com/problems/sliding-window-maximum/

class Solution
{
    public int[] maxSlidingWindow(int[] nums, int k)
    {
        Deque<Integer> monotonic = new LinkedList<>();
        int i, res[] = new int[nums.length-k+1];
        
        for (i = 0; i < nums.length; i++)
        {
            while (!monotonic.isEmpty() && monotonic.peek() <= (i-k))
                monotonic.poll();
            
            while (!monotonic.isEmpty() && nums[monotonic.peekLast()] <= nums[i])
                monotonic.pollLast();
            
            monotonic.addLast(i);
            if ( i+1 >= k) res[i-k+1] = nums[monotonic.peek()];
        }
        
        return res;
    }
}

public class PosiProduct
{
    public static void main(String[] args)
    {
        int nums[] = {9,10,9,-7,-4,-8,2,-6};
        System.out.println(Arrays.toString(new Solution().maxSlidingWindow(nums, 5)));
    }
}
