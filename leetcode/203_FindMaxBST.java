// https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/
// 2^31 ok for 40000^2 ? find all BST sums in range a..b

package findmaxbst;

class Solution
{
    private static int maxSum;
            
    public int maxSumBST(TreeNode root)
    {
        maxSum = Integer.MIN_VALUE;
        int bstSum = checkBST(root);
        return maxSum;
    }

    // do inorder
    private int checkBST(TreeNode root)
    {
        boolean isBST = true;
        
        if (root.left != null)
            if (root.left.val >= root.val) isBST = false;

        if (isBST && root.right != null)
            if (root.right.val <= root.val) isBST = false;

        // check subtrees
        int lres = 0, rres = 0;
        if (root.left != null)
        {
            lres = checkBST(root.left);
            if (lres < 0)
                isBST = false;
            else
                if (lres > maxSum) maxSum = lres;
        }
        
        if (root.right != null)
        {
            rres = checkBST(root.right);
            if (rres < 0)
                isBST = false;
            else 
                if (rres > maxSum) maxSum = rres;
        }

        return (isBST) ? lres + rres + root.val : -1;
    }
}
