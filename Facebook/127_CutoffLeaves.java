package badroottoleaf;
import java.util.*;

class Solution
{
    private int cutoff = 0;
    
    public TreeNode sufficientSubset(TreeNode root, int limit)
    {
        cutoff = limit;
        if (root == null) return null;
        
        int sum = 0;
        Integer max = backtrack(root, sum);
        
        if (max == null) return null;
        if (max < cutoff) return null;
        return root;
    }

    private Integer backtrack(TreeNode root, int sum)
    {
        if (root == null) return null;
        
        Integer ret = null;
        sum += root.val;
        if (root.left == null && root.right == null)
            ret = sum;
        else
        {
            Integer leftMax = backtrack(root.left, sum);
            if (leftMax != null && leftMax < cutoff) root.left = null;
            if (leftMax == null) leftMax = Integer.MIN_VALUE;

            Integer rightMax = backtrack(root.right, sum);
            if (rightMax != null && rightMax < cutoff) root.right = null;
            if (rightMax == null) rightMax = Integer.MIN_VALUE;
            ret = Math.max(leftMax, rightMax);
        }
        
        sum -= root.val;
        return ret;
    }
}

public class BadRootToLeaf
{
    public static void main(String[] args)
    {
        TreeNode rt = new TreeNode(2);
        rt.addLeft(7); rt.addRight(2);
        
        rt.left.addLeft(2);
        
        rt.right.addLeft(8); rt.right.left.addLeft(4);
        
        System.out.println(new Solution().sufficientSubset(rt, 15));
    }
    
}

/*
        TreeNode root = new TreeNode(1);
        root.addLeft(2); root.addRight(3);
        
        TreeNode lft = root.left;
        lft.addLeft(4); lft.addRight(-99);
        lft.left.addLeft(8);
        lft.left.addRight(9);
        lft.right.addLeft(-99);
        lft.right.addRight(-99);
        
        TreeNode rgt = root.right;
        rgt.addLeft(-99); rgt.addRight(7);
        rgt.left.addLeft(12);
        rgt.left.addRight(13);
        rgt.right.addLeft(-99);
        rgt.right.addRight(14);

*/