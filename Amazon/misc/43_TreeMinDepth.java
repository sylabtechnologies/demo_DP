// https://leetcode.com/problems/minimum-depth-of-binary-tree/
package treemindepth;

class Solution
{
    public int minDepth(TreeNode root)
    {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        
        int d1 = (root.left == null) ? Integer.MAX_VALUE : minDepth(root.left) + 1;
        int d2 = (root.right == null) ? Integer.MAX_VALUE : minDepth(root.right) + 1;
        return Math.min(d1, d2);
    }
}

public class TreeMinDepth
{
    public static void main(String[] args)
    {
        TreeNode rt = new TreeNode(3);
        rt.addLeft(9); rt.addRight(20);
        rt.right.addLeft(15); rt.right.addRight(7);
        System.out.println(new Solution().minDepth(rt));
    }
}
