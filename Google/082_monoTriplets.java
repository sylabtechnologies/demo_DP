package goog30;
import java.util.*;

// https://leetcode.com/problems/increasing-triplet-subsequence/
// CHANGE TO 2 MONO FROM START/END
class Solution
{
    public boolean increasingTriplet(int[] nums)
    {
        int len = nums.length;
        if (len < 3) return false;
        
        LinkedList<Integer> monotQ = new LinkedList<>();
        monotQ.add(nums[0]);
        for (int i = 1; i < len; i++)
        {
            int n = nums[i];
            
            if (n > monotQ.getLast())
            {
                monotQ.add(n);
                if (monotQ.size() == 2)
                    for (int j = i + 1; j < nums.length; j++)
                    {
                        if (nums[j] > n) return true;
                    }
                    
                continue;
            }
            
            while (!monotQ.isEmpty() && n <= monotQ.getLast())
                monotQ.removeLast();
            
            monotQ.add(n);
        }

        return monotQ.size() > 2;
    }
}

public class Goog30
{
    public static void main(String[] args)
    {
        int arr[] = {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,10,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,100000000};
        System.out.println(new Solution().increasingTriplet(arr));
    }
}
