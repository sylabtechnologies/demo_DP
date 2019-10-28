/* https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

 * do recursively, flatten children and attach right to left

 */
package flattentree;

class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int x) { val = x; }

    TreeNode(int x, int ll, int rr)
    { 
        val = x;
        left  = new TreeNode(ll);
        right = new TreeNode(rr);
    }
    
    TreeNode(int x, TreeNode ll, TreeNode rr)
    { 
        val = x;
        left  = ll;
        right = rr;
    }
    
}

public class FlattenTree
{
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        
        TreeNode rr = new TreeNode(5);
        rr.right    = new TreeNode(6);
        TreeNode ll = new TreeNode(2, 3, 4);
        TreeNode tree = new TreeNode(1, ll, rr);
        
        sol.flatten(tree);
        
        for (TreeNode curr = tree; curr != null; curr = curr.right)
        {
            System.out.println(curr.val);
        }
        
    }
    
}

class Solution
{
    public void flatten(TreeNode root)
    {
        if (root == null) return;
        flatten(root.left);
        flatten(root.right);
        
        TreeNode temp = root.right;
        root.right = root.left;
        root.left  = null;
        
        // find the end
        while (root.right != null)
            root = root.right;
        
        root.right = temp;
    }
}
