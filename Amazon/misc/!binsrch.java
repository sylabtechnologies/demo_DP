package temp490;

class Solution
{
    public int search(int[] nums, int target)
    {
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right)
        {
            int mid = left + (right - left) / 2;
            
            int val = nums[mid];
            
            if (val < target)
                left = mid + 1;
            else if (val == target)
                return mid;
            else
                right = mid - 1;
        }

        return -1;
    }
}

public class Temp490
{
    public static void main(String[] args)
    {
        int arr[] = {-1,0,3,5,9,12};
        System.out.println(new Solution().search(arr, 9));
    }
    
}
