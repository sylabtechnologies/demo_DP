package miscel;

// https://leetcode.com/problems/missing-number/submissions/
// https://en.wikipedia.org/wiki/Arithmetic_progression
class Solution
{
    public int missingNumber(int[] nums)
    {
        int sum = ((nums.length + 1)*nums.length)/2;
        for (int num : nums)
            sum -= num;
        return sum;
    }
}

