// https://leetcode.com/problems/count-good-nodes-in-binary-tree/
package goodnodes;

class Solution
{
    public int goodNodes(TreeNode root)
    {
        int good = 1, goodVal = root.val;
        good += maxPath(root.left, goodVal) + maxPath(root.right, goodVal);
        return good;
    }

    private int maxPath(TreeNode root, int goodVal)
    {
        if (root == null) return 0;
        
        int good = 0;
        if (root.val >= goodVal) good++;
        
        int max = Math.max(root.val, goodVal);
        good += maxPath(root.left, max);
        good += maxPath(root.right, max);
        
        return good;
    }
}

public class GoodNodes
{
    public static void main(String[] args)
    {
        TreeNode rt = new TreeNode(3);
        rt.addLeft(1); rt.addRight(4);
        rt.left.addRight(3);
        
        rt.right.addLeft(1);
        rt.right.addRight(5);

//        rt = new TreeNode(9);
//        rt.addRight(3); rt.right.addLeft(6);
        
        System.out.println(new Solution().goodNodes(rt));
    }
    
}
