package miscel;

/*
https://leetcode.com/problems/find-the-duplicate-number/
https://en.wikipedia.org/wiki/Arithmetic_progression
too much? count the sum for n/2 binsearch?
*/

class Solution
{
    public int findDuplicate(int[] nums)
    {
        int arithmSum = ((nums.length - 1)*nums.length)/2;
        return arraySum(nums) - arithmSum;
    }
    
    public int arraySum(int[] nums)
    {
        int sum = 0;
        
        for (int num : nums) sum += num;
        
        return sum;
    }
}

public class Miscel
{

    public static void main(String[] args) {
        int[] test = {3,1,3,4,2};
        Solution obj = new Solution();
        System.out.println(obj.findDuplicate(test));
    }
    
}
