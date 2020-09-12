// https://leetcode.com/problems/subtree-of-another-tree/
package allpaths;
import java.util.*;

class Solution
{
    public boolean isSubtree(TreeNode root, TreeNode sub)
    {
        if (sub == null) return root == null;
        return inorder(root, sub);
    }

    private boolean inorder(TreeNode root, TreeNode sub)
    {
        if (root == null) return false;
        
        if (inorder(root.left, sub))
            return true;
        
        if (compare(root, sub)) return true;
        
        if (inorder(root.right, sub))
            return true;
        
        return false;
    }

    private boolean compare(TreeNode one, TreeNode two)
    {
        if (one == null && two == null) return true;
        if (one == null && two != null) return false;
        if (one != null && two == null) return false;
        
        if (one.val != two.val) return false;

        return compare(one.left, two.left) && compare(one.right, two.right);
        
    }
}


public class CmpTree
{
    public static void main(String[] args)
    {
        TreeNode rt = new TreeNode(3);
        rt.addLeft(4); rt.addRight(5);
        rt.left.addLeft(1);
        rt.left.addRight(2);
        
        TreeNode sub = new TreeNode(4);
        sub.addLeft(1); sub.addRight(2);
        
        System.out.println(new Solution().isSubtree(rt, sub));
    }
    
}
