// https://leetcode.com/problems/last-moment-before-all-ants-fall-out-of-a-plank/

package task4b;
import java.util.Arrays;

class Solution
{
    public int getLastMoment(int n, int[] left, int[] right)
    {
        int leftTime = 0;
        for (int i : left)
            leftTime = Math.max(i, leftTime);
        
        int rightTime = 0;
        for (int i : right)
            rightTime = Math.max(n - i, rightTime);
        
        return Math.max(leftTime, rightTime);
    }
}

public class Task4B
{
    public static void main(String[] args)
    {
        int left[] = {4, 3};
        int rght[] = {0, 1};
        
        System.out.println(new Solution().getLastMoment(4, left, rght));
        
    }
    
}
