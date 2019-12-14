// https://leetcode.com/problems/validate-binary-search-tree/

package validbst;


public class Solution
{
    public static boolean isValidBST(TreeNode root, long minVal, long maxVal)
    {
        if (root == null) return true;
        
        boolean leftOK = isValidBST(root.left, minVal, root.val);
        if (!leftOK) return false;

        boolean rightOK = isValidBST(root.right, root.val, maxVal);
        if (!rightOK) return false;

        return root.val < maxVal && root.val > minVal;
    }
    
    public static boolean isValidBST(TreeNode root)
    {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}

/*
    if (root == null) return true;

    if (root.left == null && root.right == null)
        return true;

    boolean leftOK = isValidBST(root.left);
    if (leftOK && root.left != null)
        leftOK = root.left.val < root.val;

    if (!leftOK) return leftOK;

    boolean rghtOK = isValidBST(root.right);
    if (rghtOK && root.right != null)
        rghtOK = root.right.val > root.val;

    return rghtOK;
*/