package squareroot;

class Solution
{
    public int sqrt(int num)
    {
        if (num == 1) return 1;
        
        int low = 1, high = num, ans = 0;
        while (low <= high)
        {
            int mid = low + (high - low) / 2;
            int flr = num / mid;    // get floor
            
            if (mid <= flr)
            {
                low = mid + 1;
                ans = mid;
            }
            else
                high = mid - 1;
        }
        
        return ans;
    }
}


public class SquareRoot
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().sqrt(11)); 
    }
    
}
