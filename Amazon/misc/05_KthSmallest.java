// https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/
// https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/?
package kthsmallest;

class Solution
{
    public int kthSmallest(TreeNode root, int k)
    {
        return seekRank(root, k);
    }
    
    //# bin seek count #cellZ
    private int seekRank(TreeNode root, int k)
    {
        if (root == null) throw new IllegalArgumentException("seek");

        int myRank = count(root.left) + 1;

        if (k == myRank)
            return root.val;
        else if (k > myRank)
            return seekRank(root.right, k - myRank);
        else
            return seekRank(root.left, k);
    }

    private int count(TreeNode root)
    {
        if (root == null) return 0;
        
        return 1 + count(root.left) + count(root.right);
    }
}

public class KthSmallest
{
    public static void main(String[] args)
    {
        TreeNode rt = new TreeNode(3);
        rt.addLeft(1); rt.addRight(4);
        rt.left.addRight(2);
        
        Solution sl = new Solution();
        sl.kthSmallest(rt, 4);
    }
    
}
