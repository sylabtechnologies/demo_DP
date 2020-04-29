// https://leetcode.com/problems/binary-tree-maximum-path-sum/

package treemaxpath;

class Solution
{
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root)
    {
        findMax(root);
        return maxSum;
    }

    public int findMax(TreeNode root)
    {
        if (root == null) return 0;
        
        int leftPath = Math.max(findMax(root.left), 0);
        int rghtPath = Math.max(findMax(root.right), 0);

        // try the node
        int newPath = root.val + leftPath + rghtPath;
        maxSum = Math.max(maxSum, newPath);
        
        // pick left or right
        return root.val + Math.max(leftPath, rghtPath);
    }
}

public class TreeMaxPath
{
    public static void main(String[] args)
    {
        TreeNode rt = new TreeNode(-10);
        rt.addLeft(9); rt.addRight(20);
        rt.right.addLeft(15); rt.right.addRight(7);
        
        Solution sl = new Solution();
        int res = sl.maxPathSum(rt);
        System.out.println(res);
    }
    
}
