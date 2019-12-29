// https://leetcode.com/problems/deepest-leaves-sum/

package deepestleaves;

import java.util.*;

class Solution      // set in-pkg
{
    private HashMap<Integer, Integer> depthSum = new HashMap<>();
    private int maxDepth = 0;
    
    private void inorder(int depth, TreeNode root)
    {
        if (root.left != null) inorder(depth + 1, root.left);

        Integer sum = depthSum.get(depth);
        if (sum != null)
        {
            depthSum.put(depth, sum + root.val);
        }
        else
        {
            depthSum.put(depth, root.val);
            if (depth > maxDepth) maxDepth = depth;
        }
        
        if (root.right != null) inorder(depth + 1, root.right);
    }    
    
    public int deepestLeavesSum(TreeNode root)
    {
        depthSum.clear(); maxDepth = 0;
        inorder(1, root);
        return depthSum.get(maxDepth);
    }
}

class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int x) { val = x; }
    void addLeft(int val) { this.left = new TreeNode(val); }
    void addRight(int val) { this.right = new TreeNode(val); }
}