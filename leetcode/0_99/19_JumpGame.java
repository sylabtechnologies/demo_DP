package jumpgame;

class Solution
{
    // find which point can reach
    public boolean canJump(int[] nums)
    {
        if (nums.length <= 1) return true;
        
        int last = nums.length - 1;
        for (int i = last - 1; i >= 0; i--)
        {
            if (i + nums[i] >= last)
                last = i;                
        }

        return last == 0;
    }
}

public class JumpGame
{

    public static void main(String[] args)
    {
        int[] nums = {2,3,1,1,4};
        Solution obj = new Solution();
        System.out.println(obj.canJump(nums));
    }
    
}
