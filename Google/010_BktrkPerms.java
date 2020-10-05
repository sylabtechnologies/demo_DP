// https://leetcode.com/problems/next-permutation/ ADD DUPS
package goog7;
import java.util.*;

class Solution
{
    private boolean found = false, done = false;
    private boolean visited[];
    private int llNums;
    private int target[];
    
    public void nextPermutation(int[] nums)
    {
        llNums = nums.length;
        if (llNums <= 1) return;
        
        visited = new boolean[llNums];
        int temp[] = Arrays.copyOf(nums, llNums);
        target = nums;
        Arrays.sort(temp);
        
        backtrack(temp, new ArrayList<Integer>());
        
        // if found = T done = F  we got next perm;
        for (int i = 0; i < temp.length; i++)
            nums[i] = temp[i];
        
        return;
    }

    private void backtrack(int[] arr, ArrayList<Integer> lst)
    {
        if (lst.size() == llNums)
        {
//             System.out.println(lst);
            
            if (found)
            {
                for (int i = 0; i < lst.size(); i++)
                    arr[i] = lst.get(i);

                done = true;
                return;
            }

            boolean allOK = true;
            for (int i = 0; i < lst.size(); i++)
            {
                if (target[i] != lst.get(i))
                {
                    allOK = false;
                    break;
                }                
            }

            found = allOK;
            return;
        }
        
        for (int i = 0; i < llNums; i++)
        {
            if (visited[i]) continue;
            
            visited[i] = true;
            lst.add(arr[i]);
            backtrack(arr, lst);
            
            if (done) return;
            
            visited[i] = false;;
            lst.remove(lst.size() - 1);
        }
    }
}

public class Goog7
{
    public static void main(String[] args)
    {
        int arr[] = {1,2,3,4};
        Solution sl = new Solution();
        sl.nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }
}
