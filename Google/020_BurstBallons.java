package duptree;
import java.util.*;

// https://leetcode.com/problems/burst-balloons/
// absolute dfs
class Solution
{
    private Integer[][] memo;
    
    public int maxCoins(int[] nums)
    {
        memo = new Integer[nums.length][nums.length];
        return maxCoins(nums, 0, nums.length-1);
    }

    
    private int maxCoins(int[] nums, int start, int fin)
    {
        if(start > fin) return 0;
        if(memo[start][fin] != null) return memo[start][fin];
    
        int leftVal = imagineNum(nums,  start-1);
        int rightVal = imagineNum(nums, fin+1);
    
        if(start == fin) return leftVal*nums[start]*rightVal;
    
        int max = Integer.MIN_VALUE, maxi = 0;
        for(int i = start; i <= fin; ++i )
        {
            int num = nums[i];
            int left = maxCoins(nums, start, i-1);
            int right = maxCoins(nums, i+1, fin);
            int total = leftVal * num * rightVal + left + right;
            
            if (total > max)
            {
                max = Math.max(max,total);
                maxi = num;
            }
        }
    
        memo[start][fin] = max;
        System.out.println("get " + maxi + " in (" + start + ", " + fin + ")");
        return max;
    }

    private static int imagineNum(int[] nums, int ix)
    {
        if (ix < 0)
            return 1;
        if (ix >= nums.length)
            return 1;
        return nums[ix];
    }    
}

public class Dups
{
    public static void main(String[] args)
    {
        int arr[] = {35,16,83,87,84,59,48,41};
        System.out.println(new Solution().maxCoins(arr));
    }
}
        
/*

    must be 1088290
    cleaner solution - MatLink adjacent matrices and their PQ?
        
     System.out.println(new Solution().maxCoins(new int[] {3,1,5,8}));
      System.out.println(new Solution().maxCoins(new int[] {9,76,64,21,97,60,5}));
   

class Solution
{
    public TreeNode trimBST(TreeNode root, int low, int high)
    {
        if (root == null) return null;
        
        if (low < root.val)
            trimBST(root.left, low, root.val);
        
        if (high > root.val)
            trimBST(root.right, low, root.val);
    }
}

     int arr[] = {1, 2, 3};
     TreeNode rt = new TreeNode(15);
     rt.addRight(18);
     rt.right.addLeft(17);
     rt.right.addRight(20);

    TreeNode rt = new TreeNode(7);
    rt.addLeft(4); rt.addRight(3);
    rt.right.addLeft(6);
    rt.right.addRight(19);

    int test[] = {6, 5, 3, 1, 8, 7}; //  {4,2,1,3};
    ListNode ls = new ListNode(test[0]);
    for (int i = 1; i < test.length; i++)
        ls.append(test[i]);            
    System.out.println(new Solution().insertionSortList(ls));  

*/

