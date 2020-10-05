// https://leetcode.com/problems/non-decreasing-array/ 
// just A or B
package goog7;
import java.util.*;

class Solution
{
    public boolean checkPossibility(int[] nums)
    {
        int hit = findNondecreasing(nums, -1);
        if (hit < 0) return true;
        
        LinkedList<Integer> lst1 = fillnskip(nums, hit);
        LinkedList<Integer> lst2 = fillnskip(nums, hit-1);
        
        return nonDecresase(lst1) || nonDecresase(lst2);
    }

    private int findNondecreasing(int arr[], int skip)
    {
        int hit = -1;
        for (int i = 1; i < arr.length; i++)
        {
            if (i == skip) continue;
            
            if (arr[i-1] > arr[i])
            {
                hit = i; break;
            }
        }

        return hit;
    }

    private LinkedList<Integer> fillnskip(int[] nums, int skip)
    {
        LinkedList<Integer> ret = new LinkedList<>();
        for (int i = 0; i < nums.length; i++)
        {
            if (i == skip) continue;
            ret.add(nums[i]);            
        }
        
        return ret;
    }

    private boolean nonDecresase(LinkedList<Integer> lst)
    {
        for (int i = 1; i < lst.size(); i++)
            if (lst.get(i-1) > lst.get(i)) return false;
        
        return true;
    }
}

public class Goog7
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().checkPossibility(new int[]{4,2,3}));
        System.out.println(new Solution().checkPossibility(new int[]{1,2,1,3,4}));
        System.out.println(new Solution().checkPossibility(new int[]{5,7,1,8}));
    }
}
