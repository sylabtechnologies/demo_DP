// https://leetcode.com/problems/balanced-binary-tree/
/* follow spec */

package balancedtree;
import java.util.*; 

class Solution
{
    public boolean isBalanced(TreeNode root)
    {
        return height(root) != -1;
    }
    
    private int height(TreeNode root)
    {
        if(root == null) return 0;
        
        int left = height(root.left);
        
        int right = height(root.right);
        
        if(left == -1 || right == -1) return -1;
        
        if(Math.abs(left - right) > 1)
            return -1;
        else
            return Math.max(left, right) + 1;
    }
}

public class BalancedTree
{
    public static void main(String[] args)
    {
        /*
        TreeNode root = new TreeNode(3);
        root.addLeft(9);
        root.addRight(20);
        
        root.right.addLeft(15);
        root.right.addRight(7);
        */

        TreeNode root = new TreeNode(1);
        root.addLeft(2);
        
        Solution sl = new Solution();
        System.out.println(sl.isBalanced(root));
    }
    
}
