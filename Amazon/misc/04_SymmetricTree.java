// https://leetcode.com/problems/symmetric-tree/

package symmetrictree;

class Solution
{
    public boolean isSymmetric(TreeNode root)
    {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    /// #D = propagate
    private boolean isMirror(TreeNode left, TreeNode right)
    {
        if (left == null && right == null) return true;
        
        if (left != null && right != null)
        {
            if (left.val != right.val) return false;
                
            return isMirror(left.right, right.left) && isMirror(left.left, right.right);
        }
        else
            return false;
    }
}

public class SymmetricTree
{
    public static void main(String[] args)
    {
        TreeNode rt = new TreeNode(1);
        rt.addLeft(2); rt.addRight(2);
        
        rt.left.addLeft(3);
        rt.left.addRight(4);
        
        rt.right.addLeft(4);
        rt.right.addRight(3);

        Solution sl = new Solution();
        System.out.println(sl.isSymmetric(rt));
    }
    
}
