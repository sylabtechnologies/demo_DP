package symmetric;

class Solution
{
    public int isSymmetric(TreeNode root)
    {
        if (root == null) return 1;
        return isMirrored(root.left, root.right);
    }

    private int isMirrored(TreeNode ltree, TreeNode rtree)
    {
        if (ltree == null && rtree == null) return 1;
        if (ltree == null && rtree != null) return 0;
        if (ltree != null && rtree == null) return 0;

        if (ltree.val != rtree.val) return 0;
        
        if (isMirrored(ltree.left, rtree.right) == 0) return 0;
        
        return isMirrored(ltree.right, rtree.left);
    }
}

public class Symmetric
{
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(1);
        root.addLeft(2); root.addRight(2);
        
        root.left.addLeft(3);
        root.left.addRight(4);
        
        root.right.addLeft(4);
        root.right.addRight(3);
        
        System.out.println(new Solution().isSymmetric(root));
    }
    
}
