// recursively cool
// https://leetcode.com/problems/two-sum-iv-input-is-a-bst/

class Solution {
    public boolean findTarget(TreeNode root, int k)
    {
        int delta = k - root.val;
        if ( delta > 0)
        {
            if (root.right == null) return false;
            boolean ok = find(root.right, delta);

            if (ok)
                return true;
            else
                return findTarget(root.right, k);
        }
        else if ( delta < 0)
        {
            if (root.left == null) return false;
            boolean ok = find(root.left, delta);

            if (ok)
                return true;
            else
                return findTarget(root.left, k);
        }
        else return false;
    }

    boolean find(TreeNode root, int val)
    {
        if (val == root.val) return true;
        
        if (val > root.val)
        {
            if (root.right == null) 
                return false;
            else
                return find(root.right, val);
        }
        else
        {
            if (root.left == null) 
                return false;
            else
                return find( root.left, val);
        }
        
    }

}