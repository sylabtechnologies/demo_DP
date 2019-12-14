package maxdepth;

public class MaxDepth
{
    public static int maxDepth(TreeNode root)
    {
        if (root == null) return 0;            
        if (root.left == null && root.right == null) return 1;
        
        int leftMax = 0;
        if (root.left == null)
            leftMax = 0;
        else
            leftMax = maxDepth(root.left);
        
        int rightMax = 0;
        if (root.right == null)
            rightMax = 0;
        else
            rightMax = maxDepth(root.right);
        
        return 1 + Math.max(leftMax, rightMax);
    }

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(3);
        
        TreeNode left = new TreeNode(9);
        
        TreeNode right = new TreeNode(20);
        right.addLeft(new TreeNode(15));
        right.addRight(new TreeNode(7));
        
        root.addLeft(left);
        root.addRight(right);
        
        System.out.println(maxDepth(root));
        
    }
    
}
