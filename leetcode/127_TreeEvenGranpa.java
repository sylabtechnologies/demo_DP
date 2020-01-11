/**
 * Given a binary tree, return the sum of values of nodes with even-valued grandparent.
 * (A grandparent of a node is the parent of its parent, if it exists.)
 * 
 * hl1: recursive
 * 
 */

package treeevenparent;

class Solution
{
    public int sumEvenGrandparent(TreeNode root)
    {
        if (root == null) return 0;
        
        int res = 0;
        if (root.val % 2 == 0)
        {
            res += childSum(root.left) +  childSum(root.right);
        }
     
        return res + sumEvenGrandparent(root.left) + sumEvenGrandparent(root.right);
    }

    private int childSum(TreeNode root)
    {
        int res = 0;

        if (root == null) return res;
        if (root.left != null) res += root.left.val;
        if (root.right != null) res += root.right.val;
        
        return res;
    }

}