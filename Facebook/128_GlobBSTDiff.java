// https://leetcode.com/problems/minimum-absolute-difference-in-bst/

package allpaths;
import java.util.*;

class Solution
{
    private int globalMin;
    
    public int getMinimumDifference(TreeNode root)
    {
        globalMin = Integer.MAX_VALUE;
        int range[] = inorder(root);
        return globalMin;
    }

    private int[] inorder(TreeNode root)
    {
        if (root == null) return null;

        int ret[] = {root.val, root.val};
        
        int left[] = inorder(root.left);
        if (root.left != null)
        {
            ret[0] = left[0];
            globalMin = Math.min(globalMin, root.val - left[1]);
        }
        
        int rght[] = inorder(root.right);
        if (root.right != null)
        {
            ret[1] = rght[1];
            globalMin = Math.min(globalMin, rght[0] - root.val);
        }
        
        return ret;
    }
}

public class GlobDiff
{
    public static void main(String[] args)
    {
        TreeNode rt = new TreeNode(236);
        rt.addLeft(104); rt.addRight(701);
        rt.left.addRight(227);
        rt.right.addRight(911);
        
        System.out.println(new Solution().getMinimumDifference(rt));
    }
    
}
