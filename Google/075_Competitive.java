package goog27;
import java.util.*;

// https://leetcode.com/problems/find-the-most-competitive-subsequence/
// tle - move to indexing

class Solution
{
    /*
    private HashMap<Integer, Integer> myMins;
    
        myMins = new HashMap<>();

        int min = Integer.MAX_VALUE, mini = -1;
        for (int i = nums.length - 2; i >= 0; i--)
        {
            int num = nums[i];
            if (num < min)
            {
                min = num;
                mini = i;
            }
            
            myMins.put(i, mini);
        }
    
    */
    
    public int[] mostCompetitive(int[] nums, int k)
    {
        
        int ans[] = new int[k], curr = 0;
        
        int left = 0, right = nums.length;
        while (k > 0)
        {
            k--;
            
            int nxt[] = findMin(nums, left, right - k);
            ans[curr++] = nxt[0];
            left = nxt[1] + 1;

            if (k == 1)
            {
                ans[curr++] = findMin(nums, left, right)[0];
                break;
            }
            
            if (k == 1 || right - left == k)
            {
                while (curr != ans.length)
                    ans[curr++] = nums[left++];
                break;
            }
        }   
        
        return ans;
    }

    private int[] findMin(int[] nums, int left, int right)
    {
        int min = Integer.MAX_VALUE, mini = 0;
        for (int i = left; i < right; i++)
        {
            if (nums[i] < min)
            {
                min = nums[i];
                mini = i;
            }
        }
        
        return new int[]{min, mini};
    }
}

public class Goog27
{
    public static void main(String[] args)
    {
        int arr[] = {11,52,57,91,47,95,86,46,87,47,70,56,54,61,89,44,3,73,1,7,87,48,17,25,49,54,6,72,97,62,16,11,47,34,68,58,14,36,46,65,2,15};
        System.out.println(Arrays.toString(new Solution().mostCompetitive(arr, 18)));
    }
    
}
