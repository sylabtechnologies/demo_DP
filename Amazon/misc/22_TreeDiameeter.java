package treediameeter;

class Solution
{
    public int diameterOfBinaryTree(TreeNode root)
    {
        return longest(root);
    }
    
    private int longest(TreeNode root) 
    { 
        if (root == null) return 0; 

        int lh = treeHeight(root.left); 
        int rh = treeHeight(root.right); 

        int lmax = longest(root.left); 
        int rmax = longest(root.right); 

        return Math.max(lh + rh, Math.max(lmax, rmax)); 
    } 

    private int treeHeight(TreeNode root)
    {
        if (root == null) return 0;
        return 1 + Math.max(treeHeight(root.left), treeHeight(root.right)); 
    }
}

public class TreeDiameeter
{
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(1);
        root.addLeft(2); root.addRight(3);
        
        root.left.addLeft(4);
        root.left.addRight(5);
        
        System.out.println(new Solution().diameterOfBinaryTree(root));
    }
    
}
