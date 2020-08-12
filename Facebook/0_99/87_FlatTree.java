// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
package flattree;

class Solution
{
    // lrn
    public TreeNode flatten(TreeNode root)
    {
        if (root == null) return null;
        
        TreeNode lft = flatten(root.left);
        TreeNode rgt = flatten(root.right);
        
        root.left = null;
        
        TreeNode curr = null;
        if (lft != null)
        {
            root.right = lft;
            curr = lft;
            while(curr.right != null)
                curr = curr.right;
        }
        
        if (curr != null)
            curr.right = rgt;
        else
            root.right = rgt;;
            
        return root;
    }
}

public class FlatTree
{
    public static void main(String[] args)
    {
        TreeNode rt = new TreeNode(1);
        rt.addLeft(2); rt.addRight(5);
        
        rt.left.addLeft(3);
        rt.left.addRight(4);
        
        rt.right.addRight(6);
        
        System.out.println(new Solution().flatten(rt));
    }
    
}
