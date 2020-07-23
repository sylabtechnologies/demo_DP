package diffk2;
import java.util.*;

class Solution
{
    public int findPairs(int[] nums, int diff)
    {
        if (diff < 0) return 0;
        
        Map<Integer, Integer> map = new TreeMap<>();
        if (diff == 0)
        {
            for (int i = 0; i < nums.length; i++)
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            
            int len = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet())
            {
                Integer value = entry.getValue();
                if (value > 1) len++;
            }
            
            return len;
        }        
        
        Arrays.sort(nums);
//        System.out.println(Arrays.toString(nums));
        
        int len = 0;
        int i = 0, j = i + 1;
        while (j < nums.length)
        {
            if (nums[i] == nums[j])
            {
                i++; j++;
            }
            else if (nums[i] < nums[j] - diff)
            {
                i++;
                if (i == j) j++;
            }
            else if (nums[i] > nums[j] - diff)
            {
                j++;
            }
            else
            {
                len++;
                while (j < nums.length - 1)
                {
                    j++;
                    if (nums[j-1] != nums[j]) break;
                }
                
                while (i < j)
                {
                    i++;
                    if (nums[i-1] != nums[i]) break;
                }
                
            }
        }

        return len;
    }
}

public class DiffK2
{
    public static void main(String[] args)
    {
        List<Integer> arr = Arrays.asList(1, 5, 3);
        
        int tst[] ={6,2,9,3,9,6,7,7,6,4};
        System.out.println(new Solution().findPairs(tst, 3));
    }
}

