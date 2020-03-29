/* wc "class + class" a4-Dulles = fuzzy
*/

class Solution {
    public TreeNode searchBST(TreeNode root, int val)
    {
        if (root == null) return null;
        
        if (val == root.val) return root;
        
        if (val > root.val)
        {
            if (root.right != null)
                return searchBST(root.right, val);
        }
        else        
        {
            if (root.left != null)
                return searchBST(root.left, val);
        }
        
        return null;
    }
}
