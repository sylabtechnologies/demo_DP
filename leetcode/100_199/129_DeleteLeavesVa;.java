// https://leetcode.com/problems/delete-leaves-with-a-given-value/submissions/
// make valid recursion

class Solution
{
    public TreeNode removeLeafNodes(TreeNode root, int target)
    {
        if (root.left != null)
        {
            TreeNode test = removeLeafNodes(root.left, target);
            if (test == null)
                root.left = null;
        }

        if (root.right != null)
        {
            TreeNode test = removeLeafNodes(root.right, target);
            if (test == null)
                root.right = null;
        }
        
        TreeNode res = null;
        if (root.left == null && root.right == null)
        {
            if (root.val != target)
                res = root;
        }
        else res = root;
        
        return res;
    }
    
}