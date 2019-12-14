package miscel;

import java.util.HashSet;

/*
https://leetcode.com/problems/first-missing-positive/
*/

class Solution
{
    public int firstMissingPositive(int[] nums)
    {
        int n = nums.length;
        if (n == 0) return 1;
        
        HashSet<Integer> map = new HashSet<>();
        int max = 0;
        for (int num  : nums)
        {
            if (max < num) max = num;
            map.add(num);
        }
        
        for (int i = 1; i <= max; i++)
            if (!map.contains(i)) return i;
        
        return max + 1;
    }    
    
}

public class Miscel
{

    public static void main(String[] args) {
        int[] test = {3,4,-1,1};
        Solution obj = new Solution();
        System.out.println(obj.firstMissingPositive(test));
    }
    
}
