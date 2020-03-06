package findevdigs;

class Solution
{
    public static int findNumbers(int[] nums)
    {
        int count = 0;
        
        for (int i = 0; i < nums.length; i++)
        {
            int x = nums[i];
            int digs = 0;
            while (x > 0)
            {
                x = x / 10;
                digs ++;
            }
            
            if (digs % 2 == 0) count++;
            
        }
        
        return count;
    }
}

public class FindEvDigs
{

    public static void main(String[] args) {
        int[] nums = {555,901,482,1771};
        
        System.out.println(Solution.findNumbers(nums));
    }
}
