// https://leetcode.com/problems/binary-tree-tilt/
package tilt;

class Solution
{
    private int res = 0;
    
    public int findTilt(TreeNode root)
    {
        if (root == null) return 0;
        
        postorder(root); return res;
    }

    // combine w/ lrn sum
    private int postorder(TreeNode root)
    {
        if (root == null) return 0;
        
        int lsum =  postorder(root.left);
        int rsum =  postorder(root.right);
        res += Math.abs(rsum - lsum);
        
        return lsum + rsum + root.val;
    }
}

public class Tilt
{
    public static void main(String[] args)
    {
        TreeNode rt = new TreeNode(1);
        rt.addLeft(2); rt.addRight(3);
        System.out.println(new Solution().findTilt(rt));
    }
    
}
