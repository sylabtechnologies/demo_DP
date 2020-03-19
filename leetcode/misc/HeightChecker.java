// https://leetcode.com/problems/height-checker/

class Solution
{
    public int heightChecker(int[] heights)
    {
        int len = heights.length;
        int[] clone = Arrays.copyOf(heights, len);
        Arrays.sort(clone);
        
        int count = 0;
        for (int i = 0; i < len; i++)
        {
            if (heights[i] != clone[i]) count++;
        }

        return count;
    }
}
