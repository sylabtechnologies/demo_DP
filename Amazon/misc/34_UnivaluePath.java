package univaluepath;

class Solution
{
    private int LongestPath = 0;
    public int longestUnivaluePath(TreeNode root)
    {
        helper(root);
        return LongestPath;
    }
    
    public int helper(TreeNode root)
    {
        int ans = 0;
        if (root == null) return ans;
        
        int ll = helper(root.left);
        int rr = helper(root.right);

        int leftMax = 0, rghtMax = 0; // set to zero if broke
        if (root.left != null && root.val == root.left.val)
            leftMax = ll + 1;
        
        if (root.right != null && root.val == root.right.val)
            rghtMax = rr + 1;
                
        LongestPath = Math.max(LongestPath, leftMax + rghtMax);
        return Math.max(leftMax, rghtMax);
    }
}

