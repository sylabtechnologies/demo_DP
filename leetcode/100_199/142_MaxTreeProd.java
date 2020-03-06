// https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/
/// GET2FIX

package maxsubtreeprod;
import java.util.*;

class Solution
{
    private final static long MOD = 1000000007;

    // get tree w/ sums of all children
    private static TreeNode nodeSumTree(TreeNode root)
    {
        if (root == null) return null;

        TreeNode res = new TreeNode(root.val);
        res.left = nodeSumTree(root.left);
        res.right = nodeSumTree(root.right);
        
        if (res.left != null) res.val += res.left.val;
        if (res.right != null) res.val += res.right.val;
        return res;
    }
    
    public int maxProduct(TreeNode root)
    {
        // naive
        TreeNode sumnode = nodeSumTree(root);
        
        long maxP = -1;
        
        maxP = findMaxProduct(sumnode, sumnode.val, maxP);
        return (int) (maxP % MOD);
    }

    private static long findMaxProduct(TreeNode root, int top, long maxProd)
    {
        if (root.left != null)
        {
            long leftP = root.left.val * (top - root.left.val);
            maxProd = Math.max(maxProd, leftP);

            leftP = findMaxProduct(root.left, top, maxProd);
            maxProd = Math.max(maxProd, leftP);
        }

        if (root.right != null)
        {
            long rightP = root.right.val * (top - root.right.val);
            maxProd = Math.max(maxProd, rightP);

            rightP = findMaxProduct(root.right, top, maxProd);
            maxProd = Math.max(maxProd, rightP);
        }
        
        return maxProd;
    }
    
    private int getProdAbove(TreeNode root, TreeNode stop)
    {
        if (root == stop) return 1;
            
        int prod = root.val;
        
        if (root.left != null)
            prod *= getProdAbove(root.left, stop);

        if (root.right != null)
            prod *= getProdAbove(root.right, stop);
        
        return prod;
    }
    
    private void printInorder(TreeNode root)
    {
        if (root.left != null) printInorder(root.left);
        System.out.print(root.val + " ");
        if (root.right != null) printInorder(root.right);
    }

    private int getProduct(TreeNode root)
    {
        int prod = root.val;
        
        if (root.left != null)
            prod *= getProduct(root.left);

        if (root.right != null)
            prod *= getProduct(root.right);
        
        return prod;
    }

    private void getTreeCuts(TreeNode root, List<TreeNode> cuts)
    {
        if (root.left != null)
        {
            cuts.add(root.left);
            getTreeCuts(root.left, cuts);
        }
        
        if (root.right != null)
        {
            cuts.add(root.right);
            getTreeCuts(root.right, cuts);
        }
    }

}

/*
class Solution
{
    long res = 0, total = 0, sub;
    public int maxProduct(TreeNode root) {
        total = s(root); s(root);
        return (int)(res % (int)(1e9 + 7));
    }

    private long s(TreeNode root) {
        if (root == null) return 0;
        sub = root.val + s(root.left) + s(root.right);
        res = Math.max(res, sub * (total - sub));
        return sub;
    }

}

*/
