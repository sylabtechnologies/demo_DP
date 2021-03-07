package goog75;
import java.util.*;

// https://leetcode.com/problems/longest-consecutive-sequence/
// #S - count sequencies in hashmap
class Solution 
{
    public int longestConsecutive(int[] nums) 
    {
        HashSet<Integer> nset = new HashSet<>();
        for (int num : nums) nset.add(num);
        
        ArrayList<Integer> streaks = new ArrayList<>();
        for (int n : nset) 
            if (!nset.contains(n-1)) streaks.add(n);
        
        int maxstreak = 0;
        for (int start : streaks) 
        {
            int streak = 0;
            for (int i = start; i < Integer.MAX_VALUE; i++) 
            {
                if (nset.contains(i))
                    streak++;
                else
                    break;
            }

            maxstreak = Math.max(streak, maxstreak);
        }
        
        return maxstreak;        
    }
}

public class Goog75
{
    public static void main(String[] args)
    {
        int nums[] = {100,4,200,1,3,2};
        System.out.println(new Solution().longestConsecutive(nums));
    }
}

