package nonduplicate;
/// #AMA# cant be binsearch

class Solution
{
    public int singleNonDuplicate(int[] nums)
    {
        if (nums.length == 1) return nums[0];

        int prev = nums[0];
        int prevCount = 1;
        
        for (int i = 1; i < nums.length; i++)
        {
            if (nums[i] == prev)
                prevCount++;
            else
            {
                if (prevCount == 1) return prev;
                prev = nums[i];
                prevCount = 1;
            }
        }
        
        return prev;
    }
}

public class NonDuplicate
{
    public static void main(String[] args)
    {
        int arr[] = {1,1,2,3,3,4,4,8,8};
        
        Solution s = new Solution();
        System.out.println(s.singleNonDuplicate(arr));
    }
    
}
