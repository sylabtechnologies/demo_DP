// https://leetcode.com/problems/inorder-successor-in-bst/

class Solution
{
    private ArrayList<TreeNode> traversal;
    
    public TreeNode inorderSuccessor(TreeNode root, TreeNode node)
    {
        if (node.right != null)
        {
            TreeNode successor = node.right;
            while (successor.left != null)
                successor = successor.left;
            
            return successor;
        }
        
        traversal = new ArrayList<>();
        inorder(root, node);
        if (traversal.size() == 1)
            return null;
        else
            return traversal.get(1);
    }

    private void inorder(TreeNode root, TreeNode seek)
    {
        if (root == null) return;
        if (traversal.size() >= 2) return;
        
        inorder(root.left, seek);
        
        if (root.val >= seek.val)
            traversal.add(root);
        
        inorder(root.right, seek);
    }
}
