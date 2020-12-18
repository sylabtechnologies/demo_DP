package goog30;
import java.util.*;

// https://leetcode.com/problems/4sum/
class Solution
{
    public List<List<Integer>> fourSum(int[] nums, int target)
    {
        Arrays.sort(nums);
        return dfs(nums, target, 0, 4);
    }

    private List<List<Integer>> dfs(int[] nums, int target, int start, int k)
    {
        List<List<Integer>> ret = new ArrayList<>();

        // nope
        if (start == nums.length)   return ret;
        if (nums[start]*k > target) return ret;
        if (target > nums[nums.length - 1]*k) return ret;
        
        // yep?
        if (k == 2) return twoSum(nums, target, start);
        
        for (int i = start; i < nums.length; i++)
        {
            if (i == start || nums[i-1] != nums[i])
            {
                for (List<Integer> set : dfs(nums, target - nums[i], i + 1, k - 1))
                {
                    ret.add(new ArrayList<>(Arrays.asList(nums[i])));
                    ret.get(ret.size() - 1).addAll(set);
                }
            }
        }

        return ret;
    }

    private List<List<Integer>> twoSum(int[] nums, int target, int start)
    {
        Set<Integer> set = new HashSet<>();
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = start; i < nums.length; i++)
        {
            int n = nums[i];
            int delta = target - n;
            
            if (ret.isEmpty() || ret.get(ret.size() - 1).get(1) != nums[i])
            {
                if (set.contains(delta))
                    ret.add(Arrays.asList(target - nums[i], nums[i]));
            }
                
            set.add(n);            
        }

        return ret;
    }
    
}

public class Goog30
{
    public static void main(String[] args)
    {
        int arr[] = {1,0,-1,0,-2,2};
        System.out.println(new Solution().fourSum(arr, 0));
    }
}
