// https://leetcode.com/problems/two-sum

class Solution {
    public int[] twoSum(int[] nums, int target)
    {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] ans = {-1, -1};
        int zerocount = 0;
        
        for (int i = 0; i < nums.length; i++)
        {
            map.put(nums[i],i);
            if (target == 0)
            {
                if (nums[i] == 0)
                {
                    ans[zerocount] = i;
                    zerocount++;
                }
            }
        }
        if (zerocount == 2) return ans;

        for (int i = 0; i < nums.length; i++)
        {
            int delta = 0;
            delta = target - nums[i];
            
            if (map.containsKey(delta) && map.get(delta) != i)
            {
                ans[0] = i;
                ans[1] = map.get(delta);
                return ans;
            }
        }
        
        return null;
    }
}