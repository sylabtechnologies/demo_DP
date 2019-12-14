package mostwater;

public class Solution
{
    // https://leetcode.com/problems/container-with-most-water/submissions/
    // greedy:
    public int maxArea(int[] height)
    {
        if (height.length < 2) return 0;

        int left = 0;
        int right = height.length - 1;
        int max = 0;
        
        while (left < right)
        {
            int area = Math.min(height[left], height[right]) * ( right - left);
            if (area > max) max = area;
            
            if (height[left] > height[right])
                right--;
            else
                left++;
        }

        return max;
    }
    
}
