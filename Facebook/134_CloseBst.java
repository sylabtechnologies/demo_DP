// https://leetcode.com/problems/closest-binary-search-tree-value/

class Solution
{
    private long range[];
    public int closestValue(TreeNode root, double target)
    {
        range = new long[] {Long.MIN_VALUE, Long.MAX_VALUE};
        inorder(root, target);
        
        double d1 = target - range[0];
        double d2 = range[1] - target;
        return (int) ((d1 > d2) ? range[1] : range[0]);
    }

    private void inorder(TreeNode root, double target)
    {
        if (root == null) return;
        
        if (root.val == target)
        {
            range = new long[] {root.val, root.val};
            return;
        }
        
        if (root.val < target)
        {
            if (root.val > range[0]);
                range[0] = root.val;
            
            inorder(root.right, target);
        }
        else
        {
            if (root.val < range[1]);
                range[1] = root.val;

            inorder(root.left, target);
        }
    }
}

