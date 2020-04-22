// https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
// find perfect 1:1

package preorder2bst;

class Solution
{
    public TreeNode bstFromPreorder(int[] preorder)
    {
        TreeNode root = null;
        for (int n : preorder)
            root = insert(root, n);
        
        return root;
    }

    private TreeNode insert(TreeNode root, int val)
    {
        if (root == null) return new TreeNode(val);
        
        if (val < root.val)
            root.left = insert(root.left, val);
        else
            root.right = insert(root.right, val);
        
        return root;
    }
}

public class Preorder2BST
{
    public static void main(String[] args)
    {
        int pre[] = {8,5,1,7,10,12};
        System.out.println(new Solution().bstFromPreorder(pre));
    }
    
}
