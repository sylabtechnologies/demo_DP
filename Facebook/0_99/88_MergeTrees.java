// https://leetcode.com/problems/merge-two-binary-trees/

class Solution
{
    public TreeNode merge(TreeNode lt, TreeNode rt)
    {
        if (lt == null && rt == null) return null;
        if (lt != null && rt == null) return copy(lt);
        if (lt == null && rt != null) return copy(rt);
        
        TreeNode res = new TreeNode(lt.val + rt.val);
        res.left = merge(lt.left, rt.left);
        res.right = merge(lt.right, rt.right);
        return res;        
    }

    private TreeNode copy(TreeNode root)
    {
        if (root == null) return null;
        
        TreeNode res = new TreeNode(root.val);
        res.left = copy(root.left);
        res.right = copy(root.right);
        return res;
    }
}

