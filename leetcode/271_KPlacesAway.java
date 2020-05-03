// https://leetcode.com/problems/check-if-all-1s-are-at-least-length-k-places-away/
package kplacesaway;

class Solution
{
    public boolean kLengthApart(int[] nums, int k)
    {
        int i = 0, len = nums.length;
        
        // find 1
        boolean found = false;
        while (i < len)
        {
            if (nums[i] == 1)
            {
                found = true;
                break;
            }
            i++;
        }
        
        if (!found) return true;
        if (k == 0) return true;
        
        i++; found = false;
        int dist = 0;
        while (i < len)
        {
            if (nums[i] == 1)
            {
                if (found)
                {
                    if (dist < k)
                    {
                        return false;
                    }
                    
                    dist = 0;
                    found = false;
                }
                else
                    return false;
            }
            else
            {
                found = true;
                dist++;
            }

            i++;
        }
        
        return true;
    }
}

public class KPlacesAway
{
    public static void main(String[] args)
    {
        int test[] = {1,0,0,0,1,0,0,1};
        System.out.println(new Solution().kLengthApart(test, 2));
    }
    
}
